package interviewQuestions.Recursion_and_Backtracking;

//🔶  Problem  Name: Combinations



// 📘 Problem Statement
// Given two integers n and k, return all possible combinations of k numbers out of the range 1 to n.

// For example, for n = 4, k = 2, output should be:
// [1,2], [1,3], [1,4], [2,3], [2,4], [3,4]



// 🧠 Approach
// Use backtracking to explore all combinations.
// Start from start = 1 and include numbers up to n.
// If the current combination reaches length k, add it to the result.



// 🔍 Visualization
// For n = 4, k = 2:
// Start: []
// → Add 1 → [1]
//    → Add 2 → [1,2] ✅
//    → Add 3 → [1,3] ✅
//    → Add 4 → [1,4] ✅
// → Add 2 → [2]
//    → Add 3 → [2,3] ✅
//    → Add 4 → [2,4] ✅
// → Add 3 → [3]
//    → Add 4 → [3,4] ✅




import java.util.*;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(i + 1, n, k, temp, result);
            temp.remove(temp.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        int n = 4, k = 2;
        List<List<Integer>> combinations = obj.combine(n, k);
        System.out.println("All combinations of " + k + " from 1 to " + n + ":");
        for (List<Integer> combo : combinations) {
            System.out.println(combo);
        }
    }
}


// 🖥️ Output
// All combinations of 2 from 1 to 4:
// [1, 2]
// [1, 3]
// [1, 4]
// [2, 3]
// [2, 4]
// [3, 4]

// 📈 Complexity
// Time: O(C(n, k))

// Space: O(k) → for the current combination in recursion
