import java.io.*;
import java.util.Scanner; 

public class ptb2 {
	public static float delta(float a, float b, float c) 
	{
		return b*b - 4*a*c;
	}
public static void main(String argv[]) {
	Scanner scan = new Scanner(System.in);
	float a = scan.nextFloat();
	float b = scan.nextFloat();
	float c = scan.nextFloat();
	
	/* System.out.print(a);
	System.out.print(b);
	System.out.print(c); */
	float delta = delta(a, b, c);
	//System.out.print(delta);
	
	if(delta < 0) {
		System.out.println("Phuong trinh vo nghiem");
		return;
	}
	if(delta == 0) {
		System.out.println("x= " + delta/2*a);
		return;
	}
	else {
		System.out.println("x1= " + (-b+ Math.sqrt(delta))/2*a);
		System.out.println("x2= " + (-b- Math.sqrt(delta))/2*a);
		return;
	}
}
}