public class _61_Power {

    public static int pow(int x, int y) {
        if (y < 0) {
            throw new IllegalArgumentException("Negative exponents not supported for integers.");
        }
        int result = 1;
        while (y > 0) {
            if ((y & 1) == 1) { // if y is odd
                result *= x;
            }
            x *= x;
            y >>= 1; // divide y by 2
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 10)); // Output: 1024
        System.out.println(pow(3, 5));  // Output: 243
    }
}
