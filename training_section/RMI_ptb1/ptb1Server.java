import java.rmi.*;
import java.net.MalformedURLException;

class ptb1Server {
  public static void main(String[] args) {
    // Kiem tra co che bao mat cho RMI
    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new RMISecurityManager());
    }

    // Tao doi tuong goi tu xa
    try {
      ptb1 obj = new ptb1();
      System.out.println("Khoi tao duoc doi tuong goi tu xa");

      // Dang ki ten cho doi tuong
      Naming.rebind("PTB1Object", obj);
      System.out.println("Dang ki ten doi tuong thanh cong");
    } catch (RemoteException e) {
      System.out.println("Loi khong the tao doi tuong tu xa");
    } catch (MalformedURLException e) {
      System.out.println("Loi trong khi dang ki doi tuong tu xa");
    }

    return;
  }
}