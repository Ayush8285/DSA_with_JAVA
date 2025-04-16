package interviewQuestions.Greedy_and_DynamicProgramming;

//🔶  Problem  Name: Coin Change Problem (Minimum Coins)



// 🧾 Problem Statement:
// Given coins of different denominations and a total amount,
//  return the minimum number of coins needed.
// If not possible, return -1.



// 🧠 Approach:
// Use a 1D DP array where dp[i] = min coins to make amount i.



// 📋 Formula:
// dp[i] = min(dp[i], dp[i - coin] + 1)



import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // fill with max
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum coins required: " + coinChange(coins, amount));
    }
}



// 🖨️ Output:
// Minimum coins required: 3
// (11 = 5 + 5 + 1)


// ⏱️ Complexity:
// Time: O(amount * n)

// Space: O(amount)
