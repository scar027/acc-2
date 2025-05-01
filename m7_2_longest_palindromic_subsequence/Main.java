package m7_2_longest_palindromic_subsequence;

import java.util.Scanner;

public class Main {
  public static int LPS(String x) {
    int n = x.length();
    int[][] dp = new int[n][n];

    // Base case: single characters are palindromes of length 1
    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }

    // Build the dp table
    for (int length = 2; length <= n; length++) {
      for (int i = 0; i <= n - length; i++) {
        int j = i + length - 1;
        if (x.charAt(i) == x.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[0][n - 1];
  }

  public static void main(String[] args) {
    // Read the input string
    Scanner sc = new Scanner(System.in);
    String x = sc.nextLine().trim();

    // Call the function and print the result
    System.out.println(LPS(x));
    sc.close();
  }
}
