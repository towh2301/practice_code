import java.util.*;
import java.io.*;

class EIWIFI {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb;

    public static void main(String[] args) throws java.lang.Exception {
        sb = new StringBuilder();
        int tests = sc.nextInt();

        for (int i = 0; i < tests; i++) {
            // n & m is height and width respectively
            // do not count the boundary
            long n = sc.nextLong();
            long m = sc.nextLong();

            if (n < 3 || m < 3) {
                sb.append(0).append("\n");
            } else {
                n -= 2;
                m -= 2;
                countLight(n, m);
            }
        }
        System.out.println(sb);
    }

    public static void countLight(long n, long m) {

        // divide each by 3, if there is a remainder => + 1
        long height = (n % 3 != 0) ? (n / 3 + 1) : (n / 3);
        long width = (m % 3 != 0) ? (m / 3 + 1) : (m / 3);

        // count light
        sb.append(height * width).append("\n");
    }
}
