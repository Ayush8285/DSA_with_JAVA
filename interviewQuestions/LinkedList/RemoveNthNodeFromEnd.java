package interviewQuestions.LinkedList;

// 🔶 Problem Name: Remove N-th Node from End of a Linked List



// 🔶 Problem Statement:
// Given the head of a linked list and an integer n,
//  remove the n-th node from the end of the list and return its head.



// 🧠 Thought Process:
// Two-pointer technique:
//      Use two pointers, first and second, to locate the N-th node from the end.
//      Move first pointer n steps ahead.
//      Then, move both pointers (one step at a time) until first reaches the end of the list.
//      The second pointer will now point to the node just before the one that needs to be removed.
// Edge cases:
//      When the list has only one node.
//      When the node to be removed is the head itself.




// 🔍 Visualization:
// --For a list 1 → 2 → 3 → 4 → 5, and n = 2:
// --Initially, both first and second are at the start.
// --Move first by n steps → first will be at node 3.
// --Move both first and second together until first reaches the end. Now, 
// second will be at node 3, which is the node before the one to remove (4).

// After removing the N-th node, the list will become: 1 → 2 → 3 → 5.


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class RemoveNthNodeFromEnd {

    // Function to remove the N-th node from the end
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead so that the gap between first and second is n
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move both first and second pointers one step at a time
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // second now points to the node before the one to remove
        second.next = second.next.next;

        // Return the head of the modified list
        return dummy.next;
    }

    // Helper to print the linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthNodeFromEnd remover = new RemoveNthNodeFromEnd();
        System.out.print("Original List: ");
        remover.printList(head);

        // Remove the 2nd node from the end (which is node 4)
        ListNode modifiedHead = remover.removeNthFromEnd(head, 2);
        System.out.print("Modified List: ");
        remover.printList(modifiedHead);
    }
}


// 🕒 Time Complexity: O(n)
// We are making a constant number of passes through the list, 
// so it is linear in terms of the number of nodes.

// 📦 Space Complexity: O(1)
// We only use a constant amount of extra space (the dummy node and two pointers)
