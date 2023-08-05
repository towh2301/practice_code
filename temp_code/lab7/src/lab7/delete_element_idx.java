package lab7;

import java.util.Scanner;
import java.util.Random;

public class delete_element_idx {
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();

	public static void main(String[] args) {
		System.out.print("Nhap do dai cua day: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		arr = input(n);
		output(arr);
		// System.out.print("\nNhap vi tri can xoa: ");
		// int k = sc.nextInt();
		// while (k >= n||k<0) {
		// System.out.printf("Khong co vi tri thu %d trong day! Xin moi nhap lai: " ,k);
		// k = sc.nextInt();
		// }
		// arr = delete(arr, k);
		// output(arr);
		System.out.print("\nSort arrays: ");
		arr = sortArrays(arr);
		output(arr);
		sc.close();
	}

	// input
	public static int[] input(int n) {
		int[] a = new int[n];

		for (int i = 0; i < a.length; i++)
			a[i] = rd.nextInt(10);
		// a[i] = sc.nextInt();
		return a;
	}

	// output
	public static void output(int[] a) {
		for (int i : a)
			System.out.print(i + " ");
	}

	// delete index
	public static int[] delete(int[] a, int k) {
		int[] e = new int[a.length - 1];
		for (int i = 0; i < k; i++)
			e[i] = a[i];
		for (int i = k; i < e.length; i++) {
			e[i] = a[i + 1];
		}
		return e;
	}

	// sort array from small to large
	public static int[] sortArrays(int[] a) {
		int t;
		// int val =a[0];
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++)
				if (a[i] > a[j]) {
					t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
		}
		return a;
	}
}
