package interviewQuestions.Recursion_and_Backtracking;

//🔶  Problem  Name: Combination Sum



// 🧾 Problem Statement:
// Given an array of distinct integers candidates and a target integer target, return all unique combinations of candidates where the chosen numbers sum to target. You may use the same number multiple times.

// ✅ Constraints:
// All numbers in candidates and target are positive integers.
// You can reuse the same number multiple times.
// Return the combinations in any order.



// 🧠 Approach:
// Use backtracking to try each candidate.
// If the current sum exceeds the target, backtrack.
// If it equals the target, add the combination to the result.
// Reuse the same number, so recursive call stays at the current index.



// 👁️ Visualization:
// candidates = [2,3,6,7], target = 7

// Start from index 0:
// - pick 2 -> [2] → pick 2 again -> [2,2] → again -> [2,2,2] → again -> [2,2,2,2] → sum > 7 → backtrack
// - try 3 -> [2,2,3] → sum = 7 ✅
// - try 6, 7 → explore all
// Final output: [[2,2,3],[7]]



import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int start, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> combo : result) {
            System.out.println(combo);
        }
    }
}


// 🖨️ Output:
// Combinations that sum to 7:
// [2, 2, 3]
// [7]


// ⏱️ Time & Space Complexity:
// Time: O(2^T) where T = target (worst case: trying every combo)

// Space: O(T) recursion stack + result storage


