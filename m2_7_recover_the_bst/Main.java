package m2_7_recover_the_bst;

import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    TreeNode first = null; // First incorrectly placed node
    TreeNode second = null; // Second incorrectly placed node
    TreeNode prev = new TreeNode(Integer.MIN_VALUE); // Previous node to track inorder traversal

    // Method to recover the BST by swapping the misplaced nodes
    public void recoverTree(TreeNode root) {
        inorder(root); // Perform inorder traversal to detect swapped nodes

        // Swap the values of the two misplaced nodes to restore the BST property
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    // Inorder traversal to detect misplaced nodes
    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Identify misplaced nodes
        if (first == null && prev.val >= node.val) {
            first = prev; // First misplaced node found
        }
        if (first != null && prev.val >= node.val) {
            second = node; // Second misplaced node found
        }
        prev = node; // Update prev node for next comparison

        inorder(node.right);
    }

    // Method to build a tree from a given input array
    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("N")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();
            
            // Process left child
            if (!nodes[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.left);
            }
            i++;
            
            // Process right child
            if (i < nodes.length && !nodes[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.right);
            }
            i++;
        }
        
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // Read tree nodes as space-separated values
        scanner.close();
        
        String[] nodes = input.split(" ");
        TreeNode root = buildTree(nodes); // Construct tree from input
        
        Main solution = new Main();
        solution.recoverTree(root); // Recover the swapped nodes

        // Print the corrected BST in inorder
        System.out.println("Inorder Traversal of Recovered BST:");
        printInorder(root);

        System.out.print("\n");
    }

    // Helper method to print inorder traversal of the tree
    private static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}