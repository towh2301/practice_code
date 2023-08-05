package array;

import java.util.Random;
import java.util.Scanner;

public class array_begining {
	static Random rd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] num = input();
		output(num);
			
		System.out.println("\n"+sumEle(num));
		average(num);
	}

	// hàm xuất ra các phần tử ở vị trí chẵn trong dãy
	public static void printEvenIdx(int[] e) {
		for (int i = 0; i < e.length; i += 2)
			System.out.print(e[i] + "  ");
	}
	// hàm tính tổng các phần tử chẵn trong dãy
	public static int sumEle(int[]e) {
		int s=0;
		for(int i:e)
			if(i%2==0)
				s+=i;
		return s;
	}
	// hàm xuất ra các phần tử lớn hơn phần tử trung bình cộng của dãy
	public static void average (int[]e) {
		double s = 0;
		for (int i:e) {
			s = s + (double)e[i]/e.length;								
		}
		for (int i : e )
			if (i > s)
				System.out.print(e + " ");
			
	}
	// hàm xuất ra các phần tử là SN.tố trong dãy
	// hàm đếm xem dãy có bao nhiêu phần tử là SNT
	// hàm tìm phần tử lớn nhất trong dãy
	// hàm tìm phần tử là số nguyên tố lớn nhất trong dãy
	// hàm tìm phần tử lớn thứ nhì trong dãy
	// hàm tìm phần tử âm lớn nhất trong dãy (có số âm)
	// hàm tìm phần tử âm chẵn lớn nhất trong dãy (có số âm)
	// hàm kiểm tra dãy có toàn số chẵn/lẻ/âm/dương hay không?
	// hàm tìm phần tử xuất hiện nhiều lần nhất trong dãy.

	// hàm xuất ra các phần tử chẵn trong dãy
	public static void printEvenEle(int[] e) {
		for (int i : e)
			if (i % 2 == 0)
				System.out.print(i + "  ");
	}

	// hàm input dùng để nhập dữ liệu cho 1 dãy
	public static int[] input() {
		System.out.println("input the number: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = rd.nextInt(10);
		return arr;
	}

	// hàm output xuất 1 dãy ra màn hình
	public static void output(int[] a) {
		// for(int i=0;i<a.length;i++)
		for (int i : a)
			System.out.print(i + "  ");
		System.out.println();
	}
}
 