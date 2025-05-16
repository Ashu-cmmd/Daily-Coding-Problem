// You are given an N by M 2D matrix of lowercase letters. Determine the minimum number of columns that can be removed to ensure that each row is ordered from top to bottom lexicographically. That is, the letter at each column is lexicographically later as you go down each row. It does not matter whether each row itself is ordered lexicographically.

// For example, given the following table:

// cba
// daf
// ghi

public class LexColumnDeletion {
    public static int minDeletionSize(String[] strs) {
        int numCols = strs[0].length();
        int numRows = strs.length;
        int count = 0;

        for (int col = 0; col < numCols; col++) {
            for (int row = 1; row < numRows; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    count++;
                    break; // No need to check further rows for this column
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] matrix = {"cba", "daf", "ghi"};
        System.out.println(minDeletionSize(matrix)); // Output: 1
    }
}

