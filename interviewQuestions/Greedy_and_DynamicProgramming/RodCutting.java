package interviewQuestions.Greedy_and_DynamicProgramming;

// 🪓 Problem  Name: Rod Cutting Problem



// 🧾 Problem Statement:
// Given a rod of length n and an array prices[] where
//  prices[i] is the price for length i+1, find the maximum
//   value obtainable by cutting the rod into pieces.



// 🧠 Approach:
// Use Dynamic Programming (like Unbounded Knapsack):
//      You can cut the rod into multiple lengths.
//      Choose best among all cut combinations.




// 👁️ Visualization:
// Say n = 4, prices = [1, 5, 8, 9] for lengths [1, 2, 3, 4].
// Try:
//      4 (whole) → 9
//      1 + 3 → 1 + 8 = 9
//      2 + 2 → 5 + 5 = 10 ✅




public class RodCutting {
    public static int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, price[j] + dp[i - j - 1]);
            }
            dp[i] = maxVal;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9}; // for lengths 1 to 4
        int n = 4;
        System.out.println("Maximum profit: " + cutRod(price, n));
    }
}



// 🖨️ Output:
// Maximum profit: 10


// ⏱️ Complexity:
// Time: O(n²)

// Space: O(n)