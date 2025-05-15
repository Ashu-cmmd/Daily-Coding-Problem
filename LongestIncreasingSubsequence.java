// Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not necessarily have to be contiguous.

// For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.

import java.util.*;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        // List to store the current subsequence ends
        List<Integer> sub = new ArrayList<>();
        
        for (int num : nums) {
            int i = Collections.binarySearch(sub, num);
            if (i < 0) {
                i = -(i + 1);
            }
            if (i < sub.size()) {
                sub.set(i, num);
            } else {
                sub.add(num);
            }
        }
        
        return sub.size();
    }

    public static void main(String[] args) {
        int[] nums = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int result = lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + result);
    }
}

