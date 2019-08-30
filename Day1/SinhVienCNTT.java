import java.io.*;

public class SinhVienCNTT extends SinhVien {
	SinhVienCNTT(String name, String gender) {
		super(name, gender);
	}
	
	@Override
      public void diemDanh() {
        System.out.println("Toi la sinh vien CNTT");
     }
	
public static void main(String argv[]) {
	SinhVienCNTT a = new SinhVienCNTT("Sang", "female");
	a.diemDanh();
}
}