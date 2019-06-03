package kawauso.email;

import org.junit.Test;

public class EmailClientTest {

    EmailClient client;


    @Test
    public void testConnect() throws Exception {
        client = new EmailClient("host", 9876, "test@email", "test-pass");
        client.login();
        Thread.sleep(1000);
        client.logout();
    }
}
