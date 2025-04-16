package interviewQuestions.Trie_and_Hashing;


// ⚡ Problem  Name:Group Anagrams



// 🧾 Problem Statement:
// Group strings that are anagrams into separate lists.

// Example:
// Input: ["eat","tea","tan","ate","nat","bat"]
// Output: [["eat","tea","ate"],["tan","nat"],["bat"]]



// 🧠 Approach:
// Use a hashmap with sorted string as key.



// ✅ Visual Example:
// Input:
// ["eat", "tea", "tan", "ate", "nat", "bat"]
// We sort each string:
// "eat" → "aet"
// "tea" → "aet"
// "tan" → "ant"
// "ate" → "aet"
// "nat" → "ant"
// "bat" → "abt"

// Group by sorted keys:
// "aet" → ["eat", "tea", "ate"]
// "ant" → ["tan", "nat"]
// "abt" → ["bat"]



import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}


// 🖨️ Output:
// [[eat, tea, ate], [tan, nat], [bat]]




// ⏱️ Complexity:
// Time: O(n * k log k) (n = number of words, k = word length)

// Space: O(nk)