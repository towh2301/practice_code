import java.util.Scanner;

public class same_number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		divide(n);
		sc.close();

	}

	public static void divide(long n) {
		long a = 0;
		long s = 0;
		long num = n;
		while (n > 0) {
			s = n % 10;
			a = a * 10 + s;
			n = n / 10;
		}
		if (a == num)
			System.out.print("YES");
		else
			System.out.print("NO");
	}

}
