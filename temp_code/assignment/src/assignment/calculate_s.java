package assignment;
import java.util.Scanner;
public class calculate_s {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Math.abs(sc.nextInt());
		int a = 2 * n + 1;
		int s = 0;
		for (int i = 1; i<=a; i+=2)
			s += i;
		System.out.println("S = " + s);
		sc.close();

	}

}
