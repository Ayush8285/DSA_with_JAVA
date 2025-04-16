
//🔶  Problem  Name: Implement Queue using Stacks



// 🔍 Problem
// Design a queue using two stacks that supports:
//      push(x): Add to back of queue
//      pop(): Remove from front
//      peek(): Get front
//      empty(): Check if empty



// 🧠 Approach
// Use two stacks:
//      inStack: for enqueue (push)
//      outStack: for dequeue (pop/peek)
// Key idea:
//      When we need to pop or peek, and outStack is empty → move all elements from inStack to outStack (reverses order).
// This ensures FIFO behavior using LIFO stacks.



// 📊 Visualization
// push(1) → inStack: [1]  
// push(2) → inStack: [1, 2]

// pop() →  
// - outStack is empty → move inStack to outStack → outStack: [2, 1]
// - pop() → 1 ✅

// peek() → 2 ✅



import java.util.*;
import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    // Push element to the back
    public void push(int x) {
        inStack.push(x);
    }

    // Pop element from the front
    public int pop() {
        shiftStacks();
        return outStack.pop();
    }

    // Peek at the front element
    public int peek() {
        shiftStacks();
        return outStack.peek();
    }

    // Check if queue is empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Helper to transfer elements if needed
    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.push(1);
        queue.push(2);
        System.out.println("Front element: " + queue.peek()); // 1
        System.out.println("Removed element: " + queue.pop()); // 1
        System.out.println("Is queue empty? " + queue.empty()); // false
    }
}


// ✅ Output
// Front element: 1
// Removed element: 1
// Is queue empty? false


// 📈 Time and Space Complexity
// Time:
//      push() → O(1)
//      pop() / peek() → Amortized O(1) (because each element is moved once between stacks)
// Space: O(n) — for storing elements in the two stacks