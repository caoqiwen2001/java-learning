package com.caoqiwen.nettyCodec;

import com.caoqiwen.nettyCodec.protocol.NettyDecoder;
import com.caoqiwen.nettyCodec.protocol.NettyEncoder;
import com.caoqiwen.nettyCodec.protocol.NettyRequest;
import com.caoqiwen.nettyCodec.protocol.NettyResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.HashedWheelTimer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

public class HeartBeatsClient {
    private final Logger logger = LoggerFactory.getLogger(ConnectionWatchdog.class);
    private final HashedWheelTimer timer = new HashedWheelTimer();
    private final ConnectorIdleStateTrigger trigger = new ConnectorIdleStateTrigger();
    Bootstrap bootstrap = null;
    HeartBeatClientHandler handler = null;

    public HeartBeatClientHandler connect(int port, String host) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {
            bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO));

            //这里加入watch dog  进行监控
            ConnectionWatchdog watchdog = new ConnectionWatchdog(timer, bootstrap, port, host) {
                @Override
                public ChannelHandler[] handlers() {
                    return new ChannelHandler[]{this,
                            new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS),
                            new NettyDecoder(NettyResponse.class), new NettyEncoder(NettyRequest.class), trigger, new HeartBeatClientHandler()
                    };
                }
            };

             ChannelFuture future = null;
            synchronized (bootstrap) {
                bootstrap.handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(watchdog.handlers());
                    }
                });
                future = bootstrap.connect(host, port);

            }
            //这一段执行完自动关闭了？
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(final ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        logger.debug("Successfully connect to remote server");
                        handler = channelFuture.channel().pipeline().get(HeartBeatClientHandler.class); //拿到对应的handler
                        //客户端如何管理对应的handler？
                         countDownLatch.countDown();  //异步操作

                    }
                }
            });
            countDownLatch.await();
            future.channel().closeFuture().sync();  //阻塞
        } catch (Exception ex) {
            logger.error("start client has error" + ex.getMessage());
        }

        return handler;
    }

    public static void main(String[] args) throws InterruptedException {
//        HeartBeatsClient client = new HeartBeatsClient();
//        HeartBeatClientHandler handler = client.connect(8010, "127.0.0.1");
//        NettyRequest request = new NettyRequest();
//        request.setRequestId(UUID.randomUUID().toString());
//        request.setClassName();
//        request.setMethodName();
//        handler.sendRequet();
    }
}
