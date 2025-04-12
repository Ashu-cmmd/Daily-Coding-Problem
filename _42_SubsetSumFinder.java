// Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

// Integers can appear more than once in the list. You may assume all numbers in the list are positive.

// For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
import java.util.*;

public class _42_SubsetSumFinder {

    public static List<Integer> subsetSum(List<Integer> S, int k) {
        return helper(S, k, 0, new ArrayList<>(), 0);
    }

    private static List<Integer> helper(List<Integer> S, int k, int index, List<Integer> currentSubset, int currentSum) {
        // Base case: found a subset
        if (currentSum == k) {
            return new ArrayList<>(currentSubset);
        }
        // Base case: no more elements or exceeded sum
        if (index >= S.size() || currentSum > k) {
            return null;
        }

        // Include S[index]
        currentSubset.add(S.get(index));
        List<Integer> withCurrent = helper(S, k, index + 1, currentSubset, currentSum + S.get(index));
        if (withCurrent != null) {
            return withCurrent;
        }

        // Backtrack and try without S[index]
        currentSubset.remove(currentSubset.size() - 1);
        return helper(S, k, index + 1, currentSubset, currentSum);
    }

    public static void main(String[] args) {
        List<Integer> S = Arrays.asList(12, 1, 61, 5, 9, 2);
        int k = 24;
        List<Integer> result = subsetSum(S, k);

        if (result != null) {
            System.out.println("Subset that adds up to " + k + ": " + result);
        } else {
            System.out.println("No subset found that adds up to " + k);
        }
    }
}
