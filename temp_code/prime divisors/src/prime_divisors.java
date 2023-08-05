import java.util.Scanner;

public class prime_divisors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long i = 2;
		long count = 0;
		int time = 0;

		if (primecheck(n) == true)
			System.out.println(n + " " + 1);
		else {
			while (Math.abs(n) != 1) {
				boolean Flag = false;
				while (n % i == 0) {
					n = n / i;
					time++;
					Flag = true;

				}
				if (Flag == true) {
					count = i;
					System.out.println(count+ " " + time);
					time = 0;
				}

				i++;
			}
		}
		sc.close();
	}

	public static boolean primecheck(long a) {
		if (a < 2)
			return false;
		for (long i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}
