package com.caoqiwen.nettyCodec;

import com.caoqiwen.nettyCodec.protocol.NettyDecoder;
import com.caoqiwen.nettyCodec.protocol.NettyEncoder;
import com.caoqiwen.nettyCodec.protocol.NettyRequest;
import com.caoqiwen.nettyCodec.protocol.NettyResponse;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 此版本没有加入 消息序列化相关信息，下个版本加入序列化信息
 */
public class HeartBeatServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeartBeatServer.class);

    private final AcceptorIdleStateTrigger trigger = new AcceptorIdleStateTrigger();

    public void bind(int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).
                    childHandler(new HeartBeatServer.ChildChannelHandler()).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);
            ;
            ChannelFuture f = bootstrap.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (Exception ex) {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }


    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new IdleStateHandler(5, 0, 0, TimeUnit.SECONDS)).
                    addLast(new NettyDecoder(NettyRequest.class)).addLast(new NettyEncoder(NettyResponse.class)).addLast(trigger)
                    .addLast(new HeartBeatServerHandler());
        }
    }

    public static void main(String args[]) {
        HeartBeatServer beatServer = new HeartBeatServer();
        beatServer.bind(8010);
    }
}
