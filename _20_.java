// Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

// For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

// In this example, assume nodes with the same value are the exact same node objects.

// Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class _20_ {
    // Method to find the intersection node
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Step 1: Calculate the lengths of both linked lists
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        // Step 2: Align the two lists by moving the pointer of the longer list forward by the difference in lengths
        ListNode currA = headA;
        ListNode currB = headB;
        
        if (lenA > lenB) {
            // Move the pointer of A forward by the difference in lengths
            for (int i = 0; i < lenA - lenB; i++) {
                currA = currA.next;
            }
        } else {
            // Move the pointer of B forward by the difference in lengths
            for (int i = 0; i < lenB - lenA; i++) {
                currB = currB.next;
            }
        }

        // Step 3: Traverse both lists simultaneously until we find the intersection node
        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA; // Found the intersection node
            }
            currA = currA.next;
            currB = currB.next;
        }

        // No intersection
        return null;
    }

    // Helper method to calculate the length of a linked list
    private int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}

