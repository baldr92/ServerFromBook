import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Paul on 13.03.2018.
 */
public class DailyAdviceServer {
    String adviceList[] = {"DYING", "HURTING", "PAINING", "SUFFERING"};

    public void go() {
        try{
        ServerSocket serverSock = new ServerSocket(4242);
        while (true) {
            System.out.println("Waiting for a client");
            Socket client = serverSock.accept();
            System.out.println("Client connected");
            //String getAdvice = getAdvice();
            BufferedReader in = new BufferedReader (new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());
            //System.out.println("Today is good day for: " + getAdvice);
        }
    } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Something went wrong!");
        }
    }


  /*  public String getAdvice(){
        int random = (int) (Math.random()*adviceList.length);
        return adviceList[random];
    } */

    public static void main(String args[]){
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
