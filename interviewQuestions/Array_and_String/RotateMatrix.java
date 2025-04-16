package interviewQuestions.Array_and_String;

// 🔷 Problem Name: Rotate Matrix (90 Degrees Clockwise)



// 🔶 Problem Summary:
// You're given an n x n matrix (2D array), 
// and you need to rotate it 90° clockwise in-place, 
// meaning no extra space is allowed for another matrix.



// 🧠 Thought Process:
// Visualize the rotation:
//      Each element at position (i, j) moves to (j, n - 1 - i) in the rotated matrix.
// Challenge: How can we rotate without creating a new matrix?
// Breakdown rotation into two steps:
//      Transpose the matrix:
//              This flips it over its diagonal.
//              (i, j) becomes (j, i)
//      Reverse each row:
//              After transposing, rows need to be reversed to match 90° clockwise rotation.



// ✅ Detailed Steps:
// Transpose:
//      Swap elements at (i, j) with (j, i) for all i < j
// Reverse rows:
//      Swap elements from start to end of each row



// 🔍 Dry Run:
// Matrix:
//      1 2 3       Step 1 (Transpose):       1 4 7      Step 2 (Reverse rows):  7 4 1
//      4 5 6   =>                            2 5 8   =>                          8 5 2
//      7 8 9                                 3 6 9                              9 6 3



public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose (swap across the diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    private void reverseRow(int[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left++] = row[right];
            row[right--] = temp;
        }
    }

    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rm.rotate(matrix);
        for (int[] row : matrix)
            System.out.println(java.util.Arrays.toString(row));
        // Output: [7, 4, 1], [8, 5, 2], [9, 6, 3]
    }
}



// ✅ Time Complexity: O(n²)
// ✅ Space Complexity: O(1) (in-place)