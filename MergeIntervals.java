// Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.

// The input list is not necessarily ordered in any way.

// For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].



import java.util.*;

public class MergeIntervals {

    public static List<int[]> mergeIntervals(List<int[]> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>();
        }

        // Sort intervals by the start time
        intervals.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            int[] next = intervals.get(i);

            if (current[1] >= next[0]) { // Overlap
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }

        merged.add(current); // Add the last interval
        return merged;
    }

    public static void main(String[] args) {
        List<int[]> intervals = Arrays.asList(
            new int[]{1, 3},
            new int[]{5, 8},
            new int[]{4, 10},
            new int[]{20, 25}
        );

        List<int[]> merged = mergeIntervals(intervals);

        for (int[] interval : merged) {
            System.out.println("(" + interval[0] + ", " + interval[1] + ")");
        }
    }
}
