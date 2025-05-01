package m6_5_longest_increasing_subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static int LIS(int n, int[] A) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1); // Every element is at least a subsequence of length 1

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (A[j] < A[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int maxLen = 0;
    for (int len : dp) {
      maxLen = Math.max(maxLen, len);
    }

    return maxLen;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] A = new int[n];

    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }

    System.out.println(LIS(n, A));
    sc.close();
  }
}
