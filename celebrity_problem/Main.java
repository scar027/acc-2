package celebrity_problem;

import java.util.Scanner;

public class Main {

  // Function to check if a person knows another
  static boolean knows(int[][] M, int a, int b) {
    return M[a][b] == 1;
  }

  // Function to find the celebrity
  static int findCelebrity(int[][] M, int n) {
    int candidate = 0;

    // Find the candidate for celebrity
    for (int i = 1; i < n; i++) {
      if (knows(M, candidate, i)) {
        // If candidate knows i, then candidate can't be the celebrity
        candidate = i;
      }
    }

    // Verify if the candidate is the celebrity
    for (int i = 0; i < n; i++) {
      // Candidate should not know anyone, and everyone should know the candidate
      if (i != candidate && (knows(M, candidate, i) || !knows(M, i, candidate))) {
        return -1; // No celebrity found
      }
    }
    return candidate; // Candidate is the celebrity
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Input number of people
    System.out.print("Enter the number of people: ");
    int n = scanner.nextInt();

    // Input the matrix of relationships (1 means knows, 0 means doesn't know)
    int[][] M = new int[n][n];
    System.out.println("Enter the matrix (0 for doesn't know, 1 for knows):");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        M[i][j] = scanner.nextInt();
      }
    }

    // Find and print the celebrity
    int celebrity = findCelebrity(M, n);
    if (celebrity == -1) {
      System.out.println("No celebrity found.");
    } else {
      System.out.println("The celebrity is person " + celebrity);
    }

    scanner.close();
  }
}