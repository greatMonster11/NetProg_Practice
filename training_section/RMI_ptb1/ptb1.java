import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

class ptb1 extends UnicastRemoteObject implements ptb1Itf {
  private double result;

  // Ham xay dung
  public ptb1() {
    super();
  }

  public double giaiPTB1(double a, double b) {
    if (a == 0) {
      if (b == 0) {
        System.out.println("Phuong trinh co vo so nghiem");
        return 0;
      }

      if (b != 0) {
        System.out.println("Phuong tring vo nghiem");
        return 0;
      }
    }

    result = -b / a;

    return result;
  }

}
