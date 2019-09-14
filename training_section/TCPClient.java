import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java TCPClient <host> <port>");
            return;
        }
        try {
            // Create socket connect to server
            // Remember to convert port to Integer
            Socket s = new Socket(args[0], Integer.valueOf(args[1]).intValue());

            // Create I/O in flow using BufferedReader
            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

            // Create I/O to server
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());

            System.out.println("Type 'exit' to end prog");
            while (true) {
                System.out.println(br.readLine());
                String str = key.readLine();

                pw.println(str);
                pw.flush();
                if (str.equals("exit"))
                    break;

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
