// Given a tree, find the largest tree/subtree that is a BST.

// Given a tree, return the size of the largest tree/subtree that is a BST

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Result {
    int size; // Size of the largest BST
    int min;  // Minimum value in the subtree
    int max;  // Maximum value in the subtree
    boolean isBST; // Whether the subtree is a BST

    Result(int size, int min, int max, boolean isBST) {
        this.size = size;
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}

public class LargestBSTInTree {
    public int largestBSTSubtree(TreeNode root) {
        return largestBSTHelper(root).size;
    }

    private Result largestBSTHelper(TreeNode node) {
        if (node == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Result left = largestBSTHelper(node.left);
        Result right = largestBSTHelper(node.right);

        // Check if the current node is a BST
        if (left.isBST && right.isBST && left.max < node.val && right.min > node.val) {
            // Current node is a BST
            int size = left.size + right.size + 1;
            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);
            return new Result(size, min, max, true);
        } else {
            // Current node is not a BST
            return new Result(Math.max(left.size, right.size), 0, 0, false);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        LargestBSTInTree solution = new LargestBSTInTree();
        int largestBSTSize = solution.largestBSTSubtree(root);
        System.out.println("Size of the largest BST subtree: " + largestBSTSize);
    }
}
