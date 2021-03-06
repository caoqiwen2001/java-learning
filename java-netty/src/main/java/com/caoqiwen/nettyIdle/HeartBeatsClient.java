package com.caoqiwen.nettyIdle;

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

import java.util.concurrent.TimeUnit;

public class HeartBeatsClient {
    private final Logger logger = LoggerFactory.getLogger(ConnectionWatchdog.class);

    private final HashedWheelTimer timer = new HashedWheelTimer();

    private final ConnectorIdleStateTrigger trigger = new ConnectorIdleStateTrigger();

    Bootstrap bootstrap = null;

    public void connect(int port, String host) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            //   Bootstrap bootstrap = new Bootstrap();
//            bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(
//                    new ChannelInitializer<SocketChannel>() {
//
//                        @Override
//                        protected void initChannel(SocketChannel socketChannel) throws Exception {
//                            socketChannel.pipeline().addLast(new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS)).addLast(trigger).addLast(new StringDecoder()).addLast(new StringEncoder())
//                                    .addLast(new HeartBeatClientHandler());
//                        }
//                    }
//            );
            bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO));

            //这里加入watch dog  进行监控
            ConnectionWatchdog watchdog = new ConnectionWatchdog(timer, bootstrap, port, host) {
                @Override
                public ChannelHandler[] handlers() {
                    return new ChannelHandler[]{this,
                            new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS), trigger,
                            new StringDecoder(), new StringEncoder(), new HeartBeatClientHandler()
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
            future.sync();
        } catch (Exception ex) {
            logger.error("start client has error" + ex.getMessage());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        HeartBeatsClient client = new HeartBeatsClient();
        client.connect(8010, "127.0.0.1");
    }
}
