package assignment;

import java.util.Scanner;

public class n {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		show(arr, n);

	}
	
	public static void show(int[] a, int n){
		int[] res = new int[n];
		for (int i = 0; i<a.length; i++){
			if(a[i] % 3 ==0 && a[i] % 5!=0){
				System.out.print(a[i] + " ");
			}
		}
	}
}