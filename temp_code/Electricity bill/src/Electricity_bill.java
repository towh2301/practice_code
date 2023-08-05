import java.util.Scanner;

class Electricity_bill {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong();
		long a;
		if (k <= 100)
			a = k * 200;
		else if (k <= 1100)
			a = 100 * 200 + (k - 100) * 500;
		else if (k <= 3100)
			a = 100 * 200 + 1000 * 500 + (k - 1100) * 1000;
		else if (k <= 8100)
			a = 100 * 200 + 1000 * 500 + 2000 * 1000 + (k - 3100) * 10000;
		else if (k <= 18100)
			a = 100 * 200 + 1000 * 500 + 2000 * 1000 + 5000 * 10000 + (k - 8100) * 12000;
		else
			a = 100 * 200 + 1000 * 500 + 2000 * 1000 + 5000 * 10000 + 10000 * 12000 + (k - 18100) * 100000;
		System.out.println(a);
		sc.close();

	}

}
