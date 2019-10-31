import java.rmi.*;
import java.io.*;

public class matrixClient {
  public static void main(String[] args) {
    int m, n, p;
    BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Nhap vao m: ");
    m = Integer.valueOf(key.readLine()).intValue();
    System.out.println("Nhap vao n: ");
    n = Integer.valueOf(key.readLine()).intValue();
    System.out.println("Nhap vao p: ");
    p = Integer.valueOf(key.readLine()).intValue();

    int a[][] = new int[m][n];
    int b[][] = new int[n][p];
    int result[][] = new int[n][n];

    System.out.println("Nhap cac gia tri cho ma tran A");
    input(a, key);
    System.out.println("Nhap cac gia tri cho ma tran B");
    input(b, key);

    try {
      matrix ref = (matrix) Naming.lookup("rmi://localhost/MatrixObject");
      result = ref.tich(a, b, m, n, p);

      System.out.println("Ma tran A: ");
      hienthi(a);
      System.out.println("Ma tran B: ");
      hienthi(b);
      System.out.println("A * B: ");
      hienthi(result);

    } catch (Exception e) {
      System.out.println(e);
    }

    return;
  }

  public static void input(int array[][], BufferedReader key) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        array[i][j] = Integer.valueOf(key.readLine()).intValue();
      }
    }
  }

  public static void hienthi(int array[][]) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        System.out.print(" [" + array[i][j] + "] ");
      }
      System.out.println();
    }
  }

}