// This problem was asked by Microsoft.

// Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.

//   1
//  / \
// 2   3
//    / \
//   4   5

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinaryTree {

    TreeNode root;

    public void printLevelOrder() {
        if (root == null) {
            return; // If the tree is empty, do nothing
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Start with the root node

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll(); // Get the front node in the queue
            System.out.print(currentNode.value + " "); // Print the current node's value

            // Add the left child to the queue if it exists
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // Add the right child to the queue if it exists
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(5);

        System.out.println("Level order traversal of binary tree:");
        tree.printLevelOrder(); // Output: 1 2 3 4 5
    }
}
