import java.util.Scanner;

class Electric_build {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long max1 = 0;
		long max = -1;
		int count = 0;
		if (Math.abs(n) == 0) {
			System.out.println(0);
		} else {
			while (Math.abs(n) != 0) {
				max1 = n % 10;
				if (max1 > max && max1 % 2 == 0) {
					max = max1;
					count++;
				}
				n = n / 10;
			}
			if (count == 0) {
				System.out.println(-1);
			} else {
				System.out.println(max);
			}
		}
		sc.close();
	}
}
