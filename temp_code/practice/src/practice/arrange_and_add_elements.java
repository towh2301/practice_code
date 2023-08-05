package practice;

import java.util.Scanner;
import java.util.Random;

public class arrange_and_add_elements {
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();

	public static void main(String[] args) {
		System.out.print("Nhap do dai day: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		arr = input(n);
		System.out.print("Day ban dau la: ");
		output(arr);
		System.out.print("\nSap xep tu be den lon: ");
		arr = arrangeSToL(arr);
		output(arr);
		System.out.print("\nNhap so muon them: ");
		int a = sc.nextInt();
		arr = addEle(arr, a);
		System.out.print("Day khi duoc them la: ");
		output(arr);
	}

	// input
	public static int[] input(int n) {
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			//a[i] = sc.nextInt();
			a[i] = rd.nextInt(20);
		}
		return a;
	}

	// output
	public static void output(int[] a) {
		for (int i : a)
			System.out.print(i + " ");
	}

	// add Elements
	public static int[] addEle(int[] a, int b) {
		int[] cope = new int[a.length + 1];
		int idx = -1;
		for (int i = 0; i < a.length; i++)
			if (b < a[i]) {
				idx = i;
				break;
			}
		
		if (idx != -1) {
			for (int i = 0; i < idx; i++)
				cope[i] = a[i];
			cope[idx] = b;
			for (int i = idx; i < a.length; i++)
				cope[i + 1] = a[i];
		} else {
			for (int i = 0; i < a.length; i++)
				cope[i] = a[i];
			cope[a.length] = b;
		}
		
		return cope;
	}

	// Arrange Elements from S to L
	public static int[] arrangeSToL(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int e = 0; e < a.length; e++)
				if (a[i] < a[e]) {
					int t = a[i];
					a[i] = a[e];
					a[e] = t;
				}
		}
		return a;
	}
}
