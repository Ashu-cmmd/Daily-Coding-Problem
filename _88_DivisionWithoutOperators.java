// mplement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.

public class _88_DivisionWithoutOperators {

    public static int divide(int dividend, int divisor) {
        // Edge case: if dividend is 0, the quotient is 0
        if (dividend == 0) {
            return 0;
        }

        // Edge case: if divisor is 1, the quotient is the dividend
        if (divisor == 1) {
            return dividend;
        }

        int quotient = 0;
        int current = 1;
        int currentDivisor = divisor;

        // Find the largest multiple of divisor that fits into the dividend
        while (currentDivisor <= dividend) {
            currentDivisor <<= 1; // Multiply currentDivisor by 2
            current <<= 1; // Multiply current by 2 (this keeps track of the quotient)
        }

        // Perform the division using repeated subtraction
        while (current > 0) {
            if (dividend >= currentDivisor >> 1) {
                dividend -= currentDivisor >> 1; // Subtract the largest multiple found
                quotient += current; // Add the corresponding quotient part
            }
            current >>= 1; // Divide current by 2
            currentDivisor >>= 1; // Divide currentDivisor by 2
        }

        return quotient;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        int result = divide(dividend, divisor);
        System.out.println("Quotient of " + dividend + " / " + divisor + " = " + result); // Should print 3

        dividend = 7;
        divisor = 2;
        result = divide(dividend, divisor);
        System.out.println("Quotient of " + dividend + " / " + divisor + " = " + result); // Should print 3

        dividend = 15;
        divisor = 5;
        result = divide(dividend, divisor);
        System.out.println("Quotient of " + dividend + " / " + divisor + " = " + result); // Should print 3
    }
}
