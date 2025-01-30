package merge_sort;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LinkedList<Integer> list = new LinkedList<>();

    // Taking input
    System.out.println("Enter the number of elements in the linked list:");
    int n = scanner.nextInt();

    System.out.println("Enter the elements:");
    for (int i = 0; i < n; i++) {
      list.add(scanner.nextInt());
    }

    // Sorting the linked list
    Collections.sort(list);

    // Displaying the sorted list
    System.out.println("Sorted Linked List: " + list);

    scanner.close();
  }
}