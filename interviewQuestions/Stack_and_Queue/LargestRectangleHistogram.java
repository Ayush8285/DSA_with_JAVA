
//🔶  Problem  Name:  Largest Rectangle in Histogram



// 🔍 Problem
// Given heights[] representing bars of a histogram, find the area of the largest rectangle.



// 🧠 Approach (Monotonic Stack)
// Use a stack to keep indexes of increasing heights.
// For each bar, if current bar is lower than stack top:
//      Pop from stack and calculate area.
// Do this until the end, adding a 0 at the end to flush the stack.



// 📊 Visualization
// Input: [2,1,5,6,2,3]

// Index 2 & 3 → form height=5/6, width=2 → area=10  
// Final Max Area = 10



import java.util.*;
import java.util.Stack;

public class LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleHistogram lrh = new LargestRectangleHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + lrh.largestRectangleArea(heights));
    }
}


// ✅ Output
// Largest Rectangle Area: 10


// 📈 Time and Space Complexity
// Time: O(n)

// Space: O(n) — stack

