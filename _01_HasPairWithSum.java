// Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
import java.util.HashSet;

public class _01_HasPairWithSum {
    public static boolean hasPairWithSum(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = k - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 15, 3, 7 };
        int k = 17;

        System.out.println(hasPairWithSum(nums, k));

    }
}