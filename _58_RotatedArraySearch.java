// n sorted array of integers was rotated an unknown number of times.

// Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.

// For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

// You can assume all the integers in the array are unique.


public class _58_RotatedArraySearch {

    public static Integer search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if the target is at the mid index
            if (arr[mid] == target) {
                return mid;
            }
            
            // Determine which part is sorted
            if (arr[left] <= arr[mid]) {  // Left half is sorted
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;  // Target is in the left half
                } else {
                    left = mid + 1;   // Target is in the right half
                }
            } else {  // Right half is sorted
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;  // Target is in the right half
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }
        
        // If the target is not found
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {13, 18, 25, 2, 8, 10};
        int target = 8;
        Integer result = search(arr, target);
        
        if (result != null) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
