// On our special chessboard, two bishops attack each other if they share the same diagonal. This includes bishops that have another bishop located between them, i.e. bishops can attack through pieces.

// You are given N bishops, represented as (row, column) tuples on a M by M chessboard. Write a function to count the number of pairs of bishops that attack each other. The ordering of the pair doesn't matter: (1, 2) is considered the same as (2, 1).

// For example, given M = 5 and the list of bishops:

// (0, 0)
// (1, 2)
// (2, 2)
// (4, 0)
// The board would look like this:

// [b 0 0 0 0]
// [0 0 b 0 0]
// [0 0 b 0 0]
// [0 0 0 0 0]
// [b 0 0 0 0]
// You should return 2, since bishops 1 and 3 attack each other, as well as bishops 3 and 4.



import java.util.*;

public class _68_BishopAttackPairs {
    public static int countAttackingPairs(int M, int[][] bishops) {
        Map<Integer, Integer> diag1 = new HashMap<>(); // row + col
        Map<Integer, Integer> diag2 = new HashMap<>(); // row - col

        for (int[] bishop : bishops) {
            int row = bishop[0];
            int col = bishop[1];

            diag1.put(row + col, diag1.getOrDefault(row + col, 0) + 1);
            diag2.put(row - col, diag2.getOrDefault(row - col, 0) + 1);
        }

        int count = 0;
        for (int val : diag1.values()) {
            count += val * (val - 1) / 2;
        }
        for (int val : diag2.values()) {
            count += val * (val - 1) / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        int M = 5;
        int[][] bishops = {
            {0, 0},
            {1, 2},
            {2, 2},
            {4, 0}
        };

        System.out.println("Number of attacking bishop pairs: " + countAttackingPairs(M, bishops));
        // Output: 2
    }
}
