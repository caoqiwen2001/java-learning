package com.caoqiwen.nettyCodec;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * watch dog 自动检测链路
 */
@ChannelHandler.Sharable
public abstract class ConnectionWatchdog extends ChannelInboundHandlerAdapter implements TimerTask, ChannelHandlerHolder {
    private final Logger logger = LoggerFactory.getLogger(ConnectionWatchdog.class);
    private final Timer timer;
    private final Bootstrap bootstrap;
    private final int port;
    private final String host;
    private volatile boolean reconnect = true;
    private int attempt;

    public ConnectionWatchdog(Timer timer, Bootstrap bootstrap, int port, String host) {
        this.timer = timer;
        this.bootstrap = bootstrap;
        this.port = port;
        this.host = host;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // System.out.println("当前链路已经激活了，重置链路的链接次数为0");
        logger.info("当前链路已经激活了，重置链路的链接次数为0");
        attempt = 0;
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        logger.info("当前链路挂了，开始重连");
        if (reconnect) {
            logger.info("重连开始");
            if (attempt < 12) {
                attempt++;
                long timeout = 2 << attempt;   //延迟时间
                timer.newTimeout(this, timeout, TimeUnit.MILLISECONDS);
            }
        }
        ctx.fireChannelInactive();
    }


    @Override
    public void run(Timeout timeout) throws Exception {
        ChannelFuture future = null;
        synchronized (bootstrap) {
            bootstrap.handler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel channel) throws Exception {
                    channel.pipeline().addLast(handlers());
                }
            });
            future = bootstrap.connect(host, port);
        }

        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture f) throws Exception {
                boolean succeed = f.isSuccess();
                logger.warn("Reconnects with {}, {}.", host, succeed ? "succeed" : "failed");
                if (!succeed) {
                    System.out.println("重连失败");
                    f.channel().pipeline().fireChannelInactive();
                } else {
                    System.out.println("重连成功");
                }
            }
        });
    }

}
