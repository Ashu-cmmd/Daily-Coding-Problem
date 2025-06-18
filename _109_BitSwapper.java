//This problem was asked by Cisco.

// Given an unsigned 8-bit integer, swap its even and odd bits. The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, and so on.

// For example, 10101010 should be 01010101. 11100010 should be 11010001.

// Bonus: Can you do this in one line 

/*public static void main(String[] args) {
    int a = 0b10101010; // 170 decimal
    int swappedA = swapEvenOddBits(a);
    System.out.println(Integer.toBinaryString(swappedA)); // prints 1010101 (leading zero omitted), so "01010101"

    int b = 0b11100010; // 226 decimal
    int swappedB = swapEvenOddBits(b);
    System.out.println(Integer.toBinaryString(swappedB)); // prints 11010001
}
*/


public class _109_BitSwapper {

    /**
     * Swap even and odd bits of an 8-bit unsigned integer in one line.
     * 
     * @param x the input 8-bit integer (0-255)
     * @return integer with even and odd bits swapped
     */
    public static int swapEvenOddBits(int x) {
        return (x & 0xAA) >> 1 | (x & 0x55) << 1; // One-liner to swap bits
    }

    public static void main(String[] args) {
        int a = 0b10101010; // 170 decimal
        int swappedA = swapEvenOddBits(a);
        System.out.printf("Original: %8s, Swapped: %8s%n", 
                          Integer.toBinaryString(a | 0x100).substring(1), 
                          Integer.toBinaryString(swappedA | 0x100).substring(1));

        int b = 0b11100010; // 226 decimal
        int swappedB = swapEvenOddBits(b);
        System.out.printf("Original: %8s, Swapped: %8s%n", 
                          Integer.toBinaryString(b | 0x100).substring(1), 
                          Integer.toBinaryString(swappedB | 0x100).substring(1));
    }
}
