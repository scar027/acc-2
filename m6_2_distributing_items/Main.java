package m6_2_distributing_items;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  static boolean checkCount(int arr[], int k) {
    HashMap<Integer, Integer> hash = new HashMap<>();

    // Count frequency of each sweet type
    for (int sweet : arr) {
      hash.put(sweet, hash.getOrDefault(sweet, 0) + 1);
    }

    // Check if any type exceeds 2 * k
    for (int count : hash.values()) {
      if (count > 2 * k) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Read the entire first line as array of sweet types
    String[] sweetsInput = sc.nextLine().trim().split(" ");
    int[] arr = new int[sweetsInput.length];

    for (int i = 0; i < sweetsInput.length; i++) {
      arr[i] = Integer.parseInt(sweetsInput[i]);
    }

    // Read number of customers
    int k = sc.nextInt();

    // Output result
    if (checkCount(arr, k)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    sc.close();
  }
}
