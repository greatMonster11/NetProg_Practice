import java.io.*;
import java.net.*;
public class EchoServer{
public static void main(String args[]) {
try {
	int port = Integer.parseInt(args[0]);
	ServerSocket ss = new ServerSocket(port);
	while(true) {
	try{
		Socket s = ss.accept();
		OutputStream os = s.getOutputStream();
		InputStream is = s.getInputStream();
		int ch = 0;
		while(true) {
			ch = is.read();
			if(ch == -1) {
				break;
			}
			os.write(ch);
		}
		s.close();
	} catch(IOException e) {
		System.err.println("Connect Error: " + e);
	}					 
	}
} catch (IOException e)	{	
	System.err.println("Server Creation Error: " + e);
  }
}
}
