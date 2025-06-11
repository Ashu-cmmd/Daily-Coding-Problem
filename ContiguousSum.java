//This problem was asked by Lyft.

// Given a list of integers and a number K, return which contiguous elements of the list sum to K.

// For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4], since 2 + 3 + 4 = 9.

import java.util.ArrayList;
import java.util.List;

public class ContiguousSum {
    public static List<Integer> findContiguousSum(int[] nums, int K) {
        List<Integer> result = new ArrayList<>();
        int start = 0, sum = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            // Shrink the window as long as the sum is greater than K
            while (sum > K && start <= end) {
                sum -= nums[start];
                start++;
            }

            // Check if we found a contiguous subarray that sums to K
            if (sum == K) {
                for (int i = start; i <= end; i++) {
                    result.add(nums[i]);
                }
                return result; // Return the first found subarray
            }
        }

        return result; // Return an empty list if no subarray is found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int K = 9;
        List<Integer> result = findContiguousSum(nums, K);
        System.out.println(result); // Output: [2, 3, 4]
    }
}
