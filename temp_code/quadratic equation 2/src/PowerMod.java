import java.util.Scanner;

public class PowerMod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long n = sc.nextLong();
		long k = sc.nextLong();
		System.out.println(powermod(n, k, x));
	}

	public static long powermod(long n, long k, long x) {
		long sum = 1;
		for (long i = 1; i <= n; i++) {
			sum = (sum * (x % k)) % k;
		}
		return sum;
	}
}
