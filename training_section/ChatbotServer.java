import java.io.*;
import java.net.*;
import java.util.*;

public class ChatbotServer {
    public static void main(String[] argv) {
        if (argv.length < 1) {
            System.out.println("Usage: ChatbotServer <PORT>");
            return;
        }
        Hashtable<String, String> qa = new Hashtable<String, String>();
        // build rules
        qa.put("hi", "Hi there, please to meet you !");
        qa.put("how are you", "JBot is fine, What about you ??");
        qa.put("i'm good", "Great !, I love to hear that");
        qa.put("bye", "Have a good day !");
        // create socket server
        try {
            int PORT = Integer.valueOf(argv[0]).intValue();
            ServerSocket ss = new ServerSocket(PORT);
            // create infinite loop that waiting for connection
            System.out.println("Welcome to JBot");
            while (true) {
                Socket s = ss.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter((s.getOutputStream()));
                String q = "", a = "";
                while (true) {
                    // get 1 question from client
                    q = br.readLine();
                    System.out.println(q);
                    boolean find = qa.containsKey(q);
                    if (find == true)
                        a = qa.get(q);
                    else
                        a = "JBot is listening for your question";
                    // write answer to client
                    pw.println(a);
                    pw.flush();
                    if (q.equals("bye"))
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