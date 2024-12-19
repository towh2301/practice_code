import java.util.*;
import java.io.*;

class EIMONE {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws java.lang.Exception {
        long price = sc.nextLong();
        int[] notes = { 20, 10, 5, 1 };

        exchange(price, notes);
        System.out.println(sb);
    }

    public static void exchange(long price, int[] notes) {
        long remain = price;
        int idx = 0;
        while (idx < 4) {
            long temp = remain / notes[idx];
            if (temp > 0) {
                remain -= temp * notes[idx];
                sb.append(notes[idx]).append(" ").append(temp).append("\n");
            }
            idx++;
        }
    }
}
