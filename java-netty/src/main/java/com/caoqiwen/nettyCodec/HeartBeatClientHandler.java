package com.caoqiwen.nettyCodec;

import com.alibaba.fastjson.JSON;
import com.caoqiwen.nettyCodec.protocol.NettyRequest;
import com.caoqiwen.nettyCodec.protocol.NettyResponse;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

@ChannelHandler.Sharable
public class HeartBeatClientHandler extends SimpleChannelInboundHandler<NettyResponse> {

    private final static Logger LOGGER = LoggerFactory.getLogger(HeartBeatsClient.class);

    private int currentTime = 0;
    private Channel channel;

    private static final ByteBuf HEARTBEAT_SEQUENCE = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Heartbeat",
            CharsetUtil.UTF_8));


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        LOGGER.info("ctx channel has registerd");
        super.channelRegistered(ctx);
        this.channel = ctx.channel();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("激活时间是：" + new Date());
        System.out.println("HeartBeatClientHandler channelActive");
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("停止时间是：" + new Date());
        System.out.println("HeartBeatClientHandler channelInactive");
        ctx.fireChannelInactive();
    }

//    @Override
//    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
//        String message = (String) msg;
//        System.out.println(message);
//        if (message.equals("Heartbeat")) {
//            ctx.write("has read message from server");
//            ctx.flush();
//        }
//        ReferenceCountUtil.release(msg);
//    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, NettyResponse nettyResponse) throws Exception {
        LOGGER.info("客户端收到消息" + nettyResponse.toString());
        String meg = nettyResponse.getMsg();
        Object result = nettyResponse.getResult();
        String result1 = JSON.toJSONString(result);
        System.out.println(result1);
        ReferenceCountUtil.release(nettyResponse);
    }


    public void sendRequet(NettyRequest request) {
        final CountDownLatch latch = new CountDownLatch(1);
        channel.writeAndFlush(request).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                latch.countDown();
            }
        });
        try {
            latch.await();
            LOGGER.info("sendRequest has success...");
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("thie error is message:" + cause);
        cause.printStackTrace();
        ctx.channel().close();
    }
}
