package baitapvenha;

import java.util.Scanner;

public class closest_prime_number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Math.abs(sc.nextInt());
		int c = a;
		int b = a;
	}
		
	public static boolean primecheck(int a) {
		if (a < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}
