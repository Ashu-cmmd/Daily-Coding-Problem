import java.util.*;

public class _60_PartitionSubsetSum {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If the sum is odd, it cannot be split into two equal parts
        if (sum % 2 != 0) {
            return false;
        }

        // We want to find a subset whose sum is sum / 2
        int target = sum / 2;

        // DP array to store whether a sum is achievable
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // A sum of 0 is always achievable (by selecting no elements)

        for (int num : nums) {
            // Traverse backwards to avoid overwriting results of the same iteration
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        // If dp[target] is true, it means we can partition the set into two subsets
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums1 = {15, 5, 20, 10, 35, 15, 10};
        System.out.println(canPartition(nums1)); // Output: true

        int[] nums2 = {15, 5, 20, 10, 35};
        System.out.println(canPartition(nums2)); // Output: false
    }
}
