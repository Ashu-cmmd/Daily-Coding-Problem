public class GameOfLife {
    private boolean[][] grid;
    private int rows;
    private int cols;
    private int steps;

    // Constructor to initialize the grid with the live cells and the number of steps
    public GameOfLife(boolean[][] initialGrid, int steps) {
        this.rows = initialGrid.length;
        this.cols = initialGrid[0].length;
        this.grid = new boolean[rows][cols];
        this.steps = steps;

        // Copy initial grid state
        for (int i = 0; i < rows; i++) {
            System.arraycopy(initialGrid[i], 0, this.grid[i], 0, cols);
        }
    }

    // Method to run the game
    public void runGame() {
        for (int step = 0; step < steps; step++) {
            printBoard();
            grid = getNextGeneration();
        }
    }

    // Get the next generation of cells
    private boolean[][] getNextGeneration() {
        boolean[][] nextGeneration = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);

                if (grid[i][j]) { // If the cell is alive
                    // A live cell with fewer than two live neighbors dies (underpopulation).
                    // A live cell with two or three live neighbors stays alive.
                    // A live cell with more than three live neighbors dies (overpopulation).
                    nextGeneration[i][j] = (liveNeighbors == 2 || liveNeighbors == 3);
                } else { // If the cell is dead
                    // A dead cell with exactly three live neighbors becomes alive.
                    nextGeneration[i][j] = (liveNeighbors == 3);
                }
            }
        }

        return nextGeneration;
    }

    // Count the live neighbors of a cell at (i, j)
    private int countLiveNeighbors(int i, int j) {
        int count = 0;

        // Check all eight neighbors (including diagonals)
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue; // Skip the cell itself

                int ni = i + dx;
                int nj = j + dy;

                // Ensure we don't go out of bounds
                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                    if (grid[ni][nj]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Print the board
    private void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] ? "*" : ".");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Main function to initialize and run the game
    public static void main(String[] args) {
        // Example starting configuration (Glider pattern)
        boolean[][] initialGrid = new boolean[5][5];
        initialGrid[1][0] = true;
        initialGrid[2][1] = true;
        initialGrid[0][2] = true;
        initialGrid[1][2] = true;
        initialGrid[2][2] = true;

        // Number of steps to run
        int steps = 5;

        // Initialize the game
        GameOfLife game = new GameOfLife(initialGrid, steps);
        game.runGame();
    }
}
