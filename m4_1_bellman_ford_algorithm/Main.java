package m4_1_bellman_ford_algorithm;

import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    private static int[] bellmanFord(int n, int m, List<int[]> edges, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        
        // Relax all edges n-1 times
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        // Check for negative-weight cycles
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dist[u] != INF && dist[u] + w < dist[v]) {
                return null; // Negative cycle detected
            }
        }
        
        return dist;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of nodes and edges
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        // List to store edges as (u, v, w)
        List<int[]> edges = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            edges.add(new int[]{u, v, w});
        }
        scanner.close();
        
        // Find shortest paths using Bellman-Ford Algorithm
        int[] dist = bellmanFord(n, m, edges, 0);
        
        // Print result
        if (dist == null) {
            System.out.println("-1"); // Negative cycle detected
        } else {
            for (int d : dist) {
                System.out.print((d == INF ? "-1" : d) + " ");
            }
            System.out.println();
        }
    }
}