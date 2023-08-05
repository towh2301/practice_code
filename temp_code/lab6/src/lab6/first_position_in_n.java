package lab6;

import java.util.Scanner;

public class first_position_in_n {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Xin nhap n: ");
		int n = sc.nextInt();
		while (n > 9999999) {
			System.out.print("Xin nhap lai n: ");
			n = sc.nextInt();
		}

		int x = sc.nextInt();
		int[] arr = new int[8];
		arr = arrOfInteger(n);
		int idx = findXIndex(arr, x);
		if (idx != -1)
			System.out.print("first index of x is: " + (idx + 1));
		else
			System.out.print("X is not including in n! ");
		sc.close();

	}
	// check value of N

	// divide n
	public static int[] arrOfInteger(int n) {
		int[] arr = new int[8];
		int i = 0;
		int a = 0;
		while (n / 10 != 0) {
			a = n % 10;
			n = n / 10;
			arr[i] = a;
			a = 0;
			i++;
		}
		return arr;
	}

	// find X
	public static int findXIndex(int[] a, int x) {
		int idx = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				idx = i;
				break;
			}
		}
		if (idx == -1)
			return -1;
		else
			return idx;
	}

}
