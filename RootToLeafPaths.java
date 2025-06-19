// This problem was asked by Facebook.

// Given a binary tree, return all paths from the root to leaves.

// For example, given the tree:

//    1
//   / \
//  2   3
//     / \
//    4   5
// Return [[1, 2], [1, 3, 4], [1, 3, 5]]

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {
    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> getAllPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(TreeNode node, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;

        currentPath.add(node.val);

        // If it's a leaf node, add a copy of the path to result
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Otherwise, continue DFS
            dfs(node.left, currentPath, result);
            dfs(node.right, currentPath, result);
        }

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    }

    // Example usage
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<List<Integer>> paths = getAllPaths(root);
        System.out.println(paths);  // Output: [[1, 2], [1, 3, 4], [1, 3, 5]]
    }
}

