import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char x) {
        val = x;
    }
}

public class _80_DeepestNodeFinder {
    public TreeNode findDeepestNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode deepestNode = null;

        while (!queue.isEmpty()) {
            deepestNode = queue.poll(); // Get the front node

            // Add left and right children to the queue
            if (deepestNode.left != null) {
                queue.offer(deepestNode.left);
            }
            if (deepestNode.right != null) {
                queue.offer(deepestNode.right);
            }
        }

        return deepestNode; // The last node processed is the deepest node
    }

    public static void main(String[] args) {
        // Construct the tree
        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('c');
        root.left.left = new TreeNode('d');

        _80_DeepestNodeFinder finder = new _80_DeepestNodeFinder();
        TreeNode deepestNode = finder.findDeepestNode(root);
        System.out.println("The deepest node is: " + deepestNode.val); // Output: d
    }
}
