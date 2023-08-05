import java.util.Scanner;
public class abcde {

	public static void main(String[] args) {
		System.out.print("nhap n co 5 so: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = n/10000;
		int b = (n-(a*10000))/1000;
		int c = (n - (a*10000 + b*1000))/100;
		int d = (n-(a*10000 + b*1000 + c*100))/10;
		int e = (n - (a*10000 + b*1000 + c*100 + d*10));
		int max = (a>b)?a:b;
		int max1 = (max>c)?max:c;
		int max2 = (max1>d)?max1:d;
		int max3 = (max2>e)?max2:e;
		System.out.println("so lon nhat la: " + max3);
		double avg = ((a+b+c+d+e)/5);
		System.out.println("trung binh cong la: "+avg );
		int i = 0;
		if (a%2==0) {
			++i;
		}
		if (b%2==0) {
			++i;
		}
		if (c%2==0) {
			++i;
		}
		if (d%2==0) {
			++i;
		}
		if (e%2==0) {
			++i;
		}
		System.out.printf("co %d so chan", i);
	sc.close();	
	
	}
	

}
