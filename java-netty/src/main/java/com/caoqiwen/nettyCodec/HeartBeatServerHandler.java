package com.caoqiwen.nettyCodec;

import com.caoqiwen.nettyCodec.protocol.NettyRequest;
import com.caoqiwen.nettyCodec.protocol.NettyResponse;
import io.netty.channel.*;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


@ChannelHandler.Sharable
public class HeartBeatServerHandler extends SimpleChannelInboundHandler<NettyRequest> {

    private final Logger logger = LoggerFactory.getLogger(HeartBeatServerHandler.class);

    public static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    private final ExecutorService executor = Executors.newFixedThreadPool(AVAILABLE_PROCESSORS << 1);


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("error msg", cause);
        ctx.channel().close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务端挂了");
        ctx.fireChannelInactive();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, NettyRequest nettyRequest) throws Exception {
        if (nettyRequest.getRequestType() == NettyRequest.REQUEST_TYPE.HEART) {
            logger.info("客户端发送心跳");
            return;
        }
        if (executor != null) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    logger.info("服务端开始执行新的线程");
                    String requestId = nettyRequest.getRequestId();
                    NettyResponse nettyResponse = new NettyResponse();
                    nettyResponse.setRequestId(requestId);
                    try {
                        Object result = handle(nettyRequest);
                        nettyResponse.setResult(result);
                        nettyResponse.setMsg("OK");
                    } catch (Exception ex) {
                        nettyResponse.setResult(null);
                        nettyResponse.setMsg("ERROR");
                        logger.error("HeartBeatServerHandle" + ex.getMessage());
                    }
                    channelHandlerContext.writeAndFlush(nettyResponse).addListener(new ChannelFutureListener() {
                        @Override
                        public void operationComplete(ChannelFuture channelFuture) throws Exception {
                            logger.debug("Send response for request " + nettyRequest.getRequestId());
                        }
                    });

                }
            });
        }
    }

    private Object handle(NettyRequest request) throws Exception {

        String className = request.getClassName();
        String methodName = request.getMethodName();
        Class<?> serviceClass = Class.forName(className);

        //尝试使用这种方法来初始化，不使用hashmap
        Object serviceBean = serviceClass.newInstance();

        Class<?>[] parameterTypes = request.getParameterTypes();
        Object[] params = request.getParams();
        logger.debug(serviceClass.getName());
        logger.debug(methodName);

//        for (int i = 0; i < parameterTypes.length; ++i) {
//            logger.debug(parameterTypes[i].getName());
//        }
//        for (int i = 0; i < params.length; ++i) {
//            logger.debug(params[i].toString());
//        }


        //使用cglib 来调用该方法
        FastClass serviceFastClass = FastClass.create(serviceClass);
        FastMethod fastMethod = serviceFastClass.getMethod(methodName, parameterTypes);
        Object object = fastMethod.invoke(serviceBean, params);

        //处理对应的业务逻辑，产生一个
        logger.info("handle result is " + object.toString());
        return object;
    }


}
