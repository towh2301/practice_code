import java.util.Scanner;
public class new_lesson {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = 0;
		
		if (b > a) {
			d = a;
			a = b;
			b = d;
		}
		if(c > a) {
			d = c;
			c = a;
			a = d; 
		}
		if (c>b){
			d = b;
			b = c;
			c = d;
		}
		sc.close();
		
		System.out.printf("%d, %d, %d", c,b,a);
	}
		

}
