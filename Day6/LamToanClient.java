import java.rmi.*;
import java.io.*;
import java.net.MalformedURLException;

public class LamToanClient {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Usage: java LamToanClient <hostname>");
			return;
		}
		
		try {
			String choice;
			boolean isValid;
			BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		
			// Do tim doi tuong tu xa
			LamToanItf t1 = (LamToanItf)Naming.lookup("rmi://" + args[0] + "/LamToanObject");
			LamToanItf t2 = (LamToanItf)Naming.lookup("rmi://" + args[0] + "/NhanMTObject");
			
			System.out.println("Tao duoc doi tuong cho phep goi tu xa");
			
			do {
				System.out.println("1. Giai phuong trinh bac nhat");
				System.out.println("2. Tinh ky vong - phuong sai cua day so");
				System.out.println("3. Nhan 2 ma tran");
				System.out.print("Select your option - (0) for the end of process: ");
				
				// get input selection
				choice = key.readLine();
				
				switch(choice) {
					case "1":
						GiaiPTB1(key, t1);
						break;
					case "2":
						System.out.println("Comming soon !");
						break;
					case "3":
						NhanMT(key, t2);
						break;
				}			
				
				System.out.println();
				isValid = choice.equals("0");
			} while(!isValid);
		} catch (IOException e) {
			System.out.println(e);
		} catch(NotBoundException e) {
			System.out.println("Khong the tim thay doi tuong goi tu xa");
		} 

		return;
	}
	
	public static void GiaiPTB1(BufferedReader key, LamToanItf t) {
		double a, b, result;
		
		try {
			System.out.print("Nhap he so a: "); a =	Double.parseDouble(key.readLine());
			System.out.print("Nhap he so b: "); b = Double.parseDouble(key.readLine());
			
			if (a == 0) {
				if (b == 0) {
					System.out.println("Phuong trinh vo so nghiem");
					return;
				}
				
				else if (b != 0) {
					System.out.println("Phuong trinh vo nghiem");
					return;
				}
			}
						
			// Goi ham tren doi tuong
			result = t.giaiPTB1(a, b);
			System.out.println("Ket qua cua phuong trinh tren la: " + result);

		} catch(IOException e) {
			System.out.println(e);
		} 
		
		return;
	}
	
	public static void NhanMT(BufferedReader key, LamToanItf t) {
		int n, m, p;
		
		try {
			System.out.print("Nhap vao gia tri m: "); m =  Integer.valueOf(key.readLine()).intValue();
			System.out.print("Nhap vao gia tri n: "); n =  Integer.valueOf(key.readLine()).intValue();
			System.out.print("Nhap vao gia tri p: "); p =  Integer.valueOf(key.readLine()).intValue();
			
			int a[][] = new int[m][n];
			int b[][] = new int[n][p];
			int result[][] = new int[n][n];
			
			System.out.println("Nhap gia tri cho ma tran a");
			input(a);
			System.out.println();
			
			System.out.println("Nhap gia tri cho ma tran b");
			input(b);
			System.out.println();
			
			System.out.println("Tich cua 2 ma tran a va b la:");
			result = t.nhanMT(a, b, m, n , p);
			output(result);
			System.out.println();
		
			return ;
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void input(int array[][]) {
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			for(int i = 0;i<array.length;i++) { 
				for(int j = 0;j<array[i].length;j++) {
					System.out.println("Nhap phan tu [" + i + "][" + j + "]");		 
					array[i][j] = Integer.valueOf(key.readLine()).intValue();
			 
				}
			}		
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	public static void output(int array[][]) {
		for(int i = 0;i<array.length;i++) { 
			for(int j = 0;j<array[i].length;j++) {
				System.out.print("Nhap phan tu [" + i + "][" + j + "]");		
				System.out.println(" = " + array[i][j]);
			}
		}	
	}
}