package lab6;

import java.util.Scanner;

public class print_less_prime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		smallerPrimeNum(n);
		sc.close();
	}

	// isPrime check
	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;

	}

	// smaller than n
	public static void smallerPrimeNum(int n) {
		if (n > 0) {
			for (int i = 2; i < n; i++) {
				if (isPrime(i) == true)
					System.out.print(i + " ");
			}
		}
	}
}
