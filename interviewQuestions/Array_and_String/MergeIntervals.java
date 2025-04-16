package interviewQuestions.Array_and_String;

// 🔷 Problem Name: Merge Intervals

// 🔶 Problem Statement:
// Given a collection of intervals, merge all overlapping intervals.


// 🔷 Approach:
// Sort intervals based on start time.

// Initialize a result list and add the first interval.

// Traverse the rest:

//       If overlapping, merge (update end time).

//       Else, add new interval to result.


import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int[] interval : intervals) {
            // Check for overlap
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                merged.add(current);
                current = interval;
            }
        }

        merged.add(current); // Add the last interval
        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] input = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] output = mi.merge(input);

        for (int[] interval : output)
            System.out.println(Arrays.toString(interval));
        // Output: [1,6] [8,10] [15,18]
    }
}



// ✅ Time Complexity: O(n log n) — due to sorting
// ✅ Space Complexity: O(n) — for the merged list
