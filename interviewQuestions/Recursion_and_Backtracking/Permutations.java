package interviewQuestions.Recursion_and_Backtracking;

//🔶  Problem  Name: Permutations of an Array



// 📘 Problem Statement
// Given an array of distinct integers, return all possible permutations of the array.



// 🧠 Approach
// Use backtracking.
// Swap elements at each index to fix positions and recursively permute the remaining.
// Backtrack by undoing the swap after recursion.



// 🔍 Visualization
// For nums = [1, 2, 3], the recursive tree looks like:
// Start: []
// → Fix 1 → [1]
//    → Fix 2 → [1, 2]
//       → Fix 3 → [1, 2, 3]
//    → Fix 3 → [1, 3]
//       → Fix 2 → [1, 3, 2]
// → Fix 2 → [2]
//    → Fix 1 → [2, 1, 3]
//    → Fix 3 → [2, 3, 1]
// → Fix 3 → [3]
//    → Fix 1 → [3, 1, 2]
//    → Fix 2 → [3, 2, 1]




import java.util.*;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            result.add(perm);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            backtrack(nums, index + 1, result);
            swap(nums, i, index); // backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = obj.permute(nums);
        System.out.println("All permutations:");
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}


// 🖥️ Output
// All permutations:
// [1, 2, 3]
// [1, 3, 2]
// [2, 1, 3]
// [2, 3, 1]
// [3, 2, 1]
// [3, 1, 2]

// 📈 Complexity
// Time: O(n!) → n! permutations

// Space: O(n) → recursion stack