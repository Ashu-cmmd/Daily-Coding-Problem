// Assume you have access to a function toss_biased() which returns 0 or 1 with a probability that's not 50-50 (but also not 0-100 or 100-0). You do not know the bias of the coin.

// Write a function to simulate an unbiased coin toss.
import java.util.Random;

public class _66_UnbiasedCoinToss {
    // Simulating a biased coin toss
    public static int toss_biased() {
        // This is just a placeholder for the actual biased coin toss function.
        // Replace this with the actual implementation.
        Random rand = new Random();
        return rand.nextInt(100) < 70 ? 0 : 1; // Example: 70% chance of 0, 30% chance of 1
    }

    public static int toss_unbiased() {
        while (true) {
            int firstToss = toss_biased();
            int secondToss = toss_biased();

            if (firstToss == 0 && secondToss == 1) {
                return 0; // Return 0 for the unbiased coin
            } else if (firstToss == 1 && secondToss == 0) {
                return 1; // Return 1 for the unbiased coin
            }
            // If both tosses are the same, we repeat the process
        }
    }

    public static void main(String[] args) {
        // Simulate 10 unbiased coin tosses
        for (int i = 0; i < 10; i++) {
            System.out.println(toss_unbiased());
        }
    }
}
