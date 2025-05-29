//Determine whether a tree is a valid binary search tree.

// A binary search tree is a tree with two children, left and right, and satisfies the constraint that the key in the left child must be less than or equal to the root and the key in the right child must be greater than or equal to the root. 

public class _89_ValidBSTChecker {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Method to check if the binary tree is a valid BST
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper recursive method with min and max bounds
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) {
            // If we want to allow the left child to be less than or equal,
            // and the right child to be greater than or equal,
            // we adjust to <= and >= accordingly
            // Problem statement: left ≤ root and right ≥ root

            // But in the code below we will enforce:
            // Left child value <= root.val: node.val <= max
            // Right child value >= root.val: node.val >= min

            // Here, we want to allow node.val >= min and node.val <= max

            // Adjust condition accordingly
            return false;
        }

        // Check left subtree: node.left.val ≤ node.val
        // So max for left subtree is node.val
        // Check right subtree: node.right.val ≥ node.val
        // So min for right subtree is node.val

        boolean leftIsValid = isValidBST(node.left, min, node.val);
        boolean rightIsValid = isValidBST(node.right, node.val, max);

        return leftIsValid && rightIsValid;
    }

    // Main method with example tests
    public static void main(String[] args) {
        _89_ValidBSTChecker checker = new _89_ValidBSTChecker();

        // Test 1: a valid BST with <= and >= allowed
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(5);  // Equal to root allowed on left
        root1.right.left = new TreeNode(15); // Equal to root allowed on right
        root1.right.right = new TreeNode(20);

        System.out.println("Test 1 (should be true): " + checker.isValidBST(root1));

        // Test 2: invalid BST - left child greater than root
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(12); // Invalid: left child greater than root
        root2.right = new TreeNode(15);

        System.out.println("Test 2 (should be false): " + checker.isValidBST(root2));

        // Test 3: invalid BST - right child less than root
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(9); // Invalid: right child less than root

        System.out.println("Test 3 (should be false): " + checker.isValidBST(root3));

        // Test 4: single node (valid BST)
        TreeNode root4 = new TreeNode(10);
        System.out.println("Test 4 (should be true): " + checker.isValidBST(root4));

        // Test 5: empty tree (valid BST)
        TreeNode root5 = null;
        System.out.println("Test 5 (should be true): " + checker.isValidBST(root5));
    }
}

