// Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to make the string valid (i.e. each open parenthesis is eventually closed).

// For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2, since we must remove all of them.

public class _86_ParenthesesValidator {
    public static int minRemoveToMakeValid(String s) {
        int openCount = 0;
        int closeCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    closeCount++;
                }
            }
        }

        // The total removals needed is the sum of unmatched opening and closing parentheses
        return openCount + closeCount;
    }

    public static void main(String[] args) {
        String test1 = "()())()";
        System.out.println(minRemoveToMakeValid(test1)); // Output: 1

        String test2 = ")(";
        System.out.println(minRemoveToMakeValid(test2)); // Output: 2
    }
}
