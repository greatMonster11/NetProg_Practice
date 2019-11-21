import java.net.*;
import java.io.*;

public class UDPEchoServer {
	public static void main(String[] args
			try {
				if(args.length == 0) {
					System.out.println("Usage: UDPEchoServer <PORT>");
					return;
				}
				int PORT = Integer.valueOf(args[0]).intValue();
				DatagramSocket ds = new DatagramSocket(PORT);
				System.out.println("Da khoi tao UPD Socket");
				// Create buffer for storing message
				byte[] buffer = new byte[60000];
				while(true) { // Create mesage pack
					DatagramPacket in = new DatagramPacket(buffer, buffer.length);
					ds.receive(in); // Wait for new coming message
					String str = new String(in.getData(), 0,  in.getLength());
					// Craete sender contain up coming message
					DatagramPacket out = new DatagramPacket(str.getBytes(), 
											in.getLength(), in.getAddress(), in.getPort());
					ds.send(out);
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
}