
//🔶  Problem  Name: Next Greater Element



// 🔍 Problem
// Given an array, find the next greater element for every element. If none, return -1.



// 🧠 Approach
// Use a monotonic stack (decreasing stack):
// --Traverse array from right to left.
// --While stack not empty and top ≤ current, pop.
// --If stack is empty → result is -1
//   Else → top of stack is next greater




// 📊 Visualization
// Input: [2, 1, 2, 4, 3]
// Stack Trace (Right → Left):
// → 3   → stack = [3], result = -1
// → 4   → stack = [4], result = -1
// → 2   → stack = [4, 2], result = 4
// → 1   → stack = [4, 2, 1], result = 2
// → 2   → stack = [4, 2], pop(1), result = 4
// Output: [4, 2, 4, -1, -1]



import java.util.*;

public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from end
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] nums = {2, 1, 2, 4, 3};
        int[] result = nge.nextGreaterElements(nums);
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}


// ✅ Output
// Next Greater Elements: [4, 2, 4, -1, -1]


// 📈 Time and Space Complexity
// Time: O(n)

// Space: O(n) for stack and result array