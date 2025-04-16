
// 🔶  Problem  Name: Implement Stack using Queues 



// 🔍 Problem
// Use two queues to implement a stack with push, pop, top, and empty operations.



// 🧠 Approach
// There are 2 ways to do this. Here, we make push() expensive:
//      Push new element to q2.
//      Move all elements from q1 to q2.
//      Swap q1 and q2.
// Now q1 always has the newest element at front, so pop() and top() are O(1).



// 📊 Visualization
// Push(1)
// q1 = [1]
// Push(2)
//      Move 1 to q2, then push 2
//      Swap → q1 = [2, 1]
// Pop() → 2



import java.util.*;
import java.util.LinkedList;

public class StackUsingQueues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        q2.add(x); // Step 1
        while (!q1.isEmpty()) {
            q2.add(q1.remove()); // Step 2: move all to q2
        }
        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the element on top of the stack
    public int pop() {
        return q1.remove();
    }

    // Get the top element
    public int top() {
        return q1.peek();
    }

    // Check if stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(10);
        stack.push(20);
        System.out.println("Top element: " + stack.top()); // 20
        stack.pop();
        System.out.println("Top after pop: " + stack.top()); // 10
        System.out.println("Is empty? " + stack.empty()); // false
    }
}

// ✅ Output
// Top element: 20
// Top after pop: 10
// Is empty? false





// Time and Space Complexity
// Time:
// push() → O(n) (moving elements)
// pop(), top() → O(1)

// Space: O(n) — queues store elements