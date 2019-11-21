import java.rmi.*;
import java.rmi.RemoteException;

public interface LamToanItf extends Remote {
	// Khai bao cac phuong thuc cho phep goi tu xa
	public double giaiPTB1(double a, double b) throws RemoteException;

	public int[][] nhanMT(int a[][], int b[][], int m, int n, int p) throws RemoteException;

	public double[] KVPS(int a[], int n) throws RemoteException;
}