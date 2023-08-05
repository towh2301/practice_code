package dsa_01;
import java.util.Scanner;
public class caculate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long a = 0;
		for(int i = n; i>=0; i--)
			a = (long)a+i;
		System.out.println(a);
	}
	

}
