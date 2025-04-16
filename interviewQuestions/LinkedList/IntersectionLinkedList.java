package interviewQuestions.LinkedList;

// 🔶  Problem  Name: Intersection of Two Linked Lists



// 🔍 Problem
// Find the node where two singly linked lists intersect. 
// Return the intersecting node or null if they don't intersect.



// 🧠 Approach
// Use two pointers a and b starting from headA and headB.
// Move both one step at a time.
// When a pointer reaches the end, redirect it to the start of the other list.
// If there’s an intersection, they'll meet at the same node.
// If no intersection, both will eventually become null.



// 📊 Example
// List A: 4 → 1 → 
//                  ↘
//                    8 → 4 → 5
//                  ↗
// List B:    5 → 0 → 1



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA, b = headB;

        // Traverse both lists
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // Will be null or intersection node
    }

    public static void main(String[] args) {
        // Common part: 8 → 4 → 5
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        // List A: 4 → 1 → [intersect]
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        // List B: 5 → 0 → 1 → [intersect]
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        IntersectionLinkedList ill = new IntersectionLinkedList();
        ListNode result = ill.getIntersectionNode(headA, headB);

        if (result != null)
            System.out.println("Intersection at node with value: " + result.val);
        else
            System.out.println("No intersection found.");
    }
}





// 📈 Time and Space Complexity
// Time: O(n + m) — traverses both lists fully once

// Space: O(1) — uses only two pointers