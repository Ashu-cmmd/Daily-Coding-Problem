// Implement a URL shortener with the following methods:

// shorten(url), which shortens the url into a six-character alphanumeric string, such as zLg6wl.
// restore(short), which expands the shortened string into the original url. If no such shortened string exists, return null.

import java.util.*;

class URLShortener {
    private static final String BASE_URL = "http://short.ly/";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int URL_LENGTH = 6;

    private Map<String, String> urlToShortened = new HashMap<>();
    private Map<String, String> shortenedToUrl = new HashMap<>();
    private Random random = new Random();

    // Generate a random 6-character alphanumeric string
    private String generateShortenedURL() {
        StringBuilder shortURL = new StringBuilder();
        for (int i = 0; i < URL_LENGTH; i++) {
            int index = random.nextInt(ALPHABET.length());
            shortURL.append(ALPHABET.charAt(index));
        }
        return shortURL.toString();
    }

    // Shorten the given URL
    public String shorten(String url) {
        if (urlToShortened.containsKey(url)) {
            return BASE_URL + urlToShortened.get(url);  // Return already shortened URL if exists
        }

        // Generate a unique shortened URL
        String shortURL = generateShortenedURL();
        while (shortenedToUrl.containsKey(shortURL)) {
            shortURL = generateShortenedURL();  // Ensure uniqueness of the shortened URL
        }

        urlToShortened.put(url, shortURL);
        shortenedToUrl.put(shortURL, url);
        return BASE_URL + shortURL;
    }

    // Restore the original URL from the shortened string
    public String restore(String shortURL) {
        String shortCode = shortURL.replace(BASE_URL, "");
        return shortenedToUrl.getOrDefault(shortCode, null);  // Return null if not found
    }
}

public class _55_Solution {
    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        // Test the shorten and restore methods
        String originalURL = "https://www.example.com";
        String shortenedURL = shortener.shorten(originalURL);
        System.out.println("Shortened URL: " + shortenedURL);

        String restoredURL = shortener.restore(shortenedURL);
        System.out.println("Restored URL: " + restoredURL);

        // Trying with a non-existent shortened URL
        String nonExistent = shortener.restore("http://short.ly/abc123");
        System.out.println("Restored non-existent URL: " + nonExistent);
    }
}
