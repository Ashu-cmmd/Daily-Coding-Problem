import java.util.*;

public class _33_RunningMedian {
    // Max-heap for the smaller half of the numbers
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // Min-heap for the larger half of the numbers
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNumber(int num) {
        // Ensure the maxHeap contains the smaller half and minHeap contains the larger half
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num); // Add to the maxHeap (smaller half)
        } else {
            minHeap.offer(num); // Add to the minHeap (larger half)
        }

        // Balance the heaps if necessary (size difference can be at most 1)
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); // Move the top element of maxHeap to minHeap
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll()); // Move the top element of minHeap to maxHeap
        }

        // Print the current median
        if (maxHeap.size() > minHeap.size()) {
            // If maxHeap has more elements, the median is the root of maxHeap
            System.out.println("Median: " + maxHeap.peek());
        } else {
            // If heaps are of equal size, the median is the average of the roots of both heaps
            double median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            System.out.println("Median: " + median);
        }
    }

    public static void main(String[] args) {
        _33_RunningMedian runningMedian = new _33_RunningMedian();
        
        // Test the running median with a stream of numbers
        runningMedian.addNumber(1);
        runningMedian.addNumber(5);
        runningMedian.addNumber(2);
        runningMedian.addNumber(10);
        runningMedian.addNumber(3);
        runningMedian.addNumber(7);
    }
}
