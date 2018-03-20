import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Paul on 13.03.2018.
 */
public class DailyAdviceClient {
    public void go() {
        try {
            Socket s = new Socket("87.236.11.34", 4242);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String advice = reader.readLine();
            System.out.println("Today is good day for: " + advice);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
