public class _35_SegregateRGB {

    public static void segregateRGB(char[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 'R') {
                // Swap arr[low] and arr[mid], increment both low and mid
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 'G') {
                // Just move the mid pointer ahead
                mid++;
            } else {
                // Swap arr[mid] and arr[high], decrement high
                swap(arr, mid, high);
                high--;
            }
        }
    }

    // Helper method to swap two elements in the array
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        char[] arr = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        
        segregateRGB(arr);

        // Print the result after segregation
        System.out.println(java.util.Arrays.toString(arr));
    }
}
