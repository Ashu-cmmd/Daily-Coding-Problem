// Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations. You can assume b can only be 1 or 0

public class _85_Main {
    public static void main(String[] args) {
        int x = 5; // Example value for x
        int y = 10; // Example value for y
        int b = 1; // Example value for b

        int result = select(x, y, b);
        System.out.println(result); // Output will be 5 since b is 1
    }

    public static int select(int x, int y, int b) {
        return (x & -b) | (y & (1 - b));
    }
}

