// // Given a list of integers, return the largest product that can be made by multiplying any three integers.

// For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

// You can assume the list has at least three integers.


import java.util.Arrays;

public class _69_MaxProductOfThree {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums); // Sort the array

        int n = nums.length;

        // Two possible candidates for the maximum product:
        // 1. Product of the three largest numbers
        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // 2. Product of the two smallest and the largest number
        int product2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(product1, product2);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -10, 5, 2};
        System.out.println("Maximum product: " + maximumProduct(nums)); // Output: 500
    }
}
