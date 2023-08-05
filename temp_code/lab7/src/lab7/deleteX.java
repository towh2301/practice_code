package lab7;

import java.util.Random;
import java.util.Scanner;

public class deleteX {
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();

	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		arr = input(n);
		output(arr);
		System.out.print("\nNhap so can xoa: ");
		int val = sc.nextInt();
		arr = deleteValue(arr, val);
		output(arr);
		sc.close();

	}

	// input
	public static int[] input(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		return arr;
	}

	// output
	public static void output(int[] a) {
		for (int i : a)
			System.out.print(i + " ");
	}

	// delete idx
	public static int[] deleteIdx(int[] a, int k) {
		int[] e = new int[a.length - 1];
		for (int i = 0; i < k; i++)
			e[i] = a[i];
		for (int i = k; i < e.length; i++) {
			e[i] = a[i + 1];
		}
		return e;
	}

	// delete X
	public static int[] deleteValue(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {

			if (a[i] == x) {
				a = deleteIdx(a, i);
				i--;
			}

		}

		return a;
	}

}
