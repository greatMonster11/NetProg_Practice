import java.io.*;
import java.net.*;

public class UDPEchoClient {
	public static void main(String[] args) {
		try {
			if(args.length < 2) {
				System.out.println("Usage: UDPEchoClient <host name> <PORT>");
				return;
			}
			int PORT = Integer.valueOf(args[1]).intValue();
			// Tao DatagramSocket
			DatagramSocket ds = new DatagramSocket();
			// Server Address
			InetAddress server = InetAddress.getByName(args[0]);
			while(true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String theString = br.readLine(); // from keyboard
				// Convert into bytes
				byte[] data = theString.getBytes();
				// Create massage pack
				DatagramPacket dp = new DatagramPacket(data, data.length, server, PORT);
				ds.send(dp); //  send message to server
				// Create buffer for sending message
				byte[] buffer = new byte[6000];
				// Create pack to receive message
				DatagramPacket incomming = new DatagramPacket(buffer, buffer.length);
				ds.receive(incomming); // Waiting for new comming message\
				// Display new message
				System.out.println(new String(incomming.getData(), 0, incomming.getLength()));
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
}
