import java.io.*;
import java.net.*;

public class Pop3Client {
  public static void main(String[] args) {
    if (args.length < 4) {
      System.out.println("Usage: Pop3Client <server mail> <PORT> <username> <password>");
      return;
    }
    int PORT = Integer.valueOf(args[1]).intValue();
	System.out.println(args[0]);
    try {
      Socket s = new Socket(args[0], PORT);
      BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
      BufferedReader key = new BufferedReader((new InputStreamReader(System.in)));
      PrintWriter pw = new PrintWriter(s.getOutputStream());

      // Read greeting from server
      String respone = br.readLine();
      System.out.println(respone);

      // Give a username
      pw.println("USER " + args[2]);
      pw.flush();
      respone = br.readLine();
	  System.out.println(respone);

      // Authenticate with password belong to user above
      pw.println("PASS " + args[3]);
      pw.flush();
      respone = br.readLine();
	  System.out.println(respone);
      
      
	  System.out.println("Enter message number, 0 for the end: ");
	  int messageNum = 0;
	  while ((messageNum = Integer.valueOf(key.readLine()).intValue()) != 0) {
			pw.println("RETR " + messageNum);
			pw.flush();
			// render the data return from server
			respone = br.readLine();
			System.out.println(respone);
			
	  }

      respone = br.readLine();
	  System.out.println(respone);
	  
      pw.println("QUIT");
      pw.flush();respone = br.readLine();
	  System.out.println(respone);
	  s.close();

    } catch (IOException e) {
      System.out.println(e);
    }
  }
}