// Given a 2D matrix of characters and a target word, write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.

// For example, given the following matrix:

// [['F', 'A', 'C', 'I'],
//  ['O', 'B', 'Q', 'P'],
//  ['A', 'N', 'O', 'B'],
//  ['M', 'A', 'S', 'S']]
// and the target word 'FOAM', you should return true, since it's the leftmost column. Similarly, given the target word 'MASS', you should return true, since it's the last row. in java

public class _62_WordSearch {

    public static boolean exists(char[][] matrix, String word) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check each row for the word (left-to-right)
        for (int i = 0; i < rows; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                row.append(matrix[i][j]);
            }
            if (row.toString().contains(word)) {
                return true;
            }
        }

        // Check each column for the word (top-to-bottom)
        for (int j = 0; j < cols; j++) {
            StringBuilder col = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                col.append(matrix[i][j]);
            }
            if (col.toString().contains(word)) {
                return true;
            }
        }

        return false;
    }

    // Test the function
    public static void main(String[] args) {
        char[][] matrix = {
            {'F', 'A', 'C', 'I'},
            {'O', 'B', 'Q', 'P'},
            {'A', 'N', 'O', 'B'},
            {'M', 'A', 'S', 'S'}
        };

        System.out.println(exists(matrix, "FOAM")); // true
        System.out.println(exists(matrix, "MASS")); // true
        System.out.println(exists(matrix, "FACE")); // false
    }
}
