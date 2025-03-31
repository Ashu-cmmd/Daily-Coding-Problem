// You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

// Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

// For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

// Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.

public class _30_TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // No water can be trapped if there are less than 3 bars
        }

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int waterTrapped = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += Math.max(0, leftMax - height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += Math.max(0, rightMax - height[right]);
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] heights1 = {2, 1, 2};
        System.out.println(trap(heights1)); // Output: 1

        int[] heights2 = {3, 0, 1, 3, 0, 5};
        System.out.println(trap(heights2)); // Output: 8
    }
}
