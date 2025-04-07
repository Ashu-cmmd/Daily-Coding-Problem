// A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

// Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.

public class _19_PaintHouses {

    public static int minCost(int[][] cost) {
        if (cost == null || cost.length == 0 || cost[0].length == 0) {
            return 0;
        }
        
        int N = cost.length;  // Number of houses
        int K = cost[0].length;  // Number of colors

        // dp array to store the minimum cost for painting each house with each color
        int[][] dp = new int[N][K];

        // Initialize the first house's dp with its respective cost values
        for (int j = 0; j < K; j++) {
            dp[0][j] = cost[0][j];
        }

        // Fill the dp table for the rest of the houses
        for (int i = 1; i < N; i++) {
            // Find the two minimum costs from the previous row
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int min1Index = -1;

            // Find the minimum and second minimum values in the previous row
            for (int j = 0; j < K; j++) {
                if (dp[i-1][j] < min1) {
                    min2 = min1;
                    min1 = dp[i-1][j];
                    min1Index = j;
                } else if (dp[i-1][j] < min2) {
                    min2 = dp[i-1][j];
                }
            }

            // Calculate dp for the current house
            for (int j = 0; j < K; j++) {
                if (j != min1Index) {
                    dp[i][j] = cost[i][j] + min1;
                } else {
                    dp[i][j] = cost[i][j] + min2;
                }
            }
        }

        // The answer is the minimum cost to paint the last house with any color
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < K; j++) {
            result = Math.min(result, dp[N-1][j]);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example matrix where cost[i][j] is the cost to paint house i with color j
        int[][] cost = {
            {1, 5, 3},
            {2, 9, 4},
            {3, 2, 6}
        };

        int result = minCost(cost);
        System.out.println("The minimum cost to paint all houses is: " + result);
    }
}
