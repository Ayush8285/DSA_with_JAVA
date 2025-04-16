package interviewQuestions.LinkedList;

// 🔶 Problem Name: Merge Two Sorted Linked Lists



// 🔶 Problem Statement:
// You are given the heads of two sorted linked lists.
// You need to merge them into a single sorted linked list and return the new head.



// 🧠 Thought Process:
// This is similar to merging two arrays:
// Start with a dummy node to simplify operations.
// Use a pointer (current) to build the new list.
// Compare the current nodes of both lists:
//      Append the smaller one to the merged list.
//      Move the pointer in that list.
// When one list ends, append the rest of the other list.



// 🔍 Example:
// List 1: 1 -> 3 -> 5
// List 2: 2 -> 4 -> 6
// Merged: 1 -> 2 -> 3 -> 4 -> 5 -> 6



class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MergeSortedLists {

    // Merge function
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Merge nodes one by one from both lists
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;  // attach l1 node
                l1 = l1.next;
            } else {
                current.next = l2;  // attach l2 node
                l2 = l2.next;
            }
            current = current.next;
        }

        // If any list still has nodes, attach it
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        // Return the merged list starting from dummy.next
        return dummy.next;
    }

    // Helper to print a linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        // First sorted list: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // Second sorted list: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        MergeSortedLists merger = new MergeSortedLists();

        System.out.print("List 1: ");
        merger.printList(l1);
        System.out.print("List 2: ");
        merger.printList(l2);

        ListNode merged = merger.mergeTwoLists(l1, l2);
        System.out.print("Merged List: ");
        merger.printList(merged);
    }
}


// 🕒 Time Complexity: O(n + m)
// Merging takes one pass through each list.

// 📦 Space Complexity: O(1)
// Done in-place (no extra memory used except the dummy node pointer).
