package m1_2_sort_the_bitonic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LinkedList<Integer> bitonicList = new LinkedList<>();

    // ✅ Step 1: Take User Input
    System.out.println("Enter the number of elements in the bitonic linked list:");
    int n = scanner.nextInt();

    System.out.println("Enter " + n + " elements (bitonic sequence):");
    for (int i = 0; i < n; i++) {
      bitonicList.add(scanner.nextInt());
    }

    System.out.println("Original Bitonic List: " + bitonicList);

    // ✅ Step 2: Sort using Collections.sort()
    Collections.sort(bitonicList);

    // ✅ Step 3: Print the sorted list
    System.out.println("Sorted Linked List: " + bitonicList);

    scanner.close();
  }
}
