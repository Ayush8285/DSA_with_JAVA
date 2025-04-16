package interviewQuestions.Trie_and_Hashing;

// ⚡ Problem  Name: Subarray Sum Equals K



// 🧾 Problem Statement:
// Given an integer array nums and integer k, return total number of subarrays whose sum equals k.

// Example:
// Input: nums = [1,1,1], k = 2 → Output: 2



// 🧠 Approach:
// Use a prefix sum and hashmap of sum → frequency.



// ✅ Visual Example:
// Input: nums = [1, 1, 1], k = 2
// Prefix sum tracking:
// Index:   0   1   2
// Nums:    1   1   1
// Prefix:  1   2   3

// Check sum - k:
// At index 0: sum=1, sum-k=-1 → 0 matches
// At index 1: sum=2, sum-k=0 → 1 match
// At index 2: sum=3, sum-k=1 → 1 match

// Total matches: 2



import java.util.*;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // to handle case where sum == k at start

        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Subarrays summing to " + k + ": " + subarraySum(nums, k));
    }
}


// 🖨️ Output:
// Subarrays summing to 2: 2



// ⏱️ Complexity:
// Time: O(n)

// Space: O(n)
