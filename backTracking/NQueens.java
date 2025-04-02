public class NQueens {
    private int[] queens;
    private int N;
 
    public NQueens(int N) {
        queens = new int[N];
        this.N = N;
    }
 
    public void placeNQueens() {
        if (placeQueen(0)) {
            printQueens();
        } else {
            System.out.println("No solution found");
        }
    }
 
    private boolean placeQueen(int col) {
        if (col == N) {
            return true; // All queens are placed successfully
        }
 
        for (int row = 0; row < N; row++) {
            if (canPlace(row, col)) {
                queens[col] = row; // Place queen
                if (placeQueen(col + 1)) { // Recurse; move to next column
                    return true; // Found a valid placement
                }
                // If no valid placement found, unplace current queen and backtrack
            }
        }
 
        return false; // No valid placement found for current column
    }
 
    private boolean canPlace(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (queens[i] == row || Math.abs(queens[i] - row) == Math.abs(i - col)) {
                return false; // Queen cannot be placed here
            }
        }
        return true; // It is safe to place the queen here
    }
 
    private void printQueens() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        NQueens nQueens = new NQueens(8);
        nQueens.placeNQueens();
    }
}


// Explanation

// public class NQueens { - Declares a public class named NQueens.

// private int[] queens; - Creates a private integer array queens to store the positions of the queens on the board.

// private int N; - Declares a private integer N to represent the size of the chessboard.

// public NQueens(int N) { - Defines the constructor of the NQueens class that takes an integer N as input to set the board size.

// queens = new int[N]; - Initializes the queens array with a size of N.

// this.N = N; - Sets the class’s instance variable N with the given input N to represent the board's size.

// public void placeNQueens() { - Declares a public method to initiate the process of placing the queens on the board.

// if (placeQueen(0)) { - Calls the placeQueen method starting with the first column; if it returns true, it proceeds.

// for (int i = 0; i < N; i++) { - A loop that iterates through each element of the queens array to print their positions.

// System.out.println("Queen at cell " + i + " is placed at " + queens[i]); - Prints the position where each queen is placed.

// } else { - Begins the else block, which executes if no solution was found for placing all queens.

// System.out.println("No solution found"); - Prints a message indicating that there is no solution.

// private boolean placeQueen(int col) { - Declares a private method that tries to place a queen in the specified column.

// if (col == N) { - Checks if all queens have been placed; if so, returns true.

// return true; - Returns true, indicating that all queens have been successfully placed.

// for (int row = 0; row < N; row++) { - A loop that iterates through each row to find a safe spot for the current queen.

// if (isSafe(row, col)) { - Calls the isSafe method to check if it’s safe to place a queen at the current row and column.

// queens[col] = row; - If it’s safe, places the queen at the current row of the specified column.

// if (placeQueen(col + 1)) { - Recursively calls placeQueen for the next column; if it returns true, it continues.

// return true; - If all queens are placed safely, returns true.

// queens[col] = 0; - If it fails to place a queen safely, it resets the current cell to 0 and backtracks.

// private boolean isSafe(int row, int col) { - Declares a private method to check if it's safe to place a queen at the current cell.

// for (int i = 0; i < col; i++) { - A loop that checks each column to the left of the current cell for threats.

// if (queens[i] == row || queens[i] - i == row - col || queens[i] + i == row + col) { - Checks if there’s any queen in the same row or diagonals that threatens the current cell.

// return false; - If the current cell is threatened, returns false.

// return true; - If the cell is safe for the queen, returns true.

