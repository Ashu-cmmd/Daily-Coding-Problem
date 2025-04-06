class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class _36_BinarySearchTree {

    // Function to find the second largest node
    public static TreeNode findSecondLargest(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return null; // No second largest if the tree is empty or has only one node
        }

        TreeNode parent = null;
        TreeNode current = root;

        // Traverse to the rightmost node
        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        // Case 1: If the rightmost node has a left child, find the largest in the left subtree
        if (current.left != null) {
            return findLargest(current.left);
        }

        // Case 2: If the rightmost node has no left child, the parent is the second largest
        return parent;
    }

    // Helper function to find the largest node in a tree
    private static TreeNode findLargest(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        // Example to test the implementation
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        TreeNode secondLargest = findSecondLargest(root);
        if (secondLargest != null) {
            System.out.println("Second largest node is: " + secondLargest.val);
        } else {
            System.out.println("There is no second largest node.");
        }
    }
}
