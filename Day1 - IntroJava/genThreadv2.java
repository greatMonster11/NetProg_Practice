import java.io.*;

public class genThreadv2 implements Runnable {
	int id_thread;

	public genThreadv2(int i) {
		this.id_thread = i;
	}

	public void run() {
		try {
			FileOutputStream f1 = new FileOutputStream("D:/NetPro_s6_b1/out." + this.id_thread);
			PrintWriter pw = new PrintWriter(f1);

			for (int i = 0; i < 100; i++) {
				System.out.println("Hello from thread - " + this.id_thread);
				pw.println(this.id_thread + "-thread");
			}
			pw.flush();
			f1.close();
		} catch (IOException e) {
			System.out.println("Loi nhap xuat: " + e);
		}
	}

	public static void main(String args[]) {
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			genThreadv2 mt = new genThreadv2(i);
			Thread t1 = new Thread(mt);
			t1.start();
		}
	}
}