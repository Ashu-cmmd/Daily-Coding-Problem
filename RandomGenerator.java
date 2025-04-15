// Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, implement a function rand7() that returns an integer from 1 to 7 (inclusive).

public class RandomGenerator {

    // rand5() simulates the random number generator from 1 to 5
    public static int rand5() {
        return (int) (Math.random() * 5) + 1;
    }

    // rand7() uses rand5() to generate a random number between 1 and 7
    public static int rand7() {
        int row = rand5();
        int col = rand5();
        
        // This gives a uniform distribution of 25 outcomes (5 * 5)
        int result = (row - 1) * 5 + col; // Result between 1 and 25
        
        // Reject results greater than 21 to make it evenly distributable to [1, 7]
        if (result <= 21) {
            return 1 + (result - 1) % 7; // Map the result to 1..7
        } else {
            return rand7(); // Retry if the result is outside the range
        }
    }

    public static void main(String[] args) {
        // Test the rand7() function
        for (int i = 0; i < 10; i++) {
            System.out.println(rand7());
        }
    }
}
