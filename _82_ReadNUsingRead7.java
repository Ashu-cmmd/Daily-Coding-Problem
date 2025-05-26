// Using a read7() method that returns 7 characters from a file, implement readN(n) which reads n characters.

// For example, given a file with the content “Hello world”, three read7() returns “Hello w”, “orld” and then “

public class _82_ReadNUsingRead7 {
    private String fileContent;
    private int filePointer;

    public _82_ReadNUsingRead7(String content) {
        this.fileContent = content;
        this.filePointer = 0;
    }

    /**
     * Simulates read7() which reads up to 7 characters from the "file".
     * Moves an internal pointer forward.
     * @return A string containing up to 7 characters, or empty string if EOF.
     */
    public String read7() {
        if (filePointer >= fileContent.length()) {
            return ""; // End of file
        }
        int endPointer = Math.min(filePointer + 7, fileContent.length());
        String chunk = fileContent.substring(filePointer, endPointer);
        filePointer = endPointer;
        return chunk;
    }

    /**
     * Reads n characters from the file by calling read7() as needed.
     * @param n number of characters to read
     * @return A string with up to n characters read from the file.
     */
    public String readN(int n) {
        StringBuilder result = new StringBuilder();
        while (result.length() < n) {
            String next7 = read7();
            if (next7.isEmpty()) {
                // EOF reached
                break;
            }
            // Calculate how many characters we still need
            int needed = n - result.length();
            if (next7.length() <= needed) {
                result.append(next7);
            } else {
                // Append only needed characters
                result.append(next7.substring(0, needed));
                // Adjust filePointer to "unread" the extras
                filePointer -= (next7.length() - needed);
            }
        }
        return result.toString();
    }

    // Example usage and testing
    public static void main(String[] args) {
        String content = "Hello world";

        _82_ReadNUsingRead7 reader = new _82_ReadNUsingRead7(content);

        System.out.println("First read7(): \"" + reader.read7() + "\"");  // "Hello w"
        System.out.println("Second read7(): \"" + reader.read7() + "\""); // "orld"
        System.out.println("Third read7(): \"" + reader.read7() + "\"");  // ""

        // Reset pointer for readN demonstration
        reader.filePointer = 0;

        System.out.println("ReadN(5): \"" + reader.readN(5) + "\""); // Hello
        System.out.println("ReadN(3): \"" + reader.readN(3) + "\""); // " wo"
        System.out.println("ReadN(10): \"" + reader.readN(10) + "\""); // "rld"
    }
}

