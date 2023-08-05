
import java.util.Scanner;

public class gifts {

	public class so_phan_qua {
		static Scanner sc = new Scanner(System.in);
		

		public static void main(String[] args) {
			System.out.print("Nhap so hoc sinh: ");
			int n = sc.nextInt();
			int[] num = new int[n];
			System.out.print("\nNhap diem tung ban: ");
			num = input(n);
			gifts(num);
			sc.close();

		}

		// input
		public static int[] input(int n) {
			int[] arr = new int[n];
			for(int i = 0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
				//arr[i] = rd.nextInt(100);
			}
			return arr;
		}
		

		// so phan qua
		public static void gifts(int[] a) {
			int[] arr = new int[101];

			int count = 0;
			int gifts = 0;

			for (int i = 0; i < a.length; i++)
				arr[a[i]]++;

			while (count != 3)
				for (int i = 100; i > -1; i--)
					if (arr[i] > 0) {
						gifts += arr[i];
						count++;
					}
			System.out.print("\nSo phan qua phai tang la: " + gifts);
		}

	}
}
