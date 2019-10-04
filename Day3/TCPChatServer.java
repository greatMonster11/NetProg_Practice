import java.io.*; 
import java.util.*; 
import java.net.*; 

// Server class 
public class TCPChatServer 
{ 
	public static void main(String[] args) throws IOException 
	{ 
		// server is listening on port 1234 
		int PORT = Integer.valueOf(args[0]).intValue();
		ServerSocket ss = new ServerSocket(PORT); 
		String username = args[1];
		Socket s; 
		
		// running infinite loop for getting 
		// client request 
		while (true) 
		{ 
			// Accept the incoming request 
			s = ss.accept(); 

			System.out.println("New client request received : " + s); 
			
			// obtain input and output streams 
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			System.out.println("Creating a new handler for this client..."); 

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
				pw.println("server: " + str); pw.flush();
				
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
			
		}
	} 
} 
