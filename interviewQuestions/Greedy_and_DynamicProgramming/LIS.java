package interviewQuestions.Greedy_and_DynamicProgramming;

//🔶  Problem  Name: Longest Increasing Subsequence (LIS)



// 🧾 Problem Statement:
// Given an array of integers, find the length of the Longest Increasing Subsequence.



// 🧠 Approach:
// Use DP array dp[i] = length of LIS ending at index i.



import java.util.Arrays;

public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + lengthOfLIS(arr));
    }
}


// 🖨️ Output:
// Length of LIS: 4
// (Sequence: 2, 3, 7, 101)



// ⏱️ Complexity:
// Time: O(n^2)

// Space: O(n)