package interviewQuestions.Greedy_and_DynamicProgramming;

// 🦘 Problem  Name: Jump Game



// 🧾 Problem Statement:
// Given an array nums, where each element is your maximum
//  jump length, return true if you can reach the last index, else false.



// 🧠 Approach:
// Greedy – Track farthest reachable index at every step.



// 👁️ Visualization:
// nums = [2, 3, 1, 1, 4]
// Index:     0  1  2  3  4

// Can jump:
// - from 0 → 2 (up to index 2)
// - from 1 → 3 or 4 ✅



public class JumpGame {
    public static boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false;
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Can reach end: " + canJump(nums));
    }
}



// 🖨️ Output:
// Can reach end: true


// ⏱️ Complexity:
// Time: O(n)

// Space: O(1)