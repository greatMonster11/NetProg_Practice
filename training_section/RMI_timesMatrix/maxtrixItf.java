import java.rmi.*;

public interface matrixItf extends Remote {

  // Khai bao phuong thuc cho phep goi tu xa
  public int tich(int a[][], int b[][], int m, int n, int p) throws RemoteException;
}