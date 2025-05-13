// Given the head of a singly linked list, reverse it in-place.

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class _73_Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next; // Store the next node
            current.next = prev;               // Reverse the current node's pointer
            prev = current;                    // Move prev and current one step forward
            current = nextTemp;
        }
        
        return prev; // prev will be the new head of the reversed list
    }
}
