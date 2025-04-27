// Given an undirected graph represented as an adjacency matrix and an integer k, write a function to determine whether each vertex in the graph can be colored such that no two adjacent vertices share the same color using at most k colors.


public class _56_GraphColoring {

    // Function to check if the current color assignment is valid
    public static boolean isSafe(int v, int[] color, int[][] graph, int c) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && color[i] == c) { // If there's an edge and the neighbor has the same color
                return false;
            }
        }
        return true;
    }

    // Backtracking function to try to assign colors to vertices
    public static boolean graphColoringUtil(int[][] graph, int m, int[] color, int v) {
        // If all vertices are assigned a color then return true
        if (v == graph.length) {
            return true;
        }

        // Try different colors for vertex v
        for (int c = 1; c <= m; c++) {
            // Check if it's safe to color vertex v with color c
            if (isSafe(v, color, graph, c)) {
                color[v] = c;  // Assign color c to vertex v

                // Recur to assign colors to the remaining vertices
                if (graphColoringUtil(graph, m, color, v + 1)) {
                    return true;
                }

                // If assigning color c doesn't lead to a solution, backtrack
                color[v] = 0;
            }
        }

        // If no color can be assigned to this vertex, return false
        return false;
    }

    // Function to solve the m-coloring problem
    public static boolean graphColoring(int[][] graph, int m) {
        int[] color = new int[graph.length];  // Array to store color assignments for each vertex
        // Initialize color array with 0 (no color assigned)
        for (int i = 0; i < graph.length; i++) {
            color[i] = 0;
        }

        // Call the recursive function to solve the problem
        return graphColoringUtil(graph, m, color, 0);
    }

    // Main function to test the graph coloring
    public static void main(String[] args) {
        // Example graph as an adjacency matrix
        // 0 -- 1 -- 2
        // |    |
        // 3 -- 4

        int[][] graph = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };

        int k = 3; // Number of colors

        if (graphColoring(graph, k)) {
            System.out.println("Solution exists with " + k + " colors.");
        } else {
            System.out.println("Solution does not exist with " + k + " colors.");
        }
    }
}

