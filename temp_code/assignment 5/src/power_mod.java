import java.util.Scanner;

public class power_mod {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long n = sc.nextLong();
		long k = sc.nextLong();
		System.out.println(powermod(n, k, x));
	}

	public static long powermod(long n, long k, long x) {
		long m = 1;
		for (long i = 1; i <= n; i++) {
			m = (m * (x % k)) % k;
		}
		return m;
	}

}