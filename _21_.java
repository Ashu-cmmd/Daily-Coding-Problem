// Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

// For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

import java.util.Arrays;

public class _21_ {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Separate the start and end times into two arrays
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        // Sort both start and end times
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPointer = 0, endPointer = 0;
        int roomsRequired = 0;

        // Simulate the process of assigning rooms
        while (startPointer < intervals.length) {
            // If the current meeting starts after the meeting with the earliest end time
            if (startTimes[startPointer] >= endTimes[endPointer]) {
                // We can reuse the room (increment end pointer)
                endPointer++;
            } else {
                // Otherwise, we need a new room
                roomsRequired++;
            }
            // Move the start pointer to the next meeting
            startPointer++;
        }

        return roomsRequired;
    }

    public static void main(String[] args) {
        _21_ solution = new _21_();
        
        // Example input
        int[][] intervals = { {30, 75}, {0, 50}, {60, 150} };
        
        // Get the minimum number of rooms
        int result = solution.minMeetingRooms(intervals);
        
        System.out.println("Minimum number of rooms required: " + result);
    }
}
