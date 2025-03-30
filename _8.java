class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _8_ {
    private int count = 0;

    // Helper function to check if the subtree is unival
    public boolean isUnivalSubtree(TreeNode root) {
        // If the node is null, it's a unival subtree by definition
        if (root == null) {
            return true;
        }

        // Recursively check if the left and right subtrees are unival
        boolean leftIsUnival = isUnivalSubtree(root.left);
        boolean rightIsUnival = isUnivalSubtree(root.right);

        // If either left or right is not unival, return false
        if (!leftIsUnival || !rightIsUnival) {
            return false;
        }

        // If left child exists and its value doesn't match root, return false
        if (root.left != null && root.left.val != root.val) {
            return false;
        }

        // If right child exists and its value doesn't match root, return false
        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        // If all conditions are met, increment the count of unival subtrees
        count++;
        return true;
    }

    // Main function to count unival subtrees
    public int countUnivalSubtrees(TreeNode root) {
        // Call the helper function to count the unival subtrees
        isUnivalSubtree(root);
        return count;
    }

    public static void main(String[] args) {
        // Example tree:
        //        5
        //       / \
        //      1   5
        //     / \   \
        //    5   5   5

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        _8_ ut = new _8_();
        System.out.println("Number of unival subtrees: " + ut.countUnivalSubtrees(root));
    }
}

