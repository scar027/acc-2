package m3_1_vertical_order_traversal;

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

class Pair {
    TreeNode node;
    int hd;

    Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class Main {
    public static List<Integer> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> map = new TreeMap<>(); // TreeMap to maintain order
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            TreeNode node = temp.node;
            int hd = temp.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.val);

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        List<Integer> result = new ArrayList<>();
        for (List<Integer> nodes : map.values()) {
            result.addAll(nodes);
        }
        return result;
    }

    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();

            if (!nodes[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.left);
            }
            i++;

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
        String input = scanner.nextLine();
        scanner.close();

        String[] nodes = input.split(" ");
        TreeNode root = buildTree(nodes);

        List<Integer> result = verticalOrder(root);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
