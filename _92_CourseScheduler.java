
// This problem was asked by Airbnb.

// We're given a hashmap associating each courseId key with a list of courseIds values, which represents that the prerequisites of courseId are courseIds. Return a sorted ordering of courses such that we can finish all courses.

// Return null if there is no such ordering.

// For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSCS300']
import java.util.*;

public class _92_CourseScheduler {
    public static List<String> findOrder(Map<String, List<String>> prerequisites) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        
        // Build the graph and in-degree count
        for (String course : prerequisites.keySet()) {
            graph.putIfAbsent(course, new ArrayList<>());
            inDegree.putIfAbsent(course, 0);
            for (String prereq : prerequisites.get(course)) {
                graph.putIfAbsent(prereq, new ArrayList<>());
                graph.get(prereq).add(course);
                inDegree.put(course, inDegree.get(course) + 1);
            }
        }

        // Queue for courses with no prerequisites
        Queue<String> queue = new LinkedList<>();
        for (String course : inDegree.keySet()) {
            if (inDegree.get(course) == 0) {
                queue.offer(course);
            }
        }

        List<String> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);
            for (String neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check if we were able to include all courses
        if (order.size() != prerequisites.size()) {
            return null; // Cycle detected or not all courses can be completed
        }
        return order;
    }

    public static void main(String[] args) {
        Map<String, List<String>> prerequisites = new HashMap<>();
        prerequisites.put("CSC300", Arrays.asList("CSC100", "CSC200"));
        prerequisites.put("CSC200", Arrays.asList("CSC100"));
        prerequisites.put("CSC100", Arrays.asList());

        List<String> order = findOrder(prerequisites);
        if (order != null) {
            System.out.println("Course order: " + order);
        } else {
            System.out.println("No valid course order exists.");
        }
    }
}
