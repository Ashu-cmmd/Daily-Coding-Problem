import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class _8_ {
    private int count = 0;

    // Helper function to check if the subtree rooted at node is a unival tree
    private boolean isUnival(TreeNode node) {
        if (node == null) {
            return true;  // Null node is considered a unival tree
        }

        // Check if both left and right subtrees are unival
        boolean leftIsUnival = isUnival(node.left);
        boolean rightIsUnival = isUnival(node.right);

        // If either left or right subtree is not unival, return false
        if (!leftIsUnival || !rightIsUnival) {
            return false;
        }

        // If left child exists and is different from the node's value, it's not unival
        if (node.left != null && node.left.val != node.val) {
            return false;
        }

        // If right child exists and is different from the node's value, it's not unival
        if (node.right != null && node.right.val != node.val) {
            return false;
        }

        // If we reached here, this subtree is unival
        count++;  // Increment the count for the current unival subtree
        return true;
    }

    public int countUnivalSubtrees(TreeNode root) {
        count = 0;  // Reset the count before starting
        isUnival(root);  // Start the recursive process
        return count;
    }

    public static void main(String[] args) {
        // Example binary tree:
        //          5
        //         / \
        //        1   5
        //       / \   \
        //      5   5   5
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        _8_ solution = new _8_();
        int result = solution.countUnivalSubtrees(root);
        System.out.println("Number of unival subtrees: " + result);  // Output should be 5
    }
}
