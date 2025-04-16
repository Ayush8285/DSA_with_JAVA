package interviewQuestions.Array_and_String;

// 🔷 Problem Name: Two Sum Problem

// 🔶 Problem Statement:
// Given an array of integers nums and an integer target,
//  return indices of the two numbers such that they add up to the target.


// 🔷 Intuition:
// We need to find two values a and b such that a + b = target.
// Instead of using nested loops (O(n²)), we use a HashMap 
// to store numbers as we iterate, and for each number x,
//  we check if target - x already exists in the map.


import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public int[] twoSum(int[] nums, int target) {
        // Map to store number and its index
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // What we want to find

            // If we already saw the complement, return the pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store the current number with its index
            map.put(nums[i], i);
        }

        // If no pair found, return empty array
        return new int[] {};
    }

    public static void main(String[] args) {
        TwoSumProblem ts = new TwoSumProblem();
        int[] result = ts.twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}




// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(n)

