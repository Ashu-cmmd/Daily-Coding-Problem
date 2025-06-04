// Given a number represented by a list of digits, find the next greater permutation of a number, in terms of lexicographic ordering. If there is not greater permutation possible, return the permutation with the lowest value/ordering.

// For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should return [2,1,3]. The list [3,2,1] should return [1,2,3].

// Can you perform the operation without allocating extra memory (disregarding the input memory)?

import java.util.Arrays;

public class _95_NextPermutation {
    public static void nextPermutation(int[] digits) {
        int n = digits.length;
        int i = n - 2;

        // Step 1: Find the largest index i such that digits[i] < digits[i + 1]
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the largest index j greater than i such that digits[i] < digits[j]
            int j = n - 1;
            while (digits[j] <= digits[i]) {
                j--;
            }
            // Step 3: Swap the values at indices i and j
            swap(digits, i, j);
        }

        // Step 4: Reverse the sequence from i + 1 to the end of the list
        reverse(digits, i + 1, n - 1);
    }

    private static void swap(int[] digits, int i, int j) {
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private static void reverse(int[] digits, int start, int end) {
        while (start < end) {
            swap(digits, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3};
        nextPermutation(digits1);
        System.out.println(Arrays.toString(digits1)); // Output: [1, 3, 2]

        int[] digits2 = {1, 3, 2};
        nextPermutation(digits2);
        System.out.println(Arrays.toString(digits2)); // Output: [2, 1, 3]

        int[] digits3 = {3, 2, 1};
        nextPermutation(digits3);
        System.out.println(Arrays.toString(digits3)); // Output: [1, 2, 3]
    }
}
