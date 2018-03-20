import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

public class Client {
    public void go() {
        try {
            Socket socket = new Socket("127.0.0.1", 4242);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            while (socket.isOutputShutdown()) {

                if (bufferedReader.ready()) {
                    System.out.println("Client starts to writing in channel");
                    String text = bufferedReader.readLine();
                    outputStream.writeUTF(text);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }
}
