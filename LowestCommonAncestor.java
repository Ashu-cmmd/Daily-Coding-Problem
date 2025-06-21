// This problem was asked by Twitter.

// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. Assume that each node in the tree also has a pointer to its parent.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LowestCommonAncestor {
    // Returns the lowest common ancestor of nodes p and q
    public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        Set<TreeNode> ancestors = new HashSet<>();
        
        // Add all ancestors of p
        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }

        // Check for the first common ancestor with q's ancestors
        while (q != null) {
            if (ancestors.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        
        // If no LCA found (should not happen if both nodes are in the tree)
        return null;
    }

    public static void main(String[] args) {
        // Build a sample binary tree:
        //          3
        //         / \
        //        5   1
        //       / \ / \
        //      6  2 0  8
        //        / \
        //       7   4

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.parent = root;
        root.right = new TreeNode(1);
        root.right.parent = root;

        root.left.left = new TreeNode(6);
        root.left.left.parent = root.left;
        root.left.right = new TreeNode(2);
        root.left.right.parent = root.left;

        root.left.right.left = new TreeNode(7);
        root.left.right.left.parent = root.left.right;
        root.left.right.right = new TreeNode(4);
        root.left.right.right.parent = root.left.right;

        root.right.left = new TreeNode(0);
        root.right.left.parent = root.right;
        root.right.right = new TreeNode(8);
        root.right.right.parent = root.right;

        // Test cases:
        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();

        // Case 1: LCA of 5 (Node with val=5) and 1 (Node with val=1)
        TreeNode res1 = lcaFinder.lowestCommonAncestor(root.left, root.right);
        System.out.println("LCA of 5 and 1: " + (res1 != null ? res1.val : "null")); // Expects 3

        // Case 2: LCA of 6 (Node with val=6) and 4 (Node with val=4)
        TreeNode res2 = lcaFinder.lowestCommonAncestor(root.left.left, root.left.right.right);
        System.out.println("LCA of 6 and 4: " + (res2 != null ? res2.val : "null")); // Expects 5

        // Case 3: LCA of 7 (Node with val=7) and 8 (Node with val=8)
        TreeNode res3 = lcaFinder.lowestCommonAncestor(root.left.right.left, root.right.right);
        System.out.println("LCA of 7 and 8: " + (res3 != null ? res3.val : "null")); // Expects 3
    }
}
