package m3_2_boundary_traversal;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Main {
    
    // Function to print the left boundary (excluding leaf nodes)
    private static void printLeftBoundary(TreeNode node, List<Integer> boundary) {
        while (node != null) {
            if (node.left != null || node.right != null) 
                boundary.add(node.val); // Add non-leaf node to boundary
            
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Function to print all leaf nodes
    private static void printLeaves(TreeNode node, List<Integer> boundary) {
        if (node == null) return;
        printLeaves(node.left, boundary);
        if (node.left == null && node.right == null) // It's a leaf node
            boundary.add(node.val);
        printLeaves(node.right, boundary);
    }

    // Function to print the right boundary in reverse order (excluding leaf nodes)
    private static void printRightBoundary(TreeNode node, List<Integer> boundary) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (node.left != null || node.right != null)
                temp.add(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        Collections.reverse(temp); // Reverse to maintain anti-clockwise order
        boundary.addAll(temp);
    }

    // Function to print the boundary in anti-clockwise order
    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) return boundary;

        boundary.add(root.val); // Root is always part of the boundary

        // Print left boundary (excluding root and leaf nodes)
        printLeftBoundary(root.left, boundary);
        
        // Print leaf nodes
        printLeaves(root.left, boundary);
        printLeaves(root.right, boundary);

        // Print right boundary (excluding root and leaf nodes)
        printRightBoundary(root.right, boundary);

        return boundary;
    }

    // Function to build a binary tree from level order input
    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            if (!nodes[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // Read level order input
        scanner.close();
        
        String[] nodes = input.split(" ");
        TreeNode root = buildTree(nodes);

        List<Integer> result = boundaryTraversal(root);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}