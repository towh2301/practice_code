package baitapvenha;

import java.util.Scanner;

public class Prime_number_check {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		int prime = 0;
		while (flag == false) {
			System.out.print("Re-type a: ");
			int a = sc.nextInt();
			flag = primecheck(a);
			if (flag == true) {
				prime = a;
			}
		}
		System.out.println(prime + " is prime number!");
		sc.close();
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
