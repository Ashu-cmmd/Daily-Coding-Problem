// Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

// Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.

public class _28_RunLengthEncoding {

    // Method for Run-Length Encoding
    public static String encode(String input) {
        StringBuilder encodedString = new StringBuilder();
        
        int n = input.length();
        int count = 1;
        
        // Traverse through the input string
        for (int i = 1; i < n; i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                // If the current character is same as the previous, increment the count
                count++;
            } else {
                // Append count and character to the encoded string
                encodedString.append(count).append(input.charAt(i - 1));
                count = 1; // Reset the count for the next character
            }
        }
        
        // Append the last character group
        encodedString.append(count).append(input.charAt(n - 1));
        
        return encodedString.toString();
    }

    // Method for Run-Length Decoding
    public static String decode(String encoded) {
        StringBuilder decodedString = new StringBuilder();
        
        int n = encoded.length();
        int i = 0;
        
        // Traverse through the encoded string
        while (i < n) {
            int count = 0;
            
            // Extract the count (can have more than one digit)
            while (i < n && Character.isDigit(encoded.charAt(i))) {
                count = count * 10 + (encoded.charAt(i) - '0');
                i++;
            }
            
            // Append the character count times
            for (int j = 0; j < count; j++) {
                decodedString.append(encoded.charAt(i));
            }
            
            i++; // Move to the next character after the digit
        }
        
        return decodedString.toString();
    }

    public static void main(String[] args) {
        // Test encoding
        String input = "AABBMMAAAAAAAAAAAAAAABBBCCDAA";
        String encoded = encode(input);
        System.out.println("Encoded: " + encoded); // Output should be "4A3B2C1D2A"

        // Test decoding
        String decoded = decode(encoded);
        System.out.println("Decoded: " + decoded); // Output should be "AAAABBBCCDAA"
    }
}
