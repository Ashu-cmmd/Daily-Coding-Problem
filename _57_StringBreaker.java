// Given a string s and an integer k, break up the string into multiple lines such that each line has a length of k or less. You must break it up so that words don't break across lines. Each line has to have the maximum possible amount of words. If there's no way to break the text up, then return null.

// You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.

// For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.

import java.util.*;

public class _57_StringBreaker {

    public static List<String> breakString(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return null;
        }

        String[] words = s.split(" ");
        List<String> result = new ArrayList<>();
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            if (word.length() > k) {
                // If a single word is longer than k, impossible to split
                return null;
            }
            if (line.length() == 0) {
                // Start a new line
                line.append(word);
            } else if (line.length() + 1 + word.length() <= k) {
                // Add to current line with a space
                line.append(" ").append(word);
            } else {
                // Line full, add to result and start a new line
                result.add(line.toString());
                line = new StringBuilder(word);
            }
        }

        // Add the last line if it's not empty
        if (line.length() > 0) {
            result.add(line.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "the quick brown fox jumps over the lazy dog";
        int k = 10;

        List<String> lines = breakString(s, k);
        if (lines == null) {
            System.out.println("Cannot break string according to the rules.");
        } else {
            for (String line : lines) {
                System.out.println("\"" + line + "\"");
            }
        }
    }
}

