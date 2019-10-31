import java.rmi.*;

public interface ptb1Itf extends Remote {
  // Khai bao phuong thuc cho phep goi tu xa
  public double giaiPTB1(double a, double b) throws RemoteException;
}