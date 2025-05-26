// Given a matrix of 1s and 0s, return the number of "islands" in the matrix. A 1 represents land and 0 represents water, so an island is a group of 1s that are neighboring whose perimeter is surrounded by water.

// For example, this matrix has 4 islands.

// 1 0 0 0 0
// 0 0 1 1 0
// 0 1 1 0 0
// 0 0 0 0 0
// 1 1 0 0 1
// 1 1 0 0 1


public class _84_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If we find a '1', we have found an island
                if (grid[i][j] == '1') {
                    count++;
                    // Use DFS to mark all connected '1's as '0's
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // Check for out of bounds and if the cell is water
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Mark the cell as visited by changing '1' to '0'
        grid[i][j] = '0';

        // Explore all 4 directions (up, down, left, right)
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }

    public static void main(String[] args) {
        _84_NumberOfIslands solution = new _84_NumberOfIslands();
        char[][] grid = {
            {'1', '0', '0', '0', '0'},
            {'0', '0', '1', '1', '0'},
            {'0', '1', '1', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'1', '1', '0', '0', '1'},
            {'1', '1', '0', '0', '1'}
        };

        int numberOfIslands = solution.numIslands(grid);
        System.out.println("Number of islands: " + numberOfIslands);
    }
}
