public class _34_PalindromeInsertion {
    
    public static String makeSmallestPalindrome(String s) {
        int n = s.length();
        
        // Step 1: Find the longest palindromic subsequence using dynamic programming
        int[][] dp = new int[n][n];
        
        // Base case: all single characters are palindromes of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        // Fill the DP table
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Step 2: Reconstruct the lexicographically smallest palindrome
        StringBuilder result = new StringBuilder();
        int i = 0, j = n - 1;
        
        // Use two pointers to construct the palindrome
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                result.append(s.charAt(i));
                i++;
                j--;
            } else if (dp[i + 1][j] >= dp[i][j - 1]) {
                result.append(s.charAt(i));
                i++;
            } else {
                result.insert(0, s.charAt(j));
                j--;
            }
        }
        
        // Add the remaining part of the string to complete the palindrome
        StringBuilder reverse = new StringBuilder(result).reverse();
        if (result.length() > 0) {
            reverse.deleteCharAt(0);  // Avoid duplicating the center character
        }
        
        result.append(reverse);
        
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "race";
        System.out.println(makeSmallestPalindrome(s1));  // Output: ecarace
        
        String s2 = "google";
        System.out.println(makeSmallestPalindrome(s2));  // Output: elgoogle
    }
}
