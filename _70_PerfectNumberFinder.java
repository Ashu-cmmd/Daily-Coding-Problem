// A number is considered perfect if its digits sum up to exactly 10.

// Given a positive integer n, return the n-th perfect number.

// For example, given 1, you should return 19. Given 2, you should return 28.

public class _70_PerfectNumberFinder {

    // Helper method to calculate the sum of digits
    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Method to find the nth perfect number
    public static int findNthPerfectNumber(int n) {
        int count = 0;
        int current = 19; // 19 is the first perfect number

        while (true) {
            if (digitSum(current) == 10) {
                count++;
                if (count == n) {
                    return current;
                }
            }
            current++;
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int n = 1; // change this value to test other cases
        System.out.println("The " + n + "-th perfect number is: " + findNthPerfectNumber(n));
    }
}
