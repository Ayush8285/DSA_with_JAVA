package interviewQuestions.Recursion_and_Backtracking;

//🔶  Problem  Name:  N-Queens Problem



// 📘 Problem Statement
// The N-Queens problem is the challenge of placing n chess queens on an n x n chessboard so that no two queens threaten each other.
// A queen can attack horizontally, vertically, and diagonally.



// 🧠 Approach
// We use backtracking, placing one queen per row.
// For each cell, we check if placing a queen is safe:
//      No other queen in the same column
//      No other queen in the diagonals
// If it’s safe, we place the queen and move to the next row.
// If placing leads to a dead-end, we backtrack.




// 🔍 Visualization (4x4 Example)
// . Q . .        . . Q .        . . . Q
// . . . Q        . . . .        Q . . .
// Q . . .        Q . . .        . . Q .
// . . Q .        . Q . .        . Q . .
// Valid board positions marked with Q for queens and . for empty.




import java.util.*;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        backtrack(board, 0, solutions);
        return solutions;
    }

    private void backtrack(char[][] board, int row, List<List<String>> solutions) {
        if (row == board.length) {
            solutions.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, solutions);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        // check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        // check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board)
            result.add(new String(row));
        return result;
    }

    public static void main(String[] args) {
        NQueens obj = new NQueens();
        int n = 4;
        List<List<String>> results = obj.solveNQueens(n);

        System.out.println("Solutions to " + n + "-Queens problem:");
        for (List<String> sol : results) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println(); // separate boards
        }
    }
}



// 🖥️ Sample Output (for n = 4):
// Solutions to 4-Queens problem:
// .Q..
// ...Q
// Q...
// ..Q.

// ..Q.
// Q...
// ...Q
// .Q..

// 📈 Complexity
// Time: O(N!) — We try placing queens in all columns for each row.

// Space: O(N^2) — For the board and call stack.