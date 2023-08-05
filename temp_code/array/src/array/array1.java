package array;

import java.util.Random;
import java.util.Scanner;

public class array1 {
	static Random rd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] number = input();
		output(number);
		System.out.print("\nMax number is: " + maxnumber(number));
		secondmaxnum(number);
		prime_numbers(number);
		maxprimenum(number);
		System.out.print("\nNegative max number is: " + negativeMaxNum(number));
		System.out.print("\nOod Negative max number is: " + oddNegativeMax(number));
		appearNum(number);

	}

	// Min Number
	public static int minnum(int[] a) {
		int min = maxnumber(a);
		for (int i : a) {
			if (i < min)
				min = i;
		}
		return min;
	}

	// hàm nhập liệu cho dãy
	public static int[] input() {
		System.out.print("input the number: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = (rd.nextInt(50) - 25);
		return arr;
	}

	// hàm xuất dữ liệu cho dãy
	public static void output(int[] a) {
		// for (int i : a)
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// prime number output function
	public static void prime_numbers(int[] a) {
		int count = 0;
		System.out.print("\nPrime number: ");
		for (int i = 0; i < a.length; i++) {
			if (primenum(a[i]) == true) {
				System.out.print(a[i] + " ");
				count++;
			}
		}
		System.out.print("\nDãy có " + count + " SNT");
	}

	// prime number check
	public static boolean primenum(int a) {
		if (a < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}

	// Max number function
	public static int maxnumber(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}

	// Max prime number
	public static void maxprimenum(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (primenum(a[i]) == true)
				if (max < a[i])
					max = a[i];
		}
		System.out.print("\nMax prime number is: " + max);
	}

	// Second max number
	public static void secondmaxnum(int[] a) {
		int max1 = 0;
		int max = maxnumber(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] < max)
				if (max1 < a[i])
					max1 = a[i];
		}
		System.out.print("\nSecond max is: " + max1);
	}

	// negative max number
	public static int negativeMaxNum(int[] a) {
		int min = minnum(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0)
				if (min < a[i])
					min = a[i];
		}
		return min;
	}

	// odd negative max number
	public static int oddNegativeMax(int[] a) {
		int minood = minnum(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0)
				if (minood < a[i])
					if (a[i] % 2 == 0)
						minood = a[i];
		}
		if (minood % 2 == 0)
			return minood;
		return 0;
	}

	// check oods or not array
	public static void kiemtradaychanhayle(int[] a) {
		for (int i : a) {

		}
	}

	// kiem tra so xuat hien nhieu lan nhat
	public static void appearNum(int[] a) {
		int count = 0;
		int[] appear = new int[a.length];
		int[] num = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			for (int e = 0; e < a.length; e++) {
				if (a[i] == a[e]) {
					count++;
					num[i] = a[i];
				}
				appear[i] = count;
				count = 0;
			}
		}

		int hz = maxnumber(appear);
		int number = num[maxnumberposition(appear)];
		if (hz == 0)
			System.out.print("\nKhông có số xuất hiện nhiều hơn 1 lần!");
		else
			System.out.print("\nSo " + number + " xuat hien nhieu nhat voi " + (hz + 1) + " lan!");

	}

	// tim vi tri cua so max
	public static int maxnumberposition(int[] a) {
		int max = 0;
		int e = 0;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
				e = i;
			}
			
		}
		return e;
	}

}