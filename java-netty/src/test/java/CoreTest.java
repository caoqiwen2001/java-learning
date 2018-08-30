import com.caoqiwen.netty.TimeClient;
import com.caoqiwen.netty.TimeServer;
import org.junit.Test;

public class CoreTest {

    @Test
    public void timeServerTest() throws Exception {
        new TimeServer().bind( 8011);
    }


    @Test
    public void timeClientTest() throws Exception {
        new TimeClient().connect(8011, "127.0.0.1");
    }
}
