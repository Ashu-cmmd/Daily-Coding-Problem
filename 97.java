// This problem was asked by Stripe.

// Write a map implementation with a get function that lets you retrieve the value of a key at a particular time.

// It should contain the following methods:

// set(key, value, time): sets key to value for t = time.
// get(key, time): gets the key at t = time.
// The map should work like this. If we set a key at a particular time, it will maintain that value forever or until it gets set at a later time. In other words, when we get a key at a time, it should return the value that was set for that key set at the most recent time.

// Consider the following examples:

// d.set(1, 1, 0) # set key 1 to value 1 at time 0
// d.set(1, 2, 2) # set key 1 to value 2 at time 2
// d.get(1, 1) # get key 1 at time 1 should be 1
// d.get(1, 3) # get key 1 at time 3 should be 2
// d.set(1, 1, 5) # set key 1 to value 1 at time 5
// d.get(1, 0) # get key 1 at time 0 should be null
// d.get(1, 10) # get key 1 at time 10 should be 1
// d.set(1, 1, 0) # set key 1 to value 1 at time 0
// d.set(1, 2, 0) # set key 1 to value 2 at time 0
// d.get(1, 0) # get key 1 at time 0 should be 2

import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {
    // A map where each key maps to a TreeMap of time-value pairs
    private HashMap<Integer, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    // Set the value for a key at a specific time
    public void set(int key, String value, int time) {
        // Get the TreeMap for the key, or create a new one if it doesn't exist
        map.putIfAbsent(key, new TreeMap<>());
        // Set the value at the specified time
        map.get(key).put(time, value);
    }

    // Get the value for a key at a specific time
    public String get(int key, int time) {
        // Check if the key exists
        if (!map.containsKey(key)) {
            return null; // Key does not exist
        }
        // Get the TreeMap for the key
        TreeMap<Integer, String> timeMap = map.get(key);
        // Find the greatest time less than or equal to the specified time
        Integer floorKey = timeMap.floorKey(time);
        // If such a time exists, return the corresponding value
        if (floorKey != null) {
            return timeMap.get(floorKey);
        }
        return null; // No value exists for the specified time
    }

    public static void main(String[] args) {
        TimeMap d = new TimeMap();
        d.set(1, "1", 0); // set key 1 to value "1" at time 0
        d.set(1, "2", 2); // set key 1 to value "2" at time 2
        System.out.println(d.get(1, 1)); // get key 1 at time 1 should be "1"
        System.out.println(d.get(1, 3)); // get key 1 at time 3 should be "2"
        d.set(1, "1", 5); // set key 1 to value "1" at time 5
        System.out.println(d.get(1, 0)); // get key 1 at time 0 should be null
        System.out.println(d.get(1, 10)); // get key 1 at time 10 should be "1"
        d.set(1, "1", 0); // set key 1 to value "1" at time 0
        d.set(1, "2", 0); // set key 1 to value "2" at time 0
        System.out.println(d.get(1, 0)); // get key 1 at time 0 should be "2"
    }
}
