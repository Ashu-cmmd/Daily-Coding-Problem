// Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.

// For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".

public class _46_LongestPalindromicSubstring {
    
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String longest = "";
        
        // Helper function to expand around the center
        for (int i = 0; i < s.length(); i++) {
            // Expand around a single character (odd-length palindrome)
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            
            // Expand around two characters (even-length palindrome)
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }
        
        return longest;
    }
    
    // Helper function to expand around center
    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        // Return the palindrome substring
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String s1 = "aabcdcb";
        String s2 = "bananas";
        
        System.out.println("Longest palindrome in 'aabcdcb': " + longestPalindrome(s1));
        System.out.println("Longest palindrome in 'bananas': " + longestPalindrome(s2));
    }
}

