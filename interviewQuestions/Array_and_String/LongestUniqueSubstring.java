package interviewQuestions.Array_and_String;

// 🔷 Problem Name: Longest Substring Without Repeating Characters


// 🔶 Problem Summary:
// Given a string, find the length of the longest substring with all unique characters.



// 🧠 Thought Process:
// We're scanning the string for the maximum length window that doesn’t contain repeated characters.
// A sliding window works well here:
//      The window grows by expanding the end index.
//      If a repeat character is seen, shrink the window from the start until the character is unique again.
// Use a HashMap to store the last index of each character so you can jump the start pointer.



// ✅ Detailed Steps:
// Start with start = 0, maxLength = 0
// Iterate with a pointer end:
//      If the character exists in map and its last index ≥ start, move start to map.get(char) + 1
//      Update map with the current character and index
//      Update maxLength with end - start + 1



// 🔍 Dry Run:
// For "abcabcbb":
//      "abc" → length = 3
//      "bca" → again 3
//      but no longer string without repeating
// Answer: 3


import java.util.HashMap;

public class LongestUniqueSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0; // Start of the sliding window

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            // If duplicate character, shrink the window
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);
            }

            map.put(ch, end); // Update latest index of character
            maxLen = Math.max(maxLen, end - start + 1); // Update max length
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestUniqueSubstring lus = new LongestUniqueSubstring();
        String str = "abcabcbb";
        System.out.println("Longest substring length: " + lus.lengthOfLongestSubstring(str)); // Output: 3
    }
}


// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(charSet) ≈ O(128)
