package interviewQuestions.Recursion_and_Backtracking;

//🔶  Problem  Name: Rat in a Maze



// 🧾 Problem Statement:
// Given a N x N maze (2D grid) filled with 1s (path)
//  and 0s (walls), find all paths from top-left (0, 0) 
// to bottom-right (N-1, N-1) moving only in 4 directions: Down, Left, Right, Up.

// You can't visit the same cell twice in a path.



// 🧠 Approach:
// Use backtracking and recursion.
// Keep a visited matrix.
// At each step, explore all 4 directions.
// If reached (N-1, N-1), add path to result.



// 👁️ Visualization:
// maze = [
//   [1, 0, 0],
//   [1, 1, 0],
//   [0, 1, 1]
// ]

// Paths from (0,0) to (2,2):
// - D → D → R → R (path = "DDRR")




import java.util.*;

public class RatInMaze {
    static int[][] directions = {{1,0}, {0,-1}, {0,1}, {-1,0}}; // D, L, R, U
    static char[] dirChars = {'D', 'L', 'R', 'U'};

    public static List<String> findPaths(int[][] maze) {
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        List<String> result = new ArrayList<>();

        if (maze[0][0] == 1)
            backtrack(maze, 0, 0, "", visited, result);
        return result;
    }

    private static void backtrack(int[][] maze, int x, int y, String path, boolean[][] visited, List<String> result) {
        int n = maze.length;

        if (x == n - 1 && y == n - 1) {
            result.add(path);
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            if (isSafe(newX, newY, maze, visited)) {
                backtrack(maze, newX, newY, path + dirChars[i], visited, result);
            }
        }

        visited[x][y] = false; // backtrack
    }

    private static boolean isSafe(int x, int y, int[][] maze, boolean[][] visited) {
        int n = maze.length;
        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1 && !visited[x][y]);
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0},
            {1, 1, 0},
            {0, 1, 1}
        };

        List<String> paths = findPaths(maze);
        System.out.println("Possible paths from start to end:");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}


// 🖨️ Output:
// Possible paths from start to end:
// DDRR


// ⏱️ Time & Space Complexity:
// Time: O(4^(N*N)) in worst case (every cell → 4 directions)

// Space: O(N*N) for visited array and recursion
