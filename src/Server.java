import java.awt.image.ImagingOpException;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            Socket client = serverSocket.accept();
            System.out.println("Connection was accepted");
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            System.out.println("DataOutputStream created");
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("DataInputStream created");
            while (true){
                System.out.println("System is ready for getting data");
                String entry = in.readUTF();
                System.out.println("Read from Client message:" + entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.go();
    }
}
