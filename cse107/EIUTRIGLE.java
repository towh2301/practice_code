import java.io.*;
import java.util.*;

class EIUTRIGLE {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int len = sc.nextInt();
        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr.length >= 3)
            System.out.println(solve(arr, len));
        else
            System.out.println(0);
    }

    public static int solve(long[] arr, int len) {
        Arrays.sort(arr);
        int count = 0;

        for (int i = len - 1; i >= 2; i--) {
            for (int j = 0; j < i - 1; j++) {
                for (int k = j + 1; k < i; k++) {
                    if (arr[j] + arr[k] > arr[i]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}