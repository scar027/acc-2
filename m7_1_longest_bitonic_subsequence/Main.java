package m7_1_longest_bitonic_subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static int LBS(int[] arr, int n) {
    int[] lis = new int[n];
    int[] lds = new int[n];

    Arrays.fill(lis, 1);
    Arrays.fill(lds, 1);

    // Compute LIS
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
          lis[i] = lis[j] + 1;
        }
      }
    }

    // Compute LDS
    for (int i = n - 2; i >= 0; i--) {
      for (int j = n - 1; j > i; j--) {
        if (arr[j] < arr[i] && lds[i] < lds[j] + 1) {
          lds[i] = lds[j] + 1;
        }
      }
    }

    // Compute maximum of lis[i] + lds[i] - 1
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      maxLen = Math.max(maxLen, lis[i] + lds[i] - 1);
    }

    return maxLen;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    while (T-- > 0) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(LBS(arr, N));
    }
    sc.close();
  }
}
