class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode removeKthFromEnd(ListNode head, int k) {
        // Create a dummy node to simplify the case of removing the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer k + 1 steps ahead
        for (int i = 0; i <= k; i++) {
            fast = fast.next;
        }

        // Move both fast and slow pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Now slow is just before the node to be removed
        slow.next = slow.next.next;

        return dummy.next; // Return the new head, which might have changed
    }

    public static void main(String[] args) {
        // Create a test linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Remove the 2nd last element (k = 2), which should remove '4'
        Solution solution = new Solution();
        head = solution.removeKthFromEnd(head, 2);

        // Print the updated list: 1 -> 2 -> 3 -> 5
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
