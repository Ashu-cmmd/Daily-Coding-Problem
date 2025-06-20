// This problem was asked by Google.

// Given a word W and a string S, find all starting indices in S which are anagrams of W.

// For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.

import java.util.*;

public class _111_AnagramIndices {
    public static List<Integer> findAnagramIndices(String s, String w) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < w.length()) return result;

        // Frequency maps
        int[] wFreq = new int[26];
        int[] windowFreq = new int[26];

        // Populate wFreq with frequency of characters in w
        for (char c : w.toCharArray()) {
            wFreq[c - 'a']++;
        }

        int windowSize = w.length();

        for (int i = 0; i < s.length(); i++) {
            // Add current character to window frequency
            windowFreq[s.charAt(i) - 'a']++;

            // Remove the character left outside the window
            if (i >= windowSize) {
                windowFreq[s.charAt(i - windowSize) - 'a']--;
            }

            // Compare frequency arrays
            if (Arrays.equals(windowFreq, wFreq)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    // Test the function
    public static void main(String[] args) {
        String w = "ab";
        String s = "abxaba";
        List<Integer> indices = findAnagramIndices(s, w);
        System.out.println(indices);  // Output: [0, 3, 4]
    }
}
