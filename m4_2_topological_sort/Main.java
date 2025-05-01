package m4_2_topological_sort;

import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList; // Adjacency list representation of the graph
    private int vertices; // Number of vertices in the graph

    // Constructor to initialize the graph with given number of vertices
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList.put(i, new ArrayList<>());
        }
    }

    // Method to create a directed edge from u to v
    public void createEdge(int u, int v) {
        this.adjacencyList.get(u).add(v);
    }

    // Method to perform Topological Sort using Kahn's Algorithm
    public void topologicalSort() {
        int[] totalIndegree = new int[vertices]; // Array to store in-degree of each vertex
        
        // Calculate in-degree of each vertex
        for (int i = 0; i < vertices; i++) {
            for (int j : adjacencyList.get(i)) {
                totalIndegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>(); // Queue to process vertices with 0 in-degree
        
        // Enqueue all vertices with 0 in-degree
        for (int i = 0; i < vertices; i++) {
            if (totalIndegree[i] == 0) {
                queue.add(i);
            }
        }

        int visitedNodes = 0; // Counter to track visited nodes
        List<Integer> order = new ArrayList<>(); // List to store the topological order

        while (!queue.isEmpty()) {
            int u = queue.poll(); // Remove a vertex with 0 in-degree
            order.add(u);

            // Reduce in-degree for all its adjacent vertices
            for (int i : adjacencyList.get(u)) {
                totalIndegree[i]--;
                if (totalIndegree[i] == 0) {
                    queue.add(i); // Add new vertices with 0 in-degree to the queue
                }
            }
            visitedNodes++;
        }

        // Check for cycle in the graph (i.e., if not all vertices are visited)
        if (visitedNodes != vertices) {
            System.out.println("There's a cycle present in the Graph.\nGiven graph is not DAG");
        } else {
            System.out.println(order); // Print the topological order
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();
        
        Graph graph = new Graph(vertices);
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.createEdge(u, v);
        }
        scanner.close();
        
        graph.topologicalSort(); // Perform topological sorting
    }
}