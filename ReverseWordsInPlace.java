// This problem was asked by Google.

// Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here", return "here world hello"

// Follow-up: given a mutable string representation, can you perform this operation in-place?

public class ReverseWordsInPlace {
    public static void reverseWords(char[] s) {
        // Step 1: Reverse the entire array
        reverse(s, 0, s.length - 1);
        
        // Step 2: Reverse each word in the reversed array
        int start = 0;
        for (int end = 0; end < s.length; end++) {
            if (s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }
        // Reverse the last word
        reverse(s, start, s.length - 1);
    }

    private static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] input = "hello world here".toCharArray();
        reverseWords(input);
        System.out.println(new String(input)); // Output: "here world hello"
    }
}
