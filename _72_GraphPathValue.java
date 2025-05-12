// In a directed graph, each node is assigned an uppercase letter. We define a path's value as the number of most frequently-occurring letter along that path. For example, if a path in the graph goes through "ABACA", the value of the path is 3, since there are 3 occurrences of 'A' on the path.

// Given a graph with n nodes and m directed edges, return the largest value path of the graph. If the largest value is infinite, then return null.

// The graph is represented with a string and an edge list. The i-th character represents the uppercase letter of the i-th node. Each tuple in the edge list (i, j) means there is a directed edge from the i-th node to the j-th node. Self-edges are possible, as well as multi-edges.

// For example, the following input graph:

// ABACA
// [(0, 1),
//  (0, 2),
//  (2, 3),
//  (3, 4)]
// Would have maximum value 3 using the path of vertices [0, 2, 3, 4], (A, A, C, A).

import java.util.*;

public class _72_GraphPathValue {
    private static class Result {
        int maxValue;
        boolean isInfinite;

        Result(int maxValue, boolean isInfinite) {
            this.maxValue = maxValue;
            this.isInfinite = isInfinite;
        }
    }

    public static Integer largestValuePath(String letters, List<int[]> edges) {
        int n = letters.length();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        int maxValue = 0;
        boolean infinitePath = false;

        // Visited array to track nodes in the current path
        boolean[] visited = new boolean[n];
        boolean[] inPath = new boolean[n];

        for (int i = 0; i < n; i++) {
            Result result = dfs(i, letters, graph, visited, inPath, new int[26]);
            if (result.isInfinite) {
                return null; // Infinite path found
            }
            maxValue = Math.max(maxValue, result.maxValue);
        }

        return maxValue;
    }

    private static Result dfs(int node, String letters, List<List<Integer>> graph, boolean[] visited, boolean[] inPath, int[] count) {
        if (inPath[node]) {
            return new Result(0, true); // Cycle detected
        }
        if (visited[node]) {
            return new Result(0, false); // Already processed
        }

        visited[node] = true;
        inPath[node] = true;

        // Count the current letter
        count[letters.charAt(node) - 'A']++;

        int currentMax = count[letters.charAt(node) - 'A'];
        int maxValue = currentMax;

        for (int neighbor : graph.get(node)) {
            Result result = dfs(neighbor, letters, graph, visited, inPath, count);
            if (result.isInfinite) {
                return result; // Propagate infinite path
            }
            maxValue = Math.max(maxValue, result.maxValue);
        }

        // Backtrack
        inPath[node] = false;
        count[letters.charAt(node) - 'A']--;

        return new Result(maxValue, false);
    }

    public static void main(String[] args) {
        String letters = "ABACA";
        List<int[]> edges = Arrays.asList(new int[][]{
            {0, 1},
            {0, 2},
            {2, 3},
            {3, 4}
        });

        Integer result = largestValuePath(letters, edges);
        System.out.println(result); // Output: 3
    }
}
