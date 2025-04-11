import java.util.*;

public class _41_Itinerary {
    public List<String> findItinerary(List<List<String>> tickets, String start) {
        // Step 1: Build the graph
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        // Step 2: Add all flights to the graph and sort the destinations lexicographically
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        // Step 3: Prepare the result list to store the itinerary
        List<String> result = new ArrayList<>();
        
        // Step 4: Perform DFS to build the itinerary
        dfs(graph, start, result);
        
        // Step 5: Reverse the result to get the correct order of itinerary
        Collections.reverse(result);
        
        return result;
    }

    // Helper method to perform DFS
    private void dfs(Map<String, PriorityQueue<String>> graph, String current, List<String> result) {
        // If there are still destinations from the current airport
        while (graph.containsKey(current) && !graph.get(current).isEmpty()) {
            // Get the next destination (lexicographically smallest)
            String next = graph.get(current).poll();
            // Recurse on the next airport
            dfs(graph, next, result);
        }
        // Add the current airport to the result (after visiting all possible destinations from it)
        result.add(current);
    }

    public static void main(String[] args) {
        _41_Itinerary itineraryFinder = new _41_Itinerary();

        // Test Case 1
        List<List<String>> tickets1 = Arrays.asList(
            Arrays.asList("SFO", "HKO"),
            Arrays.asList("YYZ", "SFO"),
            Arrays.asList("YUL", "YYZ"),
            Arrays.asList("HKO", "ORD")
        );
        System.out.println(itineraryFinder.findItinerary(tickets1, "YUL"));  // Expected: [YUL, YYZ, SFO, HKO, ORD]

        // Test Case 2
        List<List<String>> tickets2 = Arrays.asList(
            Arrays.asList("SFO", "COM"),
            Arrays.asList("COM", "YYZ")
        );
        System.out.println(itineraryFinder.findItinerary(tickets2, "COM"));  // Expected: null

        // Test Case 3
        List<List<String>> tickets3 = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("A", "C"),
            Arrays.asList("B", "C"),
            Arrays.asList("C", "A")
        );
        System.out.println(itineraryFinder.findItinerary(tickets3, "A"));  // Expected: [A, B, C, A, C]
    }
}
