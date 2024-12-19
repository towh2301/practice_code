import java.util.*;

public class EIUBIRTH {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            sb.append(buyGifts()).append("\n");
        }
        System.out.println(sb);
    }

    public static long buyGifts() {
        long b = sc.nextInt();
        long r = sc.nextInt();
        long x = sc.nextInt();
        long y = sc.nextInt();
        long z = sc.nextInt();

        // if prices are equal ==> buy 2 types else buy smaller one
        if (x == y || z > Math.abs(x - y))
            return ((x * b) + (y * r));
        if (x < y)
            return ((x * (b + r)) + (z * r));
        if (x > y)
            return ((y * (b + r)) + (z * b));

        return 0;
    }
}
