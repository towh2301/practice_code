import java.util.Scanner;
public class f {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		int m = sc.nextInt();
		System.out.println(modPrimePow(a, b, m)); // 257419741
		sc.close();
	}

	public static int modPrimePow(long a, long b, int m) {

		{
			long rs = 1;
			a %= m;
			b %= m - 1;
			while (b > 0) {
				if (b % 2 > 0)
					rs = rs * a % m;
				a = a * a % m;
				b /= 2;
			}
			return (int) rs;
		}
	}

}
