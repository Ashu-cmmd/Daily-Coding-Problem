// There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the top-left corner and getting to the bottom-right corner. You can only move right or down.

// For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:

// Right, then down
// Down, then right
// Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.
import java.math.BigInteger;

public class _63_UniquePaths {

    public static BigInteger countPaths(int N, int M) {
        return factorial(N + M - 2)
                .divide(factorial(N - 1).multiply(factorial(M - 1)));
    }

    private static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPaths(2, 2)); // Output: 2
        System.out.println(countPaths(5, 5)); // Output: 70
        System.out.println(countPaths(10, 10)); // Larger example
    }
}
