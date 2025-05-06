// A knight's tour is a sequence of moves by a knight on a chessboard such that all squares are visited once.

// Given N, write a function to return the number of knight's tours on an N by N chessboard
public class _64_KnightsTour {
    private static final int[] rowMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public static void main(String[] args) {
        int N = 5; // Change this value to test with different board sizes
        System.out.println("Number of knight's tours on a " + N + "x" + N + " board: " + countKnightsTours(N));
    }

    public static int countKnightsTours(int N) {
        int[][] board = new int[N][N];
        board[0][0] = 1; // Start from the top-left corner
        return countToursUtil(board, 0, 0, 1, N);
    }

    private static int countToursUtil(int[][] board, int currRow, int currCol, int moveCount, int N) {
        // If all squares are visited, return 1
        if (moveCount == N * N) {
            return 1;
        }

        int totalTours = 0;

        // Try all next moves from the current coordinate currRow, currCol
        for (int i = 0; i < 8; i++) {
            int nextRow = currRow + rowMoves[i];
            int nextCol = currCol + colMoves[i];

            // Check if the next move is within bounds and not visited
            if (isSafe(nextRow, nextCol, board, N)) {
                board[nextRow][nextCol] = moveCount + 1; // Mark the square as visited
                totalTours += countToursUtil(board, nextRow, nextCol, moveCount + 1, N);
                board[nextRow][nextCol] = 0; // Backtrack
            }
        }

        return totalTours;
    }

    private static boolean isSafe(int row, int col, int[][] board, int N) {
        return (row >= 0 && row < N && col >= 0 && col < N && board[row][col] == 0);
    }
}