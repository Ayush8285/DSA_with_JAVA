package interviewQuestions.Greedy_and_DynamicProgramming;

// 📅 Problem  Name: Activity Selection Problem



// 🧾 Problem Statement:
// Given n activities with start[] and end[] times,
//  select the maximum number of non-overlapping activities.



// 🧠 Approach:
// Greedy Algorithm – Always pick activity that ends earliest and doesn't overlap.



// 👁️ Visualization:
// start[] = {1, 3, 0, 5, 8, 5}
// end[]   = {2, 4, 6, 7, 9, 9}

// Sort by end time → pick: (1,2), (3,4), (5,7), (8,9) ✅



import java.util.*;

class Activity {
    int start, end;
    Activity(int s, int e) { start = s; end = e; }
}

public class ActivitySelection {
    public static int maxActivities(int[] start, int[] end) {
        int n = start.length;
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], end[i]));
        }

        activities.sort(Comparator.comparingInt(a -> a.end));

        int count = 1;
        int lastEnd = activities.get(0).end;

        for (int i = 1; i < n; i++) {
            if (activities.get(i).start >= lastEnd) {
                count++;
                lastEnd = activities.get(i).end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end =   {2, 4, 6, 7, 9, 9};
        System.out.println("Max non-overlapping activities: " + maxActivities(start, end));
    }
}


// 🖨️ Output:
// Max non-overlapping activities: 4


// ⏱️ Complexity:
// Time: O(n log n) (for sorting)

// Space: O(n)
