import java.io.*;

public class SinhVien {
	public String name;
	public String gender;

	SinhVien(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	public void diemDanh() {
		System.out.println("Co em !");
	}

	public static void main(String argv[]) {
		SinhVien littleMonster = new SinhVien("Sang", "male");
		System.out.println(littleMonster.name);
		littleMonster.diemDanh();
	}
}