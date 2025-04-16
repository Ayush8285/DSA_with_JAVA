package interviewQuestions.Trie_and_Hashing;

// ⚡ Problem  Name:Longest Prefix Match



// 🧾 Problem Statement:
// Given an array of strings, return the longest common prefix.

// Example:
// Input: ["flower","flow","flight"] → Output: "fl"



// 🧠 Approach:
// Compare characters column-wise, stop at mismatch.



// ✅ Visual Example:
// Input:
// ["flower", "flow", "flight"]

// Step-by-step prefix check:
// prefix = "flower"
// compare with "flow" → match till "flow" → prefix becomes "flow"
// compare with "flight" → match till "fl" → prefix becomes "fl"




public class LongestPrefixMatch {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }
}

// 🖨️ Output:
// Longest Common Prefix: fl




// ⏱️ Complexity:
// Time: O(n * m) (n = words, m = length of shortest string)

// Space: O(1)
