import java.io.*;
import java.rmi.*;
import java.net.MalformedURLException;

class ptb1Client {
  public static void main(String[] args) {
    double a, b, result;
    BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

    try {
      ptb1 ref = (ptb1) Naming.lookup("rmi://localhost/PTB1bject");

      System.out.println("Nhap vao he so a");
      a = Double.valueOf(key.readLine());
      System.out.println("Nhap vao he so cua b");
      b = Double.valueOf(key.readLine());

      result = ref.giaiPTB1(a, b);
      System.out.println("Phuong trinh " + a + "x + " + b + " = 0");
      System.out.println("Co nghiem la: " + result);

    } catch (NotBoundException e) {
      System.out.println("Khong tim thay doi tuong goi tu xa");
    } catch (MalformedURLException e) {
      System.out.println("Sai dinh dang URL");
    } catch (RemoteException e) {
      System.out.println("Loi trong khi goi ham tu xa");
    }
  }
}