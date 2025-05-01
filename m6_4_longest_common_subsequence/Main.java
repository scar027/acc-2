package m6_4_longest_common_subsequence;

import java.util.Scanner;

public class Main {
  public static int lcs(String x, String y) {
    int m = x.length();
    int n = y.length();

    int[][] dp = new int[m + 1][n + 1];

    // Build the dp table
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String x = sc.nextLine().trim();
    String y = sc.nextLine().trim();

    System.out.println(lcs(x, y));
    sc.close();
  }
}
