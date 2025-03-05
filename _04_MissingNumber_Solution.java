// Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

//For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

public class _04_MissingNumber_Solution {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Reorder the array
        for (int i = 0; i < n; i++) {
            // Keep swapping nums[i] with nums[nums[i] - 1] if it's in the valid range
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all numbers from 1 to n are in place, return n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(arr1)); // Output: 2

        int[] arr2 = {1, 2, 0};
        System.out.println(firstMissingPositive(arr2)); // Output: 3

        int[] arr3 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(arr3)); // Output: 1
    }
}
