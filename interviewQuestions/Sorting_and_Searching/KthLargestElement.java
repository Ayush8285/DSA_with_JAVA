package interviewQuestions.Sorting_and_Searching;

// ⚡ Problem  Name: Kth Largest Element in an Array



// 🧾 Problem Statement:
// Given an integer array nums and an integer k, return the kth largest element in the array.

// Example:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5



// 🧠 Approach:
// ✅ Min Heap Approach:
//      Use a min-heap (priority queue) of size k
//      Push elements into heap
//      If heap size > k, remove smallest
//      Top of heap is the kth largest





import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();  // remove the smallest
            }
        }

        return minHeap.peek(); // kth largest
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth Largest Element: " + findKthLargest(nums, k));
    }
}



// 🖨️ Output:
// Kth Largest Element: 5


// ⏱️ Complexity:
// Time: O(n log k)

// Space: O(k)