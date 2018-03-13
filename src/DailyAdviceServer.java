import java.io.IOException;
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
            Socket sock = serverSock.accept();
            String getAdvice = getAdvice();
            PrintWriter writer = new PrintWriter(sock.getOutputStream());
            writer.println();
            writer.close();
            System.out.println(getAdvice);
        }
    } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public String getAdvice(){
        int random = (int) (Math.random()*adviceList.length);
        return adviceList[random];
    }

    public static void main(String args[]){
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
