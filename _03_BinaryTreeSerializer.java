import java.util.LinkedList;
import java.util.Queue;

public class _03_BinaryTreeSerializer {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Serializes a tree to a single string using level-order traversal.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("null,");
            }
        }

        // Remove the trailing comma
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Deserializes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }

        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode node = queue.poll();

            // Left child
            if (!nodes[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(node.left);
            }
            i++;

            // Right child
            if (i < nodes.length && !nodes[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    // Example usage
    public static void main(String[] args) {
        _03_BinaryTreeSerializer serializer = new _03_BinaryTreeSerializer();

        // Create a sample tree:
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Serialize the tree
        String serialized = serializer.serialize(root);
        System.out.println("Serialized: " + serialized);

        // Deserialize the string back to tree
        TreeNode deserializedRoot = serializer.deserialize(serialized);
        String deserializedSerialized = serializer.serialize(deserializedRoot);
        System.out.println("Deserialized and serialized again: " + deserializedSerialized);
    }
}