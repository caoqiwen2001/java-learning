package nettyCodeC;

import com.caoqiwen.nettyCodec.HeartBeatClientHandler;
import com.caoqiwen.nettyCodec.HeartBeatServer;
import com.caoqiwen.nettyCodec.HeartBeatsClient;
import com.caoqiwen.nettyCodec.protocol.NettyRequest;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class NettyTest {


    @Test
    public void testClient() throws InterruptedException {
        HeartBeatsClient client = new HeartBeatsClient();
        HeartBeatClientHandler handler = client.connect(8010, "127.0.0.1");
        NettyRequest request = new NettyRequest();
        request.setRequestId(UUID.randomUUID().toString());
        request.setClassName("nettyCodeC.HelloNetty");
        request.setMethodName("hello");
        handler.sendRequet(request);
    }


    @Test
    public void testServer() {
        HeartBeatServer beatServer = new HeartBeatServer();
        beatServer.bind(8010);
    }
}
