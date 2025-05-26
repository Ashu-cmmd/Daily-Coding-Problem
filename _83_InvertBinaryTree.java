// This problem was asked by Google.

// Invert a binary tree.

// For example, given the following tree:

//     a
//    / \
//   b   c
//  / \  /
// d   e f
// should become:

//   a
//  / \
//  c  b
//  \  / \
//   f e  d

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char x) {
        val = x;
    }
}

public class _83_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('c');
        root.left.left = new TreeNode('d');
        root.left.right = new TreeNode('e');
        root.right.left = new TreeNode('f');

        _83_InvertBinaryTree inverter = new _83_InvertBinaryTree();
        TreeNode invertedRoot = inverter.invertTree(root);

        // You can add a method to print the tree to verify the result
        printTree(invertedRoot);
    }

    // Method to print the tree in a pre-order manner
    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
