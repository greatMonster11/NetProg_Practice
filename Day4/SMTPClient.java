import java.io.*;
import java.net.*;

public class SMTPClient {
	public static void main(String[] args) {
		if (args.length < 4) {
			System.out.println("Usage: SMTPClient <server mail> <PORT> <source> <destination>");
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

			// Send HELO and get respone from server
			pw.println("HELO server");
			pw.flush();
			respone = br.readLine();
			System.out.println(respone);

			// Send MAIL FROM command
			pw.println("MAIL FROM: " + args[2]);
			pw.flush();
			respone = br.readLine();
			System.out.println(respone);

			// Send RECP TO command
			pw.println("RCPT TO: " + args[3]);
			pw.flush();
			respone = br.readLine();
			System.out.println(respone);

			// Send DATA command
			pw.println("DATA");
			pw.flush();

			System.out.println("Enter your message, '.' for the end: ");
			String messageData = null;
			while ((messageData = key.readLine()) != null) {
				if (messageData.equals(".")) {
					break;
				}
				// System.out.println("from key: " + messageData);
				else {
					pw.println(messageData);
					pw.flush();
				}
			}
			pw.println("\r\n" + "." + "\r\n");
			pw.flush();

			respone = br.readLine();
			System.out.println(respone);

			pw.println("QUIT");
			pw.flush();
			respone = br.readLine();
			System.out.println(respone);
			s.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}