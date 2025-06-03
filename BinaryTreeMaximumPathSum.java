// Given a binary tree of integers, find the maximum path sum between two nodes. The path must go through at least one node, and does not need to go through the root.


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeMaximumPathSum {
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return maxPathSum;
    }

    private int calculateMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Calculate the maximum path sum of left and right subtrees
        int leftMax = Math.max(calculateMaxPathSum(node.left), 0); // Ignore negative paths
        int rightMax = Math.max(calculateMaxPathSum(node.right), 0); // Ignore negative paths

        // Update the maximum path sum considering the current node as the highest point
        maxPathSum = Math.max(maxPathSum, node.val + leftMax + rightMax);

        // Return the maximum path sum extending from the current node
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
        System.out.println("Maximum Path Sum: " + solution.maxPathSum(root)); // Output: 42
    }
}
