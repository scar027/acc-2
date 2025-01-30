package m2_4_sort_without_extra_space;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    // Create a Queue (LinkedList in this case)
    Queue<Integer> queue = new LinkedList<>();

    // Add elements to the queue
    queue.add(3);
    queue.add(1);
    queue.add(2);
    queue.add(5);
    queue.add(4);

    // Print original queue
    System.out.println("Original Queue: " + queue);

    // Convert queue to a priority queue to sort it
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(queue);

    // Now, print the sorted queue
    System.out.println("Sorted Queue: " + priorityQueue);
  }
}
