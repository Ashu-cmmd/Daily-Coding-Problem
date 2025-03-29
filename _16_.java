// You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

// record(order_id): adds the order_id to the log
// get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
// You should be as efficient with time and space as possible.

public class _16_ {
    private int[] log;
    private int size;
    private int capacity;
    private int start;
    private int end;

    // Constructor to initialize the log with a given capacity N
    public _16_(int N) {
        this.capacity = N;
        this.log = new int[N];
        this.size = 0;
        this.start = 0;
        this.end = 0;
    }

    // Record the order ID
    public void record(int orderId) {
        // If the log is full, move the start pointer to overwrite the oldest order
        if (size == capacity) {
            start = (start + 1) % capacity;
        } else {
            size++;
        }
        // Insert the new order ID at the end position
        log[end] = orderId;
        // Update the end pointer, wrapping around if necessary
        end = (end + 1) % capacity;
    }

    // Get the ith last order ID (1-based index)
    public int get_last(int i) {
        // Calculate the actual index in the circular buffer
        int index = (end - i + capacity - 1) % capacity;
        return log[index];
    }

    public static void main(String[] args) {
        // Create an _16_ with a capacity of 3
        _16_ orderLog = new _16_(3);

        // Record some order IDs
        orderLog.record(101); // [101]
        orderLog.record(102); // [101, 102]
        orderLog.record(103); // [101, 102, 103]

        // Get the 1st last order ID
        System.out.println(orderLog.get_last(1)); // Output: 103

        // Record another order, this will overwrite the oldest order ID (101)
        orderLog.record(104); // [104, 102, 103]

        // Get the 2nd last order ID (which is now 102)
        System.out.println(orderLog.get_last(2)); // Output: 102
    }
}
