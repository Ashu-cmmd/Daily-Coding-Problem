import java.util.Random;
import java.util.stream.Stream;

public class _15_ReservoirSampling {

    // Function to select a random element from a stream using Algorithm R
    public static <T> T getRandomElement(Stream<T> stream) {
        // Initialize random number generator
        Random rand = new Random();
        
        // Initialize the reservoir
        T reservoir = null;
        
        // Initialize a counter for the index
        int index = 0;
        
        // Process each element in the stream
        // We use the forEachOrdered to ensure we handle the stream elements sequentially
        for (T element : (Iterable<T>) stream::iterator) {
            // If it's the first element, store it in the reservoir
            if (index == 0) {
                reservoir = element;
            } else {
                // For subsequent elements, pick with probability 1/(index + 1)
                if (rand.nextInt(index + 1) == 0) {
                    reservoir = element;
                }
            }
            // Increment the index counter
            index++;
        }
        
        // Return the randomly selected element
        return reservoir;
    }

    public static void main(String[] args) {
        // Example usage: Stream of numbers from 1 to 100
        Stream<Integer> stream = Stream.iterate(1, i -> i + 1).limit(100);
        
        // Get a random element from the stream
        Integer randomElement = getRandomElement(stream);
        
        // Output the random element
        System.out.println("Random element from the stream: " + randomElement);
    }
}
