package interviewQuestions.Greedy_and_DynamicProgramming;

//🔶  Problem  Name: 0/1 Knapsack Problem



// 🧾 Problem Statement:
// Given n items with weights and values, 
// and a knapsack of capacity W, find the maximum total value that fits in the knapsack.
// You cannot break items (either take it or leave it).



// 🧠 Approach:
// Use DP table where dp[i][w] stores max value using first
//  i items with capacity w.



// 📋 Formula:
// if (wt[i-1] <= w)
//     dp[i][w] = max(dp[i-1][w], dp[i-1][w - wt[i-1]] + val[i-1]);
// else
//     dp[i][w] = dp[i-1][w];




public class Knapsack01 {
    public static int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {10, 40, 50, 70};
        int W = 8;
        System.out.println("Maximum value in Knapsack = " + knapsack(wt, val, W));
    }
}


// 🖨️ Output:
// Maximum value in Knapsack = 110


// ⏱️ Complexity:
// Time: O(n * W)

// Space: O(n * W)