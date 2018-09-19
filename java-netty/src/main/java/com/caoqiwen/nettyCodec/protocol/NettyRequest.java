package com.caoqiwen.nettyCodec.protocol;

public class NettyRequest {

    private String requestId;
    private String className;
    private Object[] params;
    private String methodName;
    private Class<?>[] parameterTypes;
    private REQUEST_TYPE requestType = REQUEST_TYPE.NORMAL;

    public REQUEST_TYPE getRequestType() {
        return requestType;
    }

    public void setRequestType(REQUEST_TYPE requestType) {
        this.requestType = requestType;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public enum REQUEST_TYPE {
        HEART,
        NORMAL
    }


}
