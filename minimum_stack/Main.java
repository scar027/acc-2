package minimum_stack;

import java.util.Scanner;
import java.util.Stack;

class MinStack {  // No need for 'public' since it's in the same package
  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  // Push element onto the stack and update the minStack
  public void push(int element) {
    stack.push(element);
    if (minStack.isEmpty() || element <= minStack.peek()) {
      minStack.push(element);
    }
  }

  // Pop element from the stack and update the minStack if needed
  public void pop() {
    if (!stack.isEmpty()) {
      int poppedElement = stack.pop();
      if (poppedElement == minStack.peek()) {
        minStack.pop();
      }
    }
  }

  // Get the top element of the stack
  public int top() {
    return stack.isEmpty() ? -1 : stack.peek(); // Return -1 if stack is empty
  }

  // Get the minimum element from the minStack
  public int getMin() {
    return minStack.isEmpty() ? -1 : minStack.peek(); // Return -1 if minStack is empty
  }
}

// Main class
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    MinStack minStack = new MinStack();

    System.out.println("Enter the number of operations you want to perform:");
    int n = scanner.nextInt();

    for (int i = 0; i < n; i++) {
      System.out.println("Choose operation: 1. Push 2. Pop 3. Get Min 4. Top");
      int operation = scanner.nextInt();

      switch (operation) {
        case 1:
          System.out.println("Enter element to push:");
          int element = scanner.nextInt();
          minStack.push(element);
          System.out.println("Pushed " + element);
          break;
        case 2:
          minStack.pop();
          System.out.println("Popped top element");
          break;
        case 3:
          int min = minStack.getMin();
          System.out.println("Current minimum element: " + min);
          break;
        case 4:
          int top = minStack.top();
          System.out.println("Current top element: " + top);
          break;
        default:
          System.out.println("Invalid operation");
      }
    }

    scanner.close();
  }
}
