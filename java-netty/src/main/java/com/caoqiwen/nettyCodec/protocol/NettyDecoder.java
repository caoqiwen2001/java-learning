package com.caoqiwen.nettyCodec.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class NettyDecoder extends ByteToMessageDecoder {

    private Class<?> cls;

    public NettyDecoder(Class cls) {
        this.cls = cls;

    }

    @Override
    public final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();
        /*if (dataLength <= 0) {
            ctx.close();
        }*/
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return;
        }
        byte[] data = new byte[dataLength];
        in.readBytes(data);

        Object obj = SerializationUtil.deserialize(data, cls);
        //Object obj = JsonUtil.deserialize(data,genericClass); // Not use this, have some bugs
        out.add(obj);
    }
}
