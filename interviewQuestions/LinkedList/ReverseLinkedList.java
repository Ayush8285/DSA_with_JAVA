package interviewQuestions.LinkedList;

// 🔶 Problem Name: Reverse a Linked List



// 🔶 Problem:
// Given the head of a singly linked list, reverse the list and return the new head.



// 🧠 Thought Process:
// We need to reverse the links, so every node's next pointer
//  points to the previous node instead of the next one.



// ✅ Approach (Iterative):
// Initialize:
//      prev = null
//      current = head
// While current != null:
//      Store next → current.next
//      Reverse link → current.next = prev
//      Move prev and current one step forward
// At the end, prev will be the new head.



// 🔍 Visualization:
// Before: 1 → 2 → 3 → 4 → null  
// After:  null ← 1 ← 2 ← 3 ← 4


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseLinkedList {

    // Reverses the linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // store next
            curr.next = prev;              // reverse link
            prev = curr;                   // move prev
            curr = nextNode;               // move curr
        }

        return prev;
    }

    // Helper to print list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ReverseLinkedList rll = new ReverseLinkedList();
        System.out.print("Original List: ");
        rll.printList(head);

        ListNode reversedHead = rll.reverseList(head);
        System.out.print("Reversed List: ");
        rll.printList(reversedHead);
    }
}


// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(1) (in-place)
