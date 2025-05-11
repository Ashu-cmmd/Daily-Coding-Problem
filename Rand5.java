// Using a function rand7() that returns an integer from 1 to 7 (inclusive) with uniform probability, implement a function rand5() that returns an integer from 1 to 5 (inclusive).


import java.util.Random;

public class Rand5 {

    // This is a helper function that simulates rand7()
    public static int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;  // generates a random number between 1 and 7
    }

    // rand5 function that maps rand7 to rand5 using rejection sampling
    public static int rand5() {
        int result;
        
        // Repeat until we get a result from 1 to 5
        while (true) {
            result = rand7();  // Get a random number between 1 and 7
            
            if (result <= 5) {  // If it's between 1 and 5, return the result
                return result;
            }
            // Otherwise, we discard the result and try again (rejection sampling)
        }
    }

    public static void main(String[] args) {
        // Test the rand5 function
        for (int i = 0; i < 10; i++) {
            System.out.println(rand5());  // Print a random number between 1 and 5
        }
    }
}
