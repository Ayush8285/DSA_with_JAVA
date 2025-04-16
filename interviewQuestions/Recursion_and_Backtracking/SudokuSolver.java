package interviewQuestions.Recursion_and_Backtracking;

//🔶  Problem  Name: Sudoku Solver



// 📘 Problem Statement
// Write a program to solve a Sudoku puzzle by filling the empty cells.
// A sudoku solution must satisfy:
//      Each row contains digits 1-9 with no repetition.
//      Each column contains digits 1-9 with no repetition.
//      Each of the nine 3x3 sub-boxes must also contain digits 1-9.
// Empty cells are filled with the character '.'.



// 🧠 Approach
// Use backtracking to try placing digits 1-9 in each empty cell.
// Before placing, check if the digit is valid for the row, column, and box.
// If placing a digit leads to a dead end, backtrack and try another digit.
// Once the board is filled, we have a valid solution.



// 🔍 Visualization (Partial)
// Suppose board:
// 5 3 . | . 7 . | . . .
// 6 . . | 1 9 5 | . . .
// . 9 8 | . . . | . 6 .
// Try filling the first . by trying 1-9 → validate → backtrack if needed → continue to next ..



public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (backtrack(board)) return true;

                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number
                }

            }
        }
        return true; // completely filled
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // check row
            if (board[row][i] == num) return false;
            // check column
            if (board[i][col] == num) return false;
            // check 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Original board:");
        printBoard(board);

        solver.solveSudoku(board);

        System.out.println("\nSolved board:");
        printBoard(board);
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}




// 🖥️ Output
// Original board:
// 5 3 . . 7 . . . . 
// 6 . . 1 9 5 . . . 
// . 9 8 . . . . 6 . 
// 8 . . . 6 . . . 3 
// 4 . . 8 . 3 . . 1 
// 7 . . . 2 . . . 6 
// . 6 . . . . 2 8 . 
// . . . 4 1 9 . . 5 
// . . . . 8 . . 7 9 

// Solved board:
// 5 3 4 6 7 8 9 1 2 
// 6 7 2 1 9 5 3 4 8 
// 1 9 8 3 4 2 5 6 7 
// 8 5 9 7 6 1 4 2 3 
// 4 2 6 8 5 3 7 9 1 
// 7 1 3 9 2 4 8 5 6 
// 9 6 1 5 3 7 2 8 4 
// 2 8 7 4 1 9 6 3 5 
// 3 4 5 2 8 6 1 7 9 


// 📈 Complexity
// Time: O(9^(n*n)) → In worst case, try all digits at every empty cell

// Space: O(1) extra (board in-place), O(N^2) recursion stack in worst case