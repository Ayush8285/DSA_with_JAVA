package interviewQuestions.LinkedList;

// 🔶 Problem Name: Detect Cycle in a Linked List (Floyd’s Tortoise and Hare)



// 🔶 Problem:
// Determine if a linked list contains a cycle (loop). If so, return true.



// 🧠 Thought Process:
// Use two pointers:
//      slow moves one step at a time
//      fast moves two steps
// If a cycle exists, they will eventually meet.
// If no cycle, fast will hit null.



// ✅ Approach (Floyd’s Cycle Detection Algorithm):
// Start both slow and fast at the head
// While fast != null and fast.next != null:
//      slow = slow.next
//      fast = fast.next.next
//      If slow == fast, there is a cycle

// 🔍 Visualization:
// 1 → 2 → 3 → 4
//      ↑       ↓
//      ← ← ← ←  


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkedListCycle {

    // Detect cycle using Floyd's algorithm
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // 1 step
            fast = fast.next.next;      // 2 steps

            if (slow == fast) return true; // cycle detected
        }

        return false;
    }

    // Main method to test
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // create a cycle

        LinkedListCycle llc = new LinkedListCycle();
        boolean result = llc.hasCycle(node1);
        System.out.println("Cycle detected? " + result); // Should print true
    }
}




// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(1)