import java.util.Scanner;

public class fibonanci {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		if (n > 0) {
			if (n == 1)
				System.out.print(0);
			else {
				if (n == 2)
					System.out.print("0 1 ");
				else {
					System.out.print("0 1 ");
					fibonanci1(n);
				}
			}
		}
	}

	public static void fibonanci1(int n) {
		int f0 = 0;
		int f1 = 1;
		int s = 0;
		int i = 1;
		while (i <= n - 2) {
			s = f0 + f1;
			f0 = f1;
			f1 = s;
			i++;
			System.out.print(s + " ");
		}

	}

}
