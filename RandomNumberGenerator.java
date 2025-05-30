// Given an integer n and a list of integers l, write a function that randomly generates a number from 0 to n-1 that isn't in l (uniform).

import java.util.*;

public class RandomNumberGenerator {
    private int n;
    private Set<Integer> excludedNumbers;
    private Random random;

    // Constructor to initialize the generator
    public RandomNumberGenerator(int n, List<Integer> l) {
        this.n = n;
        this.excludedNumbers = new HashSet<>(l); // Create a set for quick lookup
        this.random = new Random();
    }

    // Method to generate a random number not in the excluded list
    public Integer generate() {
        if (excludedNumbers.size() >= n) {
            throw new IllegalArgumentException("No valid numbers available to generate.");
        }

        int randomNumber;
        do {
            randomNumber = random.nextInt(n); // Generate a random number from 0 to n-1
        } while (excludedNumbers.contains(randomNumber)); // Repeat if the number is in the excluded list

        return randomNumber; // Return the valid random number
    }

    public static void main(String[] args) {
        List<Integer> excludedList = Arrays.asList(1, 2, 3);
        RandomNumberGenerator rng = new RandomNumberGenerator(10, excludedList);

        // Generate and print a random number not in the excluded list
        System.out.println("Random number not in the excluded list: " + rng.generate());
    }
}
