
// 🔶  Problem  Name: Valid Parentheses



// 🔍 Problem
// Given a string containing '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// A string is valid if:
//      Open brackets are closed by the same type of brackets.
//      Open brackets are closed in the correct order.



// 🧠 Approach
// Use a stack to track opening brackets.
// For every closing bracket, check if the top of the stack is the matching opening bracket.
// If yes, pop it. If not, return false.
// At the end, if the stack is empty → ✅ valid string.



// 📊 Visualization
// Input: "{[()]}"
// Stack state:

// Push {   → stack = {  
//     Push [   → stack = { [  
//     Push (   → stack = { [ (  
//     Pop (    → stack = { [  
//     Pop [    → stack = {  
//     Pop {    → stack = [empty]  
//     ✅ Valid
    



import java.util.*;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();

        String input = "{[()]}";
        boolean result = vp.isValid(input);
        System.out.println("Is Valid? " + result);
    }
}



// 📈 Time and Space Complexity
// Time: O(n) — one pass through string

// Space: O(n) — stack holds up to all characters in worst case