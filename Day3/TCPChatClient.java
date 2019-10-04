import java.io.*; 
import java.util.*; 
import java.net.*; 

// Server class 
public class TCPChatClient
{ 
	public static void main(String[] args) throws IOException 
	{ 	
		if(args.length < 3) {
			System.out.println("Usage: TCPChatClient <IP_Server> <PORT> <Username>");
			return;
		}
		// server is listening on port 1234 
		int PORT = Integer.valueOf(args[1]).intValue();
		String username = args[2];
		Socket s; 
		
		// Accept the incoming request 
		s = new Socket(args[0], PORT); 
		
		// obtain input and output streams 
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter pw = new PrintWriter(s.getOutputStream());

		// Create a new handler object for handling this request. 
		ClientSender sendThread = new ClientSender(s, username, br); 
		ClientReader readThread = new ClientReader(s, pw);
		
		// Create a new Thread with this object. 
		Thread t1 = new Thread(sendThread); 
		Thread t2 = new Thread(readThread);
		// start the thread. 
		t1.start(); 
		t2.start();
	} 
} 

// ClientSender class 
class ClientSender implements Runnable 
{
	private String name; 
	final BufferedReader br; 
	Socket s; 
	
	// constructor 
	public ClientSender(Socket s, String name, BufferedReader br) { 
		this.br = br; 
		this.name = name; 
		this.s = s; 
	} 

	@Override
	public void run() { 

		String received; 
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		while (true) 
		{ 
			try
			{ 
				// receive the string 
				received = br.readLine(); 
				
				System.out.println(this.name + ": " + received); 
				
			} catch (IOException e) { 
				
				e.printStackTrace(); 
			} 
			
		}
	} 
} 

// ClientReader class 
class ClientReader implements Runnable 
{
	final PrintWriter pw; 
	Socket s; 
	
	// constructor 
	public ClientReader(Socket s, PrintWriter pw) { 
		this.pw = pw; 
		this.s = s; 
	} 

	@Override
	public void run() { 

		String str; 
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		while (true) 
		{ 
			try
			{ 
				// receive the string 
				str = key.readLine(); 
				pw.println(str); pw.flush();
				
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
			
		}
	} 
} 
