
//🔶  Problem  Name: Sliding Window Maximum



// 🔍 Problem
// Given an array nums[] and integer k, return the maximum for each sliding window of size k.



// 🧠 Approach
//      Use a deque to store indexes:
//      Remove all smaller elements from back
//      Remove elements out of window from front
//      The front of deque always has index of max element



// 📊 Visualization
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3  
// Windows:
// [1,3,-1] → max = 3  
// [3,-1,-3] → max = 3  
// [-1,-3,5] → max = 5  
// [-3,5,3] → max = 5  
// [5,3,6] → max = 6  
// [3,6,7] → max = 7  
// Output: [3,3,5,5,6,7]




import java.sql.Time;
import java.util.*;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove out-of-window elements
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offer(i);

            // Add max to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = swm.maxSlidingWindow(nums, k);
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result));
    }
}

// ✅ Output
// Sliding Window Maximum: [3, 3, 5, 5, 6, 7]


// 📈 Time and Space Complexity
// Time: O(n) — each element pushed and popped at most once

// Space: O(k) — for the deque


