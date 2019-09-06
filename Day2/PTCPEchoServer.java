import java.io.*;
import java.net.*;

public class PTCPEchoServer {
public static void main(String args[]) {
	try{
	    int port = Integer.parseInt(args[0]);
	    ServerSocket ss = new ServerSocket(port);
	    while(true) {
		try {
			// Lang nghe ket noi
			Socket s = ss.accept();
			// Tao phan xu ly
			RequestProcessing rp = new RequestProcessing(s);
			rp.start();	
		} catch(IOException e) {
			System.out.print("Connection Error: " + e);	
		}
	    }
	} catch(IOException e) {
		System.out.println("Create Socket Error: " + e);	
	}
}
}
