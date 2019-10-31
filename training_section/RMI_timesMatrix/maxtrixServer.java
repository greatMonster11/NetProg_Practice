import java.rmi.*;
import java.net.MalformedURLException;

public class matrixServer {
  public static void main(String[] args) {
    // Kiem tra cho che bao mat cho RMI
    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new RMISecurityManager());
    }

    // Tao doi tuong goi tu xa
    try {
      matrix obj = new matrix();

      // Dang ki thong tin cho doi tuong goi tu xa
      Naming.bind("MaxtrixObject", obj);
      System.out.println("Dang ki thanh cong doi tuong goi tu xa !!");

    } catch (RemoteException e) {
      System.out.println("Co loi khi tao doi tuong");
    } catch (MalformedURLException e) {
      System.out.println("Khong dang ki duoc doi tuong");
    }
  }
}