// This problem was asked by Square.

// Given a string and a set of characters, return the shortest substring containing all the characters in the set.

// For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".

// If there is no substring containing all the characters in the set, return null.

import java.util.HashMap;
import java.util.HashSet;

public class _103_ShortestSubstring {
    public static String shortestSubstring(String s, HashSet<Character> chars) {
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        String result = null;
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count the number of unique characters in the set
        int required = chars.size();
        int formed = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

            // Check if the current character is part of the set and if we have enough of it
            if (chars.contains(c) && charCount.get(c).intValue() == 1) {
                formed++;
            }

            // Try to contract the window until it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the result if this window is smaller than the previous one
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                // Remove the leftmost character from the window
                charCount.put(c, charCount.get(c) - 1);
                if (chars.contains(c) && charCount.get(c).intValue() == 0) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "figehaeci";
        HashSet<Character> chars = new HashSet<>();
        chars.add('a');
        chars.add('e');
        chars.add('i');

        String result = shortestSubstring(s, chars);
        System.out.println(result); // Output: "aeci"
    }
}

