// Implement a stack that has the following methods:

// push(val), which pushes an element onto the stack
// pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
// max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.

import java.util.Stack;

class _43_MaxStack {
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public _43_MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    // Push a value onto the stack
    public void push(int val) {
        stack.push(val);

        // If maxStack is empty or the value is greater than or equal to the current
        // max, push it onto maxStack
        if (maxStack.isEmpty() || val >= maxStack.peek()) {
            maxStack.push(val);
        } else {
            maxStack.push(maxStack.peek()); // Keep the current maximum
        }
    }

    // Pop the top value off the stack and return it
    public Integer pop() {
        if (stack.isEmpty()) {
            // Return null if stack is empty, or throw an exception based on the requirement
            return null; // or throw new IllegalStateException("Stack is empty");
        }

        maxStack.pop(); // Pop the max stack as well
        return stack.pop();
    }

    // Return the maximum value in the stack
    public Integer max() {
        if (maxStack.isEmpty()) {
            // Return null if maxStack is empty, or throw an exception based on the
            // requirement
            return null; // or throw new IllegalStateException("Stack is empty");
        }
        return maxStack.peek();
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        _43_MaxStack maxStack = new _43_MaxStack();

        maxStack.push(10);
        System.out.println(maxStack.max()); // Output: 10

        maxStack.push(20);
        System.out.println(maxStack.max()); // Output: 20

        maxStack.push(5);
        System.out.println(maxStack.max()); // Output: 20

        maxStack.pop();
        System.out.println(maxStack.max()); // Output: 20

        maxStack.pop();
        System.out.println(maxStack.max()); // Output: 10

        maxStack.pop();
        System.out.println(maxStack.max()); // Output: null (or throw an exception)
    }
}
