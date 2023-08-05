package lab6;

import java.util.Scanner;
import java.util.Random;

public class qua_tang_cuoc_song {
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();
	public static void main(String[] args) {
		System.out.print("Nhap so hoc sinh: ");
		int n = sc.nextInt();
		int[] num = new int[n];
		System.out.print("Diem cua tung ban: ");
		num = input(n);
		output(num);
		phanQua(gifts(num));
		
		sc.close();

	}

	// input
	public static int[] input(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			//arr[i] = sc.nextInt();
			arr[i] = rd.nextInt(10);
		}
		return arr;
	}
	
	//output
	public static void output(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	// so phan qua
	public static int[] gifts(int[] a) {
		int[] arr = new int[101];
		for (int i = 0; i < a.length; i++)
			arr[a[i]]++;
		return arr;
	}

	// count check
	public static void phanQua(int[] arr) {
		int count = 0;
		int gifts = 0;
			for (int i = 100; i > -1; i--) {
				if (arr[i] > 0) {
					gifts += arr[i];
					count++;
				}
				if(count == 3)
					break;
			}
		System.out.print("\nSo phan qua phai tang la: " + gifts);
	}
}
