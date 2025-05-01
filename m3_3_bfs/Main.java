package m3_3_bfs;

import java.util.*;

public class Main {
    private static void bfsTraversal(List<List<Integer>> adjList, int nodes) {
        // Array to track visited nodes
        boolean[] visited = new boolean[nodes];
        // Queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        
        // Start BFS from node 0
        queue.add(0);
        visited[0] = true;
        
        System.out.print("BFS : ");
        while (!queue.isEmpty()) {
            int current = queue.poll(); // Dequeue a node
            System.out.print(current + " "); // Print node
            
            // Enqueue all unvisited neighbors
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println(); // Print new line after traversal
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of nodes in the graph
        int nodes = scanner.nextInt();
        
        // If no nodes exist, print message and return
        if (nodes == 0) {
            System.out.println("Graph doesn't exist");
            scanner.close();
            return;
        }
        
        // Create adjacency list to store graph edges
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Read edges until -1 -1 is encountered
        while (true) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            if (u == -1 && v == -1) break; // Stop reading edges
            
            adjList.get(u).add(v); // Add edge from u to v
        }
        scanner.close();
        
        // Perform BFS traversal starting from node 0
        bfsTraversal(adjList, nodes);
    }
}
