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
