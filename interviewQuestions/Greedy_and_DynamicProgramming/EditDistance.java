package interviewQuestions.Greedy_and_DynamicProgramming;

//🔶  Problem  Name: Edit Distance (Levenshtein Distance)



// 🧾 Problem Statement:
// Given two strings word1 and word2, find the minimum number of operations to convert word1 into word2.
// Operations: Insert, Delete, Replace



// 🧠 Approach:
// Use Dynamic Programming with a 2D table dp[i][j] where:
//      i = length of word1 prefix
//      j = length of word2 prefix



// 📋 Transition:
// if (word1[i-1] == word2[j-1])
//     dp[i][j] = dp[i-1][j-1];
// else
//     dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]); // delete, insert, replace



// 👁️ Visualization (word1 = "horse", word2 = "ros"):
// r  o  s
// 0  1  2  3
// h  1  1  2  3
// o  2  2  1  2
// r  3  2  2  2
// s  4  3  3  2
// e  5  4  4  3




public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        // fill table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // replace
                                 Math.min(dp[i - 1][j],     // delete
                                          dp[i][j - 1]));   // insert
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("Edit Distance: " + minDistance(word1, word2));
    }
}



// 🖨️ Output:
// Edit Distance: 3



// ⏱️ Complexity:
// Time: O(m * n)

// Space: O(m * n)