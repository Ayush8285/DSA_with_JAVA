
//🔶  Problem  Name: Daily Temperatures



// 🔍 Problem
// Given a list of daily temperatures T, return a list where answer[i] 
// is the number of days until a warmer temperature. If none, put 0.



// 🧠 Approach (Monotonic Stack)
// Use a stack to store indexes of days.
// Traverse array from left to right.
// While stack is not empty and current temp > temp at stack top → pop and update the result.



// 📊 Visualization
// Input: [73, 74, 75, 71, 69, 72, 76, 73]

// Stack (stores index):
// [0] (73) → current = 74 > 73 → answer[0] = 1  
// [1] (74) → current = 75 > 74 → answer[1] = 1  
// [2] (75) → current = 71 → push  
// ...

// Output: [1, 1, 4, 2, 1, 1, 0, 0]



import java.util.*;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Days until warmer: " + Arrays.toString(dt.dailyTemperatures(input)));
    }
}


// ✅ Output
// Days until warmer: [1, 1, 4, 2, 1, 1, 0, 0]


// 📈 Time and Space Complexity
// Time: O(n)

// Space: O(n) — stack stores indices