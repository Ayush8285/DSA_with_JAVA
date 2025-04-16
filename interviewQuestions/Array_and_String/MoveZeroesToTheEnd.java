package interviewQuestions.Array_and_String;

// 🔷 Problem Name: Move Zeroes to the End

// 🔶 Problem Statement:
// Given an array nums, move all 0s to the end while maintaining 
// the relative order of the non-zero elements.


// 🔷 Approach:
//-- Use a pointer (insertPos) to track where the next non-zero number should go.

//--Iterate the array:

//      For each non-zero, put it at insertPos and increment it.

//      After that, fill remaining indices with 0.


public class MoveZeroesToTheEnd {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Move non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill the rest with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroesToTheEnd mz = new MoveZeroesToTheEnd();
        int[] nums = {0, 1, 0, 3, 12};
        mz.moveZeroes(nums);

        for (int num : nums)
            System.out.print(num + " ");  // Output: 1 3 12 0 0
    }
}



// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(1)
