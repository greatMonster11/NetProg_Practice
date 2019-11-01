import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class LamToan extends UnicastRemoteObject implements LamToanItf {
	// Ham xay dung
	public LamToan() throws RemoteException {
		super();
	}
	
	// Ham giai phuong trinh bac nhat
	public double giaiPTB1(double a, double b) throws RemoteException {
		return -b/a ;
	}
	
	// Nhan hai ma tran voi 
	public int[][] nhanMT(int a[][], int b[][], int m, int n, int p) {
		int result[][] = new int[m][p];
		
		for (int i=0; i < m; i++) {
			for (int j=0; j<p; j++) {
					result[i][j] = 0;
					for (int k=0; k<n; k++) 
						result[i][j] = result[i][j] + a[i][k]*b[k][j];
			}
		}
		
		return result;
	}
}