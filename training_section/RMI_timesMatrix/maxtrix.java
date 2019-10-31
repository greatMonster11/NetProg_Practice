import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

public class matrix extends UnicastRemoteObject implements matrixItf {
  // Ham xay dung
  public matrix() {
    super();
  }

  public int tich(int a[][], int b[][], int m, int n, int p) {
    int result[][] = new int[m][p]; // tao ma tran ket qua

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < p; j++) {
        result[i][j] = 0;

        for (k = 0; k < n; k++) {
          result[i][j] = result[i][j] + a[i][k] * b[k][j];
        }
      }
    }

    return result;
  }
}