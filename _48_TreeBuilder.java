// Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

// For example, given the following preorder traversal:

// [a, b, d, e, c, f, g]

// And the following inorder traversal:

// [d, b, e, a, f, c, g]

// You should return the following tree:

//     a
//    / \
//   b   c
//  / \ / \
// d  e f  g

import java.util.*;

class TreeNode {
    char val;
    TreeNode left, right;

    TreeNode(char x) {
        val = x;
    }
}

public class _48_TreeBuilder {

    private static int preorderIndex = 0;

    public static TreeNode buildTree(char[] preorder, char[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        Map<Character, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        preorderIndex = 0; // Reset global index
        return helper(preorder, 0, inorder.length - 1, inorderMap);
    }

    private static TreeNode helper(char[] preorder, int inStart, int inEnd, Map<Character, Integer> inorderMap) {
        if (inStart > inEnd) {
            return null;
        }

        // Pick current root from preorder traversal
        char rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Root has no children
        if (inStart == inEnd) {
            return root;
        }

        // Find the index of root in inorder traversal
        int inIndex = inorderMap.get(rootVal);

        // Build left and right subtrees
        root.left = helper(preorder, inStart, inIndex - 1, inorderMap);
        root.right = helper(preorder, inIndex + 1, inEnd, inorderMap);

        return root;
    }

    // For testing: print tree in inorder
    public static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }

    // For testing: print tree in preorder
    public static void printPreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    public static void main(String[] args) {
        char[] preorder = {'a', 'b', 'd', 'e', 'c', 'f', 'g'};
        char[] inorder = {'d', 'b', 'e', 'a', 'f', 'c', 'g'};

        TreeNode root = buildTree(preorder, inorder);

        System.out.println("Reconstructed tree (Inorder Traversal):");
        printInOrder(root); // should match inorder
        System.out.println("\nReconstructed tree (Preorder Traversal):");
        printPreOrder(root); // should match preorder
    }
}
