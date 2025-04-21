import java.util.Arrays;

public class CardShuffler {

    // Assume this is your perfectly random number generator
    // It returns a random number between 1 and k (inclusive)
    public static int randInt(int k) {
        return (int)(Math.random() * k) + 1;
    }

    // Function to shuffle the deck using Fisher-Yates algorithm
    public static void shuffle(int[] deck) {
        int n = deck.length;

        for (int i = n - 1; i > 0; i--) {
            // randInt(i + 1) gives a number between 1 and i+1
            // We subtract 1 to make it zero-based
            int j = randInt(i + 1) - 1;

            // Swap deck[i] with deck[j]
            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] deck = new int[52];
        for (int i = 0; i < 52; i++) {
            deck[i] = i + 1; // Cards represented as 1 to 52
        }

        shuffle(deck);

        System.out.println("Shuffled deck: " + Arrays.toString(deck));
    }
}
