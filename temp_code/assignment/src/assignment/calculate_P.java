package assignment;

import java.util.Scanner;

public class calculate_P {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		double i = 0;
		double P = 1;
		if (y < 0 && i!=0) {
			while (i >= y + 1) {
				P = (x * P);
				i--;
			}
			P = 1 / P;
			System.out.printf("%d^%d = %.5f", x, y, P);
		} else {
			if (y > 0) {
				while (i <= y - 1) {
					P = x * P;
					i++;
				}
				System.out.printf("%d^%d = %.0f", x, y, P);
			}else 
				if (y==0)
					System.out.println(1);
		}

		sc.close();

	}
}
