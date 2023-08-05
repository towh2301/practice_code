import java.util.Scanner;

public class quadratic_equation_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap a:");
		double a = sc.nextDouble();
		System.out.print("Nhap b:");
		double b = sc.nextDouble();
		System.out.print("Nhap c:");
		double c = sc.nextDouble();
		sc.close();
		System.out.println("Phuong trinh cua ban la: " + a +  "x^2 " + " + " + b + "x " + " + "+ c + " = 0");
		Double delta = b*b - 4*a*c;
		if (delta >= 0) {
			double x1 = (-b + Math.sqrt(delta))/(2*a);
			double x2 = (-b - Math.sqrt(delta))/(2*a);
			if (x1==x2) {
				System.out.println("Phuong trinh co duy nhat 1 nghiem: x = " + x1);
			}else {
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
			}
		}else {
			System.out.println("Phuong trinh vo nghiem!");
		}
		
	}

}
