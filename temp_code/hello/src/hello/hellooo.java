package hello;

import java.util.Scanner;

public class hellooo {
	public static void main(String[]args) {
		int a = 438, b = 238;
		System.out.println("124 + 233 = "+ (124+233));
		System.out.println("a + b = " + a + " + " + b + " = " + (a+b));
		String name = "Codelearn";
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap c: ");
		int c = sc.nextInt();
		System.out.print("Nhap d: ");
		int d = sc.nextInt();
		System.out.println("Dien tich hinh chu nhat la: "+(c*d));
		System.out.println(a>b);
		System.out.print("Nhap e : ");
		double e = sc.nextDouble();
		System.out.print("Nhap ki tu bat ki: ");
		char f = (char)(sc.next().charAt(0)+e);
		System.out.println("3 chu cai tiep theo la: " + f);
		sc.close();
		System.out.println(name);
	}

}
