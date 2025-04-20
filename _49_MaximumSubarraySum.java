// Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

// For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

// Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

// Do this in O(N) time.

public class _49_MaximumSubarraySum {
    
    // Function to find the maximum sum of a contiguous subarray
    public static int maxSubArraySum(int[] arr) {
        // Edge case: empty array
        if (arr.length == 0) {
            return 0;
        }
        
        // Initialize the variables
        int currentSum = 0;
        int maxSum = 0; // Start with 0 to account for subarrays that may have no elements (i.e., empty subarray)
        
        // Iterate through the array
        for (int num : arr) {
            currentSum = Math.max(currentSum + num, num); // Choose the max of (currentSum + num) or (num)
            maxSum = Math.max(maxSum, currentSum); // Keep track of the maximum sum
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        // Example 1: [34, -50, 42, 14, -5, 86]
        int[] arr1 = {34, -50, 42, 14, -5, 86};
        System.out.println("Maximum sum for arr1: " + maxSubArraySum(arr1)); // Output: 137
        
        // Example 2: [-5, -1, -8, -9]
        int[] arr2 = {-5, -1, -8, -9};
        System.out.println("Maximum sum for arr2: " + maxSubArraySum(arr2)); // Output: 0
    }
}
