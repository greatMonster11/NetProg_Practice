import java.io.*;
import java.net.*;
import java.util.*;

public class TCPChatServer {
    public static void main(String[] argv) {
        if (argv.length < 1) {
            System.out.println("Usage: ChatbotServer <PORT>");
            return;
        }
        // create socket server
        try {
            int PORT = Integer.valueOf(argv[0]).intValue();
            ServerSocket ss = new ServerSocket(PORT);
            // create infinite loop that waiting for connection
            System.out.println("Let's chat with Server");
            while (true) {
                Socket s = ss.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter((s.getOutputStream()));
                String clientTxt = "", serverTxt = "";
                while (true) {
                    // get 1 text from client
                    clientTxt = br.readLine();
                    System.out.println(clientTxt);

                    // get 1 text from keyboard
                    serverTxt = keyboard.readLine();
                    // write answer to client
                    pw.println("Server >>>> " + ServerTxt);
                    pw.flush();
                    if (clientTxt.equals("bye"))
                        break;
                }
                // close connection
                s.close();
            }
            // ss.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}