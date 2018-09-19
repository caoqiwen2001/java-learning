package com.caoqiwen.nettyIdle;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


@ChannelHandler.Sharable
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {

//    private int lose_count = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg;
        System.out.println(message);
    }

//    /**
//     * 这里就是一个定时器，每隔几秒钟就去跑，检测有没有心跳,有心跳就保持，没有心跳就挂掉
//     *
//     * @param ctx
//     * @param evt
//     * @throws Exception
//     */
//    @Override
//    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
//        if (evt instanceof IdleStateEvent) {
//            IdleStateEvent event = (IdleStateEvent) evt;
//            if (event.state() == IdleState.READER_IDLE) {
//                lose_count++;
//                System.out.println("5秒没有收到数据");
//            }
//            if (lose_count > 2) {
//                System.out.println("关闭这个不活跃的Channel");
//                ctx.channel().close();
//            }
//        }
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }

//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        // ctx.fireChannelInactive();
//        System.out.println("HeartBeatServiceHandler channelInactive");
//    }
}
