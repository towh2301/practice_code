package lab7;

import java.util.Random;
import java.util.Scanner;

public class gifts {

	public class so_phan_qua {
		static Scanner sc = new Scanner(System.in);
		static Random rd = new Random();

		public static void main(String[] args) {
			int n = sc.nextInt();
			int[] num = new int[n];

			num = input(n);
			System.out.print("\nSo phan qua phai tang la: " + gifts(num));

		}

		// input
		public static int[] input(int n) {
			int[] arr = new int[n];
			for(int i = 0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			return arr;
		}
		

		// so phan qua
		public static int gifts(int[] a) {
			int[] arr = new int[101];

			int count = 0;
			int gifts = 0;

			for (int i = 0; i < a.length; i++)
				arr[a[i]]++;

			while (count != 3)
				for (int i = arr.length - 1; i > -1; i--)
					if (arr[i] != 0) {
						gifts += arr[i];
						count++;
					}
			return gifts;
		}

	}
}
