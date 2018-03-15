import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.nio.Buffer;

public class Client {
    public void go() {
        try {
            Socket socket = new Socket("127.0.0.1", 4242);
            BufferedReader 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }
}
