// Implement an LFU (Least Frequently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:

// set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least frequently used item. If there is a tie, then the least recently used key should be removed.
// get(key): gets the value at key. If no such key exists, return null.
// Each operation should run in O(1) time.
import java.util.*;

public class _67_LFUCache {
    private final int capacity;
    private int minFreq;
    private final Map<Integer, Integer> keyToValue;
    private final Map<Integer, Integer> keyToFreq;
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public _67_LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToValue = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public Integer get(int key) {
        if (!keyToValue.containsKey(key)) {
            return null;
        }

        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        // Remove key from current frequency list
        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }

        // Add key to next frequency list
        freqToKeys.computeIfAbsent(freq + 1, f -> new LinkedHashSet<>()).add(key);

        return keyToValue.get(key);
    }

    public void set(int key, int value) {
        if (capacity == 0) return;

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            get(key); // Update frequency
            return;
        }

        // Evict if necessary
        if (keyToValue.size() >= capacity) {
            LinkedHashSet<Integer> minFreqKeys = freqToKeys.get(minFreq);
            int evictKey = minFreqKeys.iterator().next();
            minFreqKeys.remove(evictKey);
            if (minFreqKeys.isEmpty()) {
                freqToKeys.remove(minFreq);
            }
            keyToValue.remove(evictKey);
            keyToFreq.remove(evictKey);
        }

        // Insert new key
        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, f -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }
}

