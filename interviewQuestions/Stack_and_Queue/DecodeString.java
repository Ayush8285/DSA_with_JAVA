
//🔶  Problem  Name: Decode String



// 🔍 Problem
// Decode an encoded string.
// Example: s = "3[a2[c]]" → Output: "accaccacc"



// 🧠 Approach (Stack)
// Use two stacks:
//      One for numbers
//      One for characters
// On ], pop and build string and repeat it based on number popped.



// 📊 Visualization
// "3[a2[c]]"
// → Stack builds:  
// "c" → "cc" → "acc" → "accaccacc"



import java.util.*;
import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(curr.toString());
                num = 0;
                curr = new StringBuilder();
            } else if (ch == ']') {
                int repeat = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for (int i = 0; i < repeat; i++) {
                    temp.append(curr);
                }
                curr = temp;
            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String encoded = "3[a2[c]]";
        System.out.println("Decoded String: " + ds.decodeString(encoded));
    }
}

// ✅ Output
// Decoded String: accaccacc


// 📈 Time and Space Complexity
// Time: O(n * k) — k = max repeat count

// Space: O(n) — stacks and string building