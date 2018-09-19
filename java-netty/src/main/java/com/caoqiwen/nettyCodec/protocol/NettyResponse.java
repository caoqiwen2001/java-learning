package com.caoqiwen.nettyCodec.protocol;

public class NettyResponse {

    private String requestId;
    private String msg;
    private Object result;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "NettyResponse{" +
                "requestId='" + requestId + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
