// This problem was asked by Coursera.

// Given a 2D board of characters and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// For example, given the following board:

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// exists(board, "ABCCED") returns true, exists(board, "SEE") returns true, exists(board, "ABCB") returns false.

public class _98_WordSearch {
    private char[][] board;
    private String word;
    private boolean[][] visited;
    private int rows;
    private int cols;

    public boolean exists(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int index) {
        // Check if we have found the word
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and if the cell is already visited or does not match the current character
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited
        visited[row][col] = true;

        // Explore all possible directions: up, down, left, right
        boolean found = dfs(row + 1, col, index + 1) || 
                        dfs(row - 1, col, index + 1) || 
                        dfs(row, col + 1, index + 1) || 
                        dfs(row, col - 1, index + 1);

        // Backtrack: unmark the cell as visited
        visited[row][col] = false;

        return found;
    }

    public static void main(String[] args) {
        _98_WordSearch ws = new _98_WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        System.out.println(ws.exists(board, "ABCCED")); // returns true
        System.out.println(ws.exists(board, "SEE"));    // returns true
        System.out.println(ws.exists(board, "ABCB"));   // returns false
    }
}
