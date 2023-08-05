import java.util.Scanner;

public class Sn {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double s = 0;
		double Sn = 0;
		int n = sc.nextInt();
		for (int i = 1; i<=n; i++) {
			s = s+i;
			Sn = Sn + (double)(1/(s));
		}
		System.out.println(Sn);
		sc.close();

	}

}
