package m2_8_right_view_of_binary_tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    private static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("-1")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            
            if (!values[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.left);
            }
            i++;
            
            if (i < values.length && !values[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.right);
            }
            i++;
        }
        
        return root;
    }
    
    private static void printRightView(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                if (i == size - 1) { // Last node of each level
                    System.out.print(current.val + " ");
                }
                
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read level order input
        String[] values = scanner.nextLine().split(" ");
        scanner.close();
        
        // Build the binary tree
        TreeNode root = buildTree(values);
        
        // Print right view of the tree
        printRightView(root);
    }
}