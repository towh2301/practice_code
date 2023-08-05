package assignment;

import java.util.Scanner;

public class Print_an_empty_rectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int i = 0;
		int e = 0;
		while (i < n) {

			if (i == 0 || i == n - 1) {
				while (e < m) {
					System.out.print("* ");
					e++;
				}
			}else
			if (i>0 && i<n-1) {
				while (e<m) {
					if (e==0 || e==m-1) {
						System.out.print("* ");
					}else
						System.out.print("  ");
					
					e++;
				}
			}
				

			System.out.println();
			i++;
			e = 0;
		}
		sc.close();
	}
}
