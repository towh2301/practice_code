import java.util.Scanner;
public class String_count {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String s = sc.next();
		char c = sc.next().charAt(0);
		int count = -1;
		for(int i = 0; i<s.length(); i++) {
			if(c==s.charAt(i)) {
				count=i;
				break;
			}
				
			
		}
		System.out.println(count);
		
	}

}
