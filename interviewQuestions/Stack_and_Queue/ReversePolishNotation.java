
//🔶  Problem  Name: Evaluate Reverse Polish Notation



// 🔍 Problem
// Evaluate an expression in Reverse Polish Notation.
// Example: ["2", "1", "+", "3", "*"] → ((2 + 1) * 3) = 9



// 🧠 Approach (Stack)
// For every token:
//      If number → push to stack
//      If operator → pop two, apply operator, push result





// 📊 Visualization
// Input: ["2", "1", "+", "3", "*"]
// → Stack: [2] → [2,1] → [3] → [3,3] → [9]




import java.util.*;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        String[] expr = {"2", "1", "+", "3", "*"};
        System.out.println("Result: " + rpn.evalRPN(expr));
    }
}


// ✅ Output
// Result: 9

// 📈 Time and Space Complexity
// Time: O(n)

// Space: O(n) — for stack

