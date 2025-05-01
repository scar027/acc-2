package m3_3_dfs;

import java.util.*;

public class Main{
    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> result) {
        visited[node] = true;
        result.add(node);
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of nodes
        int m = scanner.nextInt(); // Number of edges
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // Assuming an undirected graph
        }
        scanner.close();
        
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        
        dfs(0, adj, visited, result);
        
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}