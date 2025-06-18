// This problem was asked by Google.

// Given two strings A and B, return whether or not A can be shifted some number of times to get B.

// For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.

public class _108_StringShift {
    public static boolean canShift(String A, String B) {
        // Check if the lengths of A and B are the same
        if (A.length() != B.length()) {
            return false;
        }
        
        // Concatenate A with itself
        String concatenatedA = A + A;
        
        // Check if B is a substring of the concatenated string
        return concatenatedA.contains(B);
    }

    public static void main(String[] args) {
        String A = "abcde";
        String B = "cdeab";
        
        boolean result = canShift(A, B);
        System.out.println(result); // Output: true

        A = "abc";
        B = "acb";
        
        result = canShift(A, B);
        System.out.println(result); // Output: false
    }
}
