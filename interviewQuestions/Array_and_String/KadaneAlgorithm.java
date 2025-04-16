package interviewQuestions.Array_and_String;


// 🔷 Problem Name: Kadane's Algorithm (Maximum Subarray)

// 🔶 Problem Statement:
// Given an integer array nums, find the contiguous subarray 
// (containing at least one number) which has the largest sum, and return its sum.


// 🔷 Intuition:
// --Keep track of the maximum sum seen so far.

// --At each position i, decide:

//       Start a new subarray at i, or

//       Extend the subarray ending at i-1 by adding nums[i].




public class KadaneAlgorithm {
    public int maxSubArray(int[] nums) {
        // Start with first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Traverse from second element onwards
        for (int i = 1; i < nums.length; i++) {
            // Either take current element or extend the previous subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update maxSum if current is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        KadaneAlgorithm ka = new KadaneAlgorithm();
        int result = ka.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("Maximum Subarray Sum: " + result);
    }
}



// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(1)
