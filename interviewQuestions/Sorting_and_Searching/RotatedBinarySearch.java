package interviewQuestions.Sorting_and_Searching;


// ⚡ Problem  Name:  Binary Search in Rotated Sorted Array



// 🧾 Problem Statement:
// Given a rotated sorted array of distinct integers
//  and a target value, return the index of the target.
// If not found, return -1.

// Example:
// Input: nums = [4,5,6,7,0,1,2], target = 0 → Output: 4



// 🧠 Approach:
// Use modified binary search:
//      One side is always sorted.
//      Check which side target falls in.



// 👁️ Visualization:
// [4, 5, 6, 7, 0, 1, 2]
//         ↑
//     mid = 7
//     Left is sorted, right has pivot.
//     Check which half contains target.




public class RotatedBinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } 
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Index of target: " + search(nums, target));
    }
}


// 🖨️ Output:
// Index of target: 4


// ⏱️ Complexity:
// Time: O(log n)

// Space: O(1)

