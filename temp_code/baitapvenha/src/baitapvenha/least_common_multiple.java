package baitapvenha;
import java.util.Scanner;
public class least_common_multiple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		LCM(a, b);
		sc.close();

	}
	public static void LCM(int a, int b) {
		int s = 0;
		for (int i = 1; i > 0; i++) {
			s = a*i;
			if (s%b==0) {
				break;
			}
		}
		System.out.println(s);
	}

}
