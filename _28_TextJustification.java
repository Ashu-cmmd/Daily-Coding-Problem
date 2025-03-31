import java.util.*;

public class _28_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0, n = words.length;

        while (i < n) {
            int lineLength = words[i].length();
            int j = i + 1;

            // Find as many words as possible for this line
            while (j < n && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int spaces = maxWidth - lineLength;
            int numWords = j - i;
            StringBuilder line = new StringBuilder();

            // If it's the last line or only one word, left-justify
            if (numWords == 1 || j == n) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (line.length() < maxWidth) line.append(" ");
                }
                while (line.length() < maxWidth) line.append(" ");
            } else {
                // Distribute spaces evenly
                int spaceBetween = spaces / (numWords - 1);
                int extraSpaces = spaces % (numWords - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) { // Add spaces if not the last word
                        for (int s = 0; s < spaceBetween + (extraSpaces-- > 0 ? 1 : 0); s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j; // Move to the next set of words
        }

        return result;
    }

    public static void main(String[] args) {
        _28_TextJustification tj = new _28_TextJustification();
        String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        int maxWidth = 16;
        List<String> result = tj.fullJustify(words, maxWidth);

        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }
}
