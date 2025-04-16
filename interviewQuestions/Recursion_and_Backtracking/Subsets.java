package interviewQuestions.Recursion_and_Backtracking;

//🔶  Problem  Name: Subset Sum / Power Set



// 📘 Problem Statement
// Given an integer array nums, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets.

// Example:
// Input: nums = [1,2,3]  
// Output: [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]



// 🧠 Approach
// Use backtracking (DFS) to build subsets.
// Start with an empty list, and for each index:
//      Include the element and recurse.
//      Exclude the element and move on.
// This explores every possible combination.


// 🔍 Visualization
// Start: []
// → [1]
//   → [1,2]
//      → [1,2,3]
//      → [1,2]
//   → [1,3]
// → [2]
//   → [2,3]
// → [3]



import java.util.*;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        int[] nums = {1, 2, 3};

        List<List<Integer>> subsets = obj.subsets(nums);
        System.out.println("Power Set:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}


// 🖥️ Output
// Power Set:
// []
// [1]
// [1, 2]
// [1, 2, 3]
// [1, 3]
// [2]
// [2, 3]
// [3]

// 📈 Complexity
// Time: O(2^n) — All subsets

// Space: O(n) for recursion stack