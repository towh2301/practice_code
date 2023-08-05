package lab7;

import java.util.Random;
import java.util.Scanner;

public class insertX {
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();

	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] arr = new int[n];
		arr = input(n);
		output(arr);
		System.out.print("\nNhap so can them: ");
		int val = sc.nextInt();
		System.out.print("Nhap vi tri can them: ");
		int k = sc.nextInt();
		k = k-1;
		arr = insert(arr, k, val);
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
	
	//insertX
	public static int[] insert(int[] a, int k, int val) {
		int[] e = new int[a.length + 1];
		for (int i = 0; i < k; i++)
			e[i]=a[i];
		e[k]=val;
		for(int i = k; i<a.length; i++)
			e[i+1] = a[i];
		return e;
	}

}
