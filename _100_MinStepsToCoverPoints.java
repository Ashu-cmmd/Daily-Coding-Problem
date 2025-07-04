// This problem was asked by Google.

// You are in an infinite 2D grid where you can move in any of the 8 directions:

//  (x,y) to
//     (x+1, y),
//     (x - 1, y),
//     (x, y+1),
//     (x, y-1),
//     (x-1, y-1),
//     (x+1,y+1),
//     (x-1,y+1),
//     (x+1,y-1)
// You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

// Example:

// Input: [(0, 0), (1, 1), (1, 2)]
// Output: 2
// It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).  

public class _100_MinStepsToCoverPoints {
    public static int minSteps(int[][] points) {
        int totalSteps = 0;
        for (int i = 1; i < points.length; i++) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);
            totalSteps += Math.max(dx, dy);
        }
        return totalSteps;
    }

    public static void main(String[] args) {
        int[][] points = { {0, 0}, {1, 1}, {1, 2} };
        System.out.println(minSteps(points));  // Output should be 2
    }
}

