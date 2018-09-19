package com.caoqiwen.nettyCodec;

import com.caoqiwen.nettyCodec.protocol.NettyRequest;
import com.caoqiwen.nettyCodec.protocol.NettyResponse;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

import java.util.UUID;

@ChannelHandler.Sharable
public class ConnectorIdleStateTrigger extends ChannelInboundHandlerAdapter {

    private static final ByteBuf HEARTBEAT_SEQUENCE = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Heartbeat123",
            CharsetUtil.UTF_8));


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.WRITER_IDLE) {
                System.out.println("客户端待写");
                NettyRequest request = new NettyRequest();
                request.setRequestType(NettyRequest.REQUEST_TYPE.HEART);
                request.setRequestId(UUID.randomUUID().toString());
                ctx.writeAndFlush(request);
            } else {
                super.userEventTriggered(ctx, evt);
            }
        }
    }

}
