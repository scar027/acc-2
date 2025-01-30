package m2_3_priority_queue;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {

  // Task class to store the task name and priority
  static class Task {
    String name;
    int priority;

    Task(String name, int priority) {
      this.name = name;
      this.priority = priority;
    }
  }

  public static void main(String[] args) {
    // PriorityQueue with a custom comparator to prioritize tasks with lower
    // priority numbers
    PriorityQueue<Task> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(task -> task.priority));

    // Inserting tasks with priority
    priorityQueue.add(new Task("Task A", 3));
    priorityQueue.add(new Task("Task B", 1));
    priorityQueue.add(new Task("Task C", 2));

    // Output the highest priority task
    System.out.println("Highest-priority task: " + priorityQueue.peek().name);

    // Execute tasks in priority order
    while (!priorityQueue.isEmpty()) {
      Task task = priorityQueue.poll();
      System.out.println("Executing: " + task.name);
    }
  }
}