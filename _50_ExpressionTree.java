// Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
// Define the TreeNode class
class TreeNode {
    String val;
    TreeNode left, right;

    public TreeNode(String val) {
        this.val = val;
    }
}

public class _50_ExpressionTree {

    // Main evaluation function
    public static int evaluate(TreeNode root) {
        // Base case: if it's a leaf node, parse and return the integer
        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.val);
        }

        // Recursive calls for left and right subtree
        int leftVal = evaluate(root.left);
        int rightVal = evaluate(root.right);

        // Apply the operator at this node
        switch (root.val) {
            case "+": return leftVal + rightVal;
            case "-": return leftVal - rightVal;
            case "*": return leftVal * rightVal;
            case "/": return leftVal / rightVal;
            default: throw new IllegalArgumentException("Invalid operator: " + root.val);
        }
    }

    // Build and test the tree
    public static void main(String[] args) {
        /*
            Expression: (3 + 2) * (4 + 5)
                   *
                  / \
                 +   +
                / \ / \
               3  2 4  5
        */

        TreeNode root = new TreeNode("*");
        root.left = new TreeNode("+");
        root.right = new TreeNode("+");

        root.left.left = new TreeNode("3");
        root.left.right = new TreeNode("2");

        root.right.left = new TreeNode("4");
        root.right.right = new TreeNode("5");

        int result = evaluate(root);
        System.out.println("Result: " + result); // Should print 45
    }
}
