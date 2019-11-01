import java.rmi.*;
import java.net.MalformedURLException;
import java.io.*;

public class LamToanServer {
	public static void main(String[] args) {
		// Cai dat co che bao mat
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());

		try {
			// Toa doi tuong cho phep goi ham tu xa
			LamToan obj = new LamToan();
			LamToan obj2 = new LamToan();
			LamToan obj3 = new LamToan();
			System.out.println("Tao duoc doi tuong cho phep goi tu xa");

			// Dang ki doi tuong
			Naming.rebind("LamToanObject", obj);
			Naming.rebind("NhanMTObject", obj2);
			Naming.rebind("KVPSObject", obj3);
			System.out.println("Dang ki doi tuong de goi tu xa thanh cong !!!");

		} catch (RemoteException e) {
			System.out.println("Loi trong khi tao doi tuong tu xa");
		} catch (MalformedURLException e) {
			System.out.println("Loi trong khi dang ki doi tuong tu xa");
		}
	}
}
