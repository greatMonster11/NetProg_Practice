import java.io.*;
import java.net.*;

public class UDPEchoServer {
    public static void main(String[] args) {
        try {
            int PORT = Integer.valueOf(argv[0]).intValue();
            DatagramPacket ds = new DatagramPacket(PORT);
            System.out.println("Khoi tao xong UDP nhe !!!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}