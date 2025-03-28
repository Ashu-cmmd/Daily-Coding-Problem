import java.util.Stack;

public class _27_ {
    
    public static boolean isBalanced(String s) {
        // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it to the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // If the character is a closing bracket, check for balance
            else if (c == ')' || c == ']' || c == '}') {
                // Check if the stack is not empty and the top of the stack matches
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == ']' && top != '[') || 
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, the brackets are balanced; otherwise, they're not
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isBalanced("([])[]({})"));  // true
        System.out.println(isBalanced("([)]"));        // false
        System.out.println(isBalanced("((()"));        // false
    }
}
