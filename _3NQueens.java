public class _38_NQueens {

    public static int totalNQueens(int N) {
        int[] queens = new int[N];  // Array to store the position of queens in each row
        return solveNQueens(N, queens, 0);
    }

    private static int solveNQueens(int N, int[] queens, int row) {
        if (row == N) {
            return 1;  // Found a valid arrangement
        }

        int count = 0;
        for (int col = 0; col < N; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;  // Place queen in the current row and column
                count += solveNQueens(N, queens, row + 1);  // Recurse to the next row
            }
        }
        return count;
    }

    private static boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            // Check if the column or diagonals are under attack
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 8;  // Example: Solving for 8 queens
        System.out.println("Total number of ways to place " + N + " queens: " + totalNQueens(N));
    }
}
