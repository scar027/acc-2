package m7_3_subset_sum;

import java.util.Scanner;

public class Main {
  public static boolean isSubsetSum(int[] arr, int N, int M) {
    boolean[][] dp = new boolean[N + 1][M + 1];

    // Initialize: 0 sum is always possible with empty subset
    for (int i = 0; i <= N; i++) {
      dp[i][0] = true;
    }

    // Fill the DP table
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[N][M];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Read N and M
    int N = sc.nextInt();
    int M = sc.nextInt();

    // Read array
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    // Output result
    if (isSubsetSum(arr, N, M)) {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }
    sc.close();
  }
}
