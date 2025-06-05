// This problem was asked by Microsoft.

// Given a number in the form of a list of digits, return all possible permutations.

// For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

import java.util.ArrayList;
import java.util.List;

public class _96_Permutations {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        List<List<Integer>> result = permute(digits);
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue; // Skip used elements
                used[i] = true; // Mark the element as used
                tempList.add(nums[i]); // Add the element to the current permutation
                backtrack(result, tempList, nums, used); // Recurse
                tempList.remove(tempList.size() - 1); // Remove the last element for backtracking
                used[i] = false; // Mark the element as unused for the next iteration
            }
        }
    }
}
