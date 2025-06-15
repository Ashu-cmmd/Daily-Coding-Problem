// This problem was asked by Pinterest.

// Given an integer list where each number represents the number of hops you can make, determine whether you can reach to the last index starting at index 0.

// For example, [2, 0, 1, 0] returns True while [1, 1, 0, 1] returns False.

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxReach = 0; // The farthest index we can reach
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If we can't reach this index, return false
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Update the farthest index we can reach
            if (maxReach >= nums.length - 1) {
                return true; // If we can reach or exceed the last index, return true
            }
        }
        return false; // If we finish the loop and haven't reached the last index
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0, 1, 0};
        int[] nums2 = {1, 1, 0, 1};

        System.out.println(canJump(nums1)); // Output: true
        System.out.println(canJump(nums2)); // Output: false
    }
}
