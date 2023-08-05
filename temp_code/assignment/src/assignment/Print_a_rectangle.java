package assignment;
import java.util.Scanner;
public class Print_a_rectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int i = 0;
		int e = 0;
		while (i < n) {
			while (e<m) {
				System.out.print("* ");
				e++;
			}
			System.out.println();
			i++;
			e=0;
		}
		sc.close();

	}

}
