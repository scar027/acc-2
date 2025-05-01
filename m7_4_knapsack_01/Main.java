package m7_4_knapsack_01;

import java.util.*;


public class Main {
  public static int knapsack(int N, int W, int[] profit, int[] weight) {
    int[][] dp = new int[N + 1][W + 1];

    for (int i = 1; i <= N; i++) {
      for (int w = 1; w <= W; w++) {
        if (weight[i - 1] <= w) {
          dp[i][w] = Math.max(dp[i - 1][w],
              profit[i - 1] + dp[i - 1][w - weight[i - 1]]);
        } else {
          dp[i][w] = dp[i - 1][w];
        }
      }
    }

    return dp[N][W];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // number of items
    int W = sc.nextInt(); // knapsack capacity

    int[] profit = new int[N];
    int[] weight = new int[N];

    for (int i = 0; i < N; i++) {
      profit[i] = sc.nextInt();
    }

    for (int i = 0; i < N; i++) {
      weight[i] = sc.nextInt();
    }

    System.out.println(knapsack(N, W, profit, weight));
    sc.close();
  }
}
