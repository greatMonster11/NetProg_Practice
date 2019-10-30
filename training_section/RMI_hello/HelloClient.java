import java.rmi.*;
import java.net.MalformedURLException;

public class HelloClient {
  public static void main(String[] args) {
    try {
      // Do tim doi tuong tu xa
      HelloItf ref = (HelloItf) Naming.lookup("rmi://localhost/HelloObject");
      // Goi ham tren doi tuong
      String result = ref.sayHello();
      System.out.println("Ket qua nhan duoc la: " + result);
    } catch (NotBoundException e) {
      System.out.println("Khong tim thay doi tuong goi tu xa");
    } catch (MalformedURLException e) {
      System.out.println("Sai dinh dang URL");
    } catch (RemoteException e) {
      System.out.println("Loi trong khi goi ham tu xa");
    }
  }
}