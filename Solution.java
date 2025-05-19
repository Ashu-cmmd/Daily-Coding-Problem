// Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.

// For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.

// Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.


public class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0; // To count how many violations occur
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                // If more than one violation is found, return false
                if (count > 0) {
                    return false;
                }
                count++;
                
                // Check if modifying nums[i - 1] or nums[i] can fix the violation
                if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
                    // If modifying nums[i - 1] doesn't work, modify nums[i]
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {10, 5, 7};
        System.out.println(solution.checkPossibility(nums1)); // Output: true
        
        // Test case 2
        int[] nums2 = {10, 5, 1};
        System.out.println(solution.checkPossibility(nums2)); // Output: false
    }
}
