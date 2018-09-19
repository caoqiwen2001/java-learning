package com.caoqiwen.nettyCodec.protocol;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class NettyEncoder extends MessageToByteEncoder {

    private Class cls;

    public NettyEncoder(Class cls) {
        this.cls = cls;
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Object in, ByteBuf out) throws Exception {
        if (cls.isInstance(in)) {
            byte[] data = SerializationUtil.serialize(in);
            //byte[] data = JsonUtil.serialize(in); // Not use this, have some bugs
            out.writeInt(data.length);
            out.writeBytes(data);
        }
    }
}
