package m1_1_loop_detection;

import java.util.LinkedList;
import java.util.HashSet;

class LinkedListLoopDetection {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // ✅ Method 1: Detect Loop using HashSet (Uses contains() method)
  public static boolean detectLoopUsingHashSet(Node head) {
    HashSet<Node> visitedNodes = new HashSet<>();
    Node temp = head;

    while (temp != null) {
      if (visitedNodes.contains(temp)) {
        return true; // Loop detected
      }
      visitedNodes.add(temp);
      temp = temp.next;
    }
    return false; // No loop
  }

  // ✅ Method 2: Detect Loop using Floyd’s Cycle Detection Algorithm
  public static boolean detectLoopUsingTwoPointers(Node head) {
    Node slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next; // Move one step
      fast = fast.next.next; // Move two steps

      if (slow == fast) {
        return true; // Loop detected
      }
    }
    return false; // No loop
  }

  public static void main(String[] args) {
    // ✅ Using Java's Built-in LinkedList to store values
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);

    // ✅ Manually creating a linked list with a loop
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = head.next; // Creating a loop

    // 🔍 Detect Loop using HashSet
    if (detectLoopUsingHashSet(head)) {
      System.out.println("Loop detected using HashSet!");
    } else {
      System.out.println("No loop detected using HashSet.");
    }

    // 🔍 Detect Loop using Floyd's Cycle Detection Algorithm
    if (detectLoopUsingTwoPointers(head)) {
      System.out.println("Loop detected using Two Pointers!");
    } else {
      System.out.println("No loop detected using Two Pointers.");
    }
  }
}