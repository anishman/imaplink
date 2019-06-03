package kawauso.email;
import org.apache.commons.net.imap.IMAPSClient;
import org.apache.commons.net.PrintCommandListener;
import java.io.IOException;

public class EmailClient {
    private final String host;
    private final int port;
    private final String email;
    private final String password;
    private IMAPSClient client;
    public EmailClient(String host, int port, String email, String password) {
        this.host = host;
        this.port = port;
        this.email = email;
        this.password = password;
    }    

    public void login() throws IOException {
        client = new IMAPSClient(true);
        client.addProtocolCommandListener(new PrintCommandListener(System.out, true));
        client.setDefaultPort(port);
        client.connect(host, port);
        client.login(email, password);
    }

    public void logout()  throws IOException {
        client.logout();
        client.disconnect();
    }
}
