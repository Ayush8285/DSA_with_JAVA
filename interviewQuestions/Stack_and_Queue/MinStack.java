
//🔶  Problem  Name: Min Stack



// 🔍 Problem
// Design a stack that supports push, pop, top, and getMin in constant time O(1).



// 🧠 Approach
// Use two stacks:
//      mainStack: stores all elements
//      minStack: stores the minimum so far at each point
//      When you push(x), push x to mainStack.Also push min(x, minStack.peek()) to minStack.
//      When popping, pop both stacks.


// 📊 Visualization
// Push(5) → main: [5], min: [5]  
// Push(3) → main: [5, 3], min: [5, 3]  
// Push(7) → main: [5, 3, 7], min: [5, 3, 3]  
// getMin() → 3
// pop()    → main: [5, 3], min: [5, 3]



import java.util.*;

public class MinStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            mainStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        System.out.println("Minimum: " + stack.getMin()); // 3
        stack.pop();
        System.out.println("Top: " + stack.top()); // 3
        System.out.println("Minimum: " + stack.getMin()); // 3
    }
}



// ✅ Output
// Minimum: 3
// Top: 3
// Minimum: 3



// 📈 Time and Space Complexity
// Time: O(1) for all operations

// Space: O(n) for storing elements and their min states