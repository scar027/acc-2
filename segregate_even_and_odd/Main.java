package segregate_even_and_odd;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LinkedList<Integer> linkedList = new LinkedList<>();
    LinkedList<Integer> evenList = new LinkedList<>();
    LinkedList<Integer> oddList = new LinkedList<>();

    // ✅ Step 1: Take User Input
    System.out.println("Enter the number of elements:");
    int n = scanner.nextInt();

    System.out.println("Enter " + n + " elements:");
    for (int i = 0; i < n; i++) {
      int num = scanner.nextInt();
      linkedList.add(num); // Store in main list

      // ✅ Step 2: Separate Even and Odd elements
      if (num % 2 == 0) {
        evenList.addLast(num); // Add even to evenList
      } else {
        oddList.addLast(num); // Add odd to oddList
      }
    }

    // ✅ Step 3: Merge Even and Odd lists (Maintaining Order)
    evenList.addAll(oddList);

    // ✅ Step 4: Print the modified LinkedList
    System.out.println("Rearranged LinkedList: " + evenList);

    scanner.close();
  }
}
