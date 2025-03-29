// There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

// For example, if N is 4, then there are 5 unique ways:

// 1, 1, 1, 1
// 2, 1, 1
// 1, 2, 1
// 1, 1, 2
// 2, 2
// What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
import java.util.Set;

public class _12_ {

    // Solution for climbing stairs with 1 or 2 steps at a time
    public static int climbStairs(int N) {
        if (N == 0) {
            return 1;
        } else if (N == 1) {
            return 1;
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

    // Solution for climbing stairs with a set of steps (X)
    public static int climbStairsWithSet(int N, Set<Integer> X) {
        int[] dp = new int[N + 1];
        dp[0] = 1; // There is one way to stay at the ground (doing nothing)

        for (int i = 1; i <= N; i++) {
            for (int step : X) {
                if (i - step >= 0) {
                    dp[i] += dp[i - step];
                }
            }
        }

        return dp[N];
    }

    public static void main(String[] args) {
        // Test the solution with 1 or 2 steps at a time
        int N1 = 4;
        System.out.println("Ways to climb " + N1 + " steps with 1 or 2 steps: " + climbStairs(N1));

        // Test the solution with a set of steps (X = {1, 3, 5})
        int N2 = 4;
        Set<Integer> X = Set.of(1, 3, 5); // Steps allowed
        System.out.println("Ways to climb " + N2 + " steps with set X: " + climbStairsWithSet(N2, X));
    }
}
