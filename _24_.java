// Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

// Design a binary tree node class with the following methods:

// is_locked, which returns whether the node is locked
// lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
// unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
// You may augment the node to add parent pointers or any other property you would like. You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.

class BinaryTreeNode {
    int value;
    BinaryTreeNode left, right, parent;
    boolean locked;
    int lockedDescendants;  // Count of locked descendants to avoid recalculating it repeatedly

    // Constructor to initialize the node
    public BinaryTreeNode(int value) {
        this.value = value;
        this.left = this.right = this.parent = null;
        this.locked = false;
        this.lockedDescendants = 0;
    }

    // Check if the node is locked
    public boolean isLocked() {
        return this.locked;
    }

    // Lock the node if possible
    public boolean lock() {
        if (this.locked) {
            return false; // Already locked
        }

        // Check if any ancestors are locked
        BinaryTreeNode current = this.parent;
        while (current != null) {
            if (current.locked) {
                return false; // An ancestor is locked
            }
            current = current.parent;
        }

        // Check if any descendants are locked
        if (this.lockedDescendants > 0) {
            return false; // A descendant is locked
        }

        // Lock the node
        this.locked = true;

        // Update lockedDescendants for parent node
        current = this.parent;
        while (current != null) {
            current.lockedDescendants++;
            current = current.parent;
        }

        return true;
    }

    // Unlock the node if possible
    public boolean unlock() {
        if (!this.locked) {
            return false; // Already unlocked
        }

        // Check if any ancestors are locked
        BinaryTreeNode current = this.parent;
        while (current != null) {
            if (current.locked) {
                return false; // An ancestor is locked
            }
            current = current.parent;
        }

        // Unlock the node
        this.locked = false;

        // Update lockedDescendants for parent node
        current = this.parent;
        while (current != null) {
            current.lockedDescendants--;
            current = current.parent;
        }

        return true;
    }
}

class BinaryTree {
    BinaryTreeNode root;

    public BinaryTree(int rootValue) {
        this.root = new BinaryTreeNode(rootValue);
    }

    // Helper methods to add left and right children for convenience
    public void addLeftChild(BinaryTreeNode parent, int value) {
        BinaryTreeNode child = new BinaryTreeNode(value);
        parent.left = child;
        child.parent = parent;
    }

    public void addRightChild(BinaryTreeNode parent, int value) {
        BinaryTreeNode child = new BinaryTreeNode(value);
        parent.right = child;
        child.parent = parent;
    }
}

public class _24_ {
    public static void main(String[] args) {
        // Example usage
        BinaryTree tree = new BinaryTree(1);
        BinaryTreeNode node2 = tree.root;
        tree.addLeftChild(node2, 2);
        tree.addRightChild(node2, 3);
        BinaryTreeNode node4 = node2.left;
        BinaryTreeNode node5 = node2.right;

        // Test locking and unlocking
        System.out.println(node4.lock()); // true (node 4 can be locked)
        System.out.println(node5.lock()); // false (node 5 cannot be locked, as node 4 is locked)
        System.out.println(node4.unlock()); // true (node 4 is unlocked)
        System.out.println(node5.lock()); // true (node 5 can now be locked)
    }
}

