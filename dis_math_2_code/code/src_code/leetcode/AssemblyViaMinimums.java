package src_code.leetcode;

import java.util.Arrays;
import java.util.Scanner;

// 1857C - Assembly via Minimums code_force
public class AssemblyViaMinimums {
  static Scanner sc = new Scanner(System.in);
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    solve();
    System.out.println(sb);
  }

  public static void solve() {
    int t = sc.nextInt();
    while (t > 0) {
      t--;

      //
      int n = sc.nextInt();
      int m = n * (n - 1) / 2;
      int[] arr = new int[m];
      for (int i = 0; i < m; i++) {
        arr[i] = sc.nextInt();
      }
      Arrays.sort(arr);
      for (int i = 0; i < m; i += --n) {
        sb.append(arr[i]).append(" ");
      }
      sb.append(-1).append("\n");
    }
  }

}
