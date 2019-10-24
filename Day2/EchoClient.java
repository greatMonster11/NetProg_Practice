import java.io.*;
import java.net.*;

public class EchoClient {
	public static void main(String args[]) {
		try {
			int port = Integer.parseInt(args[1]);
			Socket client = new Socket(args[0], port);
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();

			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String theString = br.readLine();
				// Doi chuoi sang byte
				byte[] data = theString.getBytes();
				for (int i = 0; i < data.length; i++) {
					os.write(data[i]);
					int ch = is.read();
					System.out.print((char) ch);
				}
				if (theString.equals("quit")) {
					os.write(-1);
					System.out.println("");
					break;
				}
				System.out.println("");
			}
		} catch (IOException e) {
			System.out.print("Loi nhap xuat: " + e);
		}
	}
}
