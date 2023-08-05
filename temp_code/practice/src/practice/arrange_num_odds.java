package practice;

import java.util.Scanner;
import java.util.Random;

public class arrange_num_odds {
	static Scanner sc = new Scanner(System.in);
	static Random rd = new Random();

	public static void main(String[] args) {
		System.out.print("Nhap do dai day: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		arr = input(n);
		System.out.print("Day duoc nhap la: ");
		output(arr);
		arr = arrange(arr);
		System.out.print("\nDay duoc sap xep la: ");
		output(arr);
		
	}
	//input
	public static int[] input(int n) {
		int[] a = new int[n];
		for(int i = 0; i<a.length; i++) {
			a[i] = sc.nextInt();
			//a[i] = rd.nextInt(20);
		}
		return a;
	}
	
	//output
	public static void output(int[] a) {
		for(int i = 0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	//arrange function
	public static int[] arrange(int[] a) {
		for(int i = 0; i<a.length; i++) {
			for(int e = 0; e<a.length; e++) {
				if((a[i]%2==0 && a[e]%2==1) ||
						(a[i]%2==0 && a[e]%2==0 && a[i]<a[e])||
						(a[i]%2 == 1 && a[e] % 2 == 1 && a[i]<a[e])) {
					int t = a[i];
					a[i] = a[e];
					a[e] = t;
				}
			}
		}
		return a;
	}
}
