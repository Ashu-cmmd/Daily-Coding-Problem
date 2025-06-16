// This problem was asked by Microsoft.

// Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.

//   1
//  / \
// 2   3
//    / \
//   4   5

import java.util.LinkedList;
import java.util.Queue;

// TreeNode class to define each node of the binary tree
class TreeNode {
    int value;  // Value of the node
    TreeNode left;  // Left child of the node
    TreeNode right;  // Right child of the node

    // Constructor to initialize the node with a value
    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class _107_BinaryTreeLevelOrder {

    TreeNode root;  // Root of the binary tree

    // Method to print level order traversal of the binary tree
    public void printLevelOrder() {
        if (root == null) {
            return;  // If the tree is empty, do nothing
        }

        // Queue to help with level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);  // Start with the root node

        // While there are nodes in the queue
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();  // Get the front node from the queue
            System.out.print(currentNode.value + " ");  // Print the value of the current node

            // Add the left child to the queue if it exists
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // Add the right child to the queue if it exists
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        System.out.println();  // Newline after traversal
    }

    // Main method to test the binary tree and level order traversal
    public static void main(String[] args) {
        _107_BinaryTreeLevelOrder tree = new _107_BinaryTreeLevelOrder();

        // Manually creating a sample binary tree:
        //          1
        //         / \
        //        2   3
        //           / \
        //          4   5

        tree.root = new TreeNode(1);  // Root node with value 1
        tree.root.left = new TreeNode(2);  // Left child of root with value 2
        tree.root.right = new TreeNode(3);  // Right child of root with value 3
        tree.root.right.left = new TreeNode(4);  // Left child of node 3 with value 4
        tree.root.right.right = new TreeNode(5);  // Right child of node 3 with value 5

        // Output the level order traversal of the binary tree
        System.out.println("Level order traversal of binary tree:");
        tree.printLevelOrder();  // Expected output: 1 2 3 4 5
    }
}
