// Implement a queue using two stacks. Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods: enqueue, which inserts an element into the queue, and dequeue, which removes it.

import java.util.Stack;

class QueueUsingTwoStacks {
    private Stack<Integer> stack1; // Stack for enqueue operations
    private Stack<Integer> stack2; // Stack for dequeue operations

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: Push element to stack1
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation: Pop element from stack2
    public int dequeue() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2 to reverse the order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        return stack2.pop();
    }

    // Peek operation: Get the front element of the queue
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        
        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        // Dequeue elements
        System.out.println(queue.dequeue()); // Should print 1
        System.out.println(queue.dequeue()); // Should print 2
        
        // Peek at the front element
        System.out.println(queue.peek()); // Should print 3
        
        // Dequeue the last element
        System.out.println(queue.dequeue()); // Should print 3
        
        // Check if the queue is empty
        System.out.println(queue.isEmpty()); // Should print true
    }
}
