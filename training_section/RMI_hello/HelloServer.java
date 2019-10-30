import java.rmi.*;
import java.net.MalformedURLException;

public class HelloServer {
	public static void main(String[] agrs) {
		if (System.getSecurityManager() == null) // Cai dat co che bao mat
			System.setSecurityManager(new RMISecurityManager());
		try {
			// Tao ra doi tuong cho phep goi tu xa
			Hello obj = new Hello();
			System.out.println("Tao duoc doi tuong cho phep goi tu xa");
			// Dang ki doi tuong
			Naming.rebind("HelloObj", obj);
			System.out.println("Dang ki ten doi tuong thanh cong");
		} catch (RemoteException e) {
			System.out.println("Loi khong the tao doi tuong tu xa");
		} catch (MalformedURLException e) {
			System.out.println("Loi trong khi dang ki doi tuong tu xa");
		}
	}
}