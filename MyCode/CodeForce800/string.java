import java.util.Scanner;

public class string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Write your code here.
        int i = sc.nextInt();
        double d = Double.parseDouble(sc.next());
        sc.nextLine();
        String s = sc.nextLine();


        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
