// This problem was asked by Google.

// Determine whether a doubly linked list is a palindrome. What if it’s singly linked?

// For example, 1 -> 4 -> 3 -> 4 -> 1 returns True while 1 -> 4 returns False.

import java.util.Stack;

class _104_SinglyNode {
    int data;
    _104_SinglyNode next;

    _104_SinglyNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    _104_SinglyNode head;

    // Method to check if the list is a palindrome
    public boolean isPalindrome() {
        if (head == null) return true; // An empty list is a palindrome

        Stack<Integer> stack = new Stack<>();
        _104_SinglyNode current = head;

        // Push the first half of the list onto the stack
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        current = head;

        // Compare the stack with the second half of the list
        while (current != null) {
            if (current.data != stack.pop()) {
                return false; // Not a palindrome
            }
            current = current.next;
        }
        return true; // It's a palindrome
    }
}
