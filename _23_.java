import java.util.*;

class _23_ {
public Integer minStepsToReachEnd(boolean[][] board, int[] start, int[] end) {
        // Get the number of rows and columns
        int M = board.length;
        int N = board[0].length;
        
        // Directions for up, down, left, right movements
        int[] dirs = {-1, 0, 1, 0, -1, 0}; // [dx1, dy1, dx2, dy2, dx3, dy3, dx4, dy4]
        
        // Create a queue for BFS and add the starting point with step count 0
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 0}); // {x, y, steps}
        
        // Set to track visited positions
        boolean[][] visited = new boolean[M][N];
        visited[start[0]][start[1]] = true;
        
        // BFS loop
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];
            
            // If we've reached the end, return the number of steps
            if (x == end[0] && y == end[1]) {
                return steps;
            }
            
            // Explore the four possible directions
            for (int i = 0; i < 4; i++) {
                int newX = x + dirs[i];
                int newY = y + dirs[i + 1];
                
                // Check if the new position is within bounds, not a wall, and not visited
                if (newX >= 0 && newX < M && newY >= 0 && newY < N && !board[newX][newY] && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[] {newX, newY, steps + 1});
                }
            }
        }
        
        // If the queue is exhausted and we haven't reached the end, return null
        return null;
    }

    public static void main(String[] args) {
        _23_ _23_ = new _23_();
        
        // Example board where True is a wall and False is a walkable tile
        boolean[][] board = {
            {false, true, false, false},
            {false, true, false, true},
            {false, false, false, true},
            {true, true, false, false}
        };
        
        int[] start = {0, 0}; // Start coordinate
        int[] end = {3, 3};   // End coordinate
        
        Integer result = _23_.minStepsToReachEnd(board, start, end);
        if (result != null) {
            System.out.println("Minimum steps: " + result);
        } else {
            System.out.println("No path exists.");
        }
    }
}
