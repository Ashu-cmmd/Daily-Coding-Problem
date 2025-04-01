public class EditDistance {

    // Function to calculate the edit distance
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a 2D matrix to store the results of subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the matrix
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // If first string is empty, the only option is to insert all characters of second string
                } else if (j == 0) {
                    dp[i][j] = i; // If second string is empty, the only option is to remove all characters of first string
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // If characters are the same, no operation is needed
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    // Take the minimum of: 
                    // 1. Delete a character from word1, 
                    // 2. Insert a character into word1, 
                    // 3. Replace a character in word1.
                }
            }
        }

        // The result is in the bottom-right corner of the matrix
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "kitten";
        String word2 = "sitting";
        
        System.out.println("Edit Distance: " + minDistance(word1, word2));
    }
}
