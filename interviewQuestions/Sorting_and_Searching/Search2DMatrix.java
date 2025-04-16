package interviewQuestions.Sorting_and_Searching;

// ⚡ Problem  Name: Search in a 2D Matrix



// 🧾 Problem Statement:
// Given an m x n matrix where each row is sorted and 
// first integer of each row is greater than the last integer 
// of the previous row, return true if the target is in the matrix.

// Example:
// Input:
// matrix = [
//   [1, 3, 5, 7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 60]
// ], target = 3
// Output: true



// 🧠 Approach:
// ✅ Binary Search on 1D index:
//      Treat the matrix as a 1D array of size m * n
//      Convert mid index to row/column with:
//              row = mid / n, col = mid % n




public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target) return true;
            else if (midVal < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println("Is target in matrix? " + searchMatrix(matrix, target));
    }
}



// 🖨️ Output:
// Is target in matrix? true


// ⏱️ Complexity:
// Time: O(log (m * n))

// Space: O(1)
