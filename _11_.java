// Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

// For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

// Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

import java.util.ArrayList;
import java.util.List;

public class _11_ {

    // Trie node definition
    static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // Assuming only lowercase English letters
        List<String> words = new ArrayList<>(); // List to store words that can be formed from this node
    }

    // The root of the Trie
    private TrieNode root;

    public _11_(List<String> dictionary) {
        root = new TrieNode();
        // Preprocess the dictionary into the Trie
        for (String word : dictionary) {
            insert(word);
        }
    }

    // Insert a word into the Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Convert character to index
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.words.add(word); // Add the word to the list of possible completions
        }
    }

    // Search for words with the given prefix
    public List<String> autocomplete(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return new ArrayList<>(); // No words with this prefix
            }
            node = node.children[index];
        }
        return node.words; // Return the list of words with the given prefix
    }

    public static void main(String[] args) {
        List<String> dictionary = List.of("dog", "deer", "deal");
        _11_ system = new _11_(dictionary);

        // Test the autocomplete system
        String query = "de";
        List<String> result = system.autocomplete(query);

        System.out.println("Autocomplete results for '" + query + "': " + result);
    }
}
