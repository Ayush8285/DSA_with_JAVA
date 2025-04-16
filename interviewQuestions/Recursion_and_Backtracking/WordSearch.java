package interviewQuestions.Recursion_and_Backtracking;

//🔶  Problem  Name: Word Search in Grid



// 📘 Problem Statement
// Given a 2D board and a word, return true if the word exists in the grid.
// The word can be constructed from letters of sequentially
//  adjacent cells (horizontally or vertically), same cell may not be reused.

// Example:
// Input: board = [["A","B","C","E"],
//                 ["S","F","C","S"],
//                 ["A","D","E","E"]], word = "ABCCED"

// Output: true



// 🧠 Approach
// Start DFS from each cell.
// If character matches the word, explore all 4 directions (up, down, left, right).
// Use a visited flag or temporarily modify the grid.
// Backtrack by resetting the visited cell.



// 🔍 Visualization
// For word = "ABCCED":
// A → B → C → C → E → D
// ✓ Matches path in grid



public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        boolean found = dfs(board, i + 1, j, word, index + 1) ||
                        dfs(board, i - 1, j, word, index + 1) ||
                        dfs(board, i, j + 1, word, index + 1) ||
                        dfs(board, i, j - 1, word, index + 1);

        board[i][j] = temp; // backtrack

        return found;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();

        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        String word = "ABCCED";

        System.out.println("Does the word '" + word + "' exist in the board?");
        System.out.println(ws.exist(board, word));  // true
    }
}


// 🖥️ Output
// Does the word 'ABCCED' exist in the board?
// true



// 📈 Complexity
// Time: O(m × n × 4^L), where L = length of word

// Space: O(L) for recursion depth