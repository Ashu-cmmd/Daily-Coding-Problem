import java.util.HashMap;
import java.util.TreeMap;

class _97_TimeMap {
    // A map to store the key and its corresponding time-value pairs
    private HashMap<String, TreeMap<Integer, String>> map;

    public _97_TimeMap() {
        map = new HashMap<>();
    }

    // Method to set the value for a key at a specific time
    public void set(String key, String value, int time) {
        // Get the TreeMap for the key, or create a new one if it doesn't exist
        map.putIfAbsent(key, new TreeMap<>());
        // Set the value at the specified time
        map.get(key).put(time, value);
    }

    // Method to get the value for a key at a specific time
    public String get(String key, int time) {
        // Check if the key exists in the map
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
        _97_TimeMap d = new _97_TimeMap();
        d.set("1", "1", 0); // set key 1 to value 1 at time 0
        System.out.println(d.get("1", 1)); // get key 1 at time 1 should be 1
        d.set("1", "2", 2); // set key 1 to value 2 at time 2
        System.out.println(d.get("1", 3)); // get key 1 at time 3 should be 2
        d.set("1", "1", 5); // set key 1 to value 1 at time 5
        System.out.println(d.get("1", 0)); // get key 1 at time 0 should be 1
        System.out.println(d.get("1", 10)); // get key 1 at time 10 should be 1
        d.set("1", "1", 0); // set key 1 to value 1 at time 0
        d.set("1", "2", 0); // set key 1 to value 2 at time 0
        System.out.println(d.get("1", 0)); // get key 1 at time 0 should be 2
    }
}
