import java.util.Scanner;

public class greatest_divisor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		uc(a, b);
		sc.close();
	}

	public static void uc(int a, int b) {
		int c = 0;
		while (a > 0) {
			if (b > a) {
				c = a;
				a = b;
				b = c;
			}
			a = a - b;

		}
		System.out.println(b);

	

	}

}
