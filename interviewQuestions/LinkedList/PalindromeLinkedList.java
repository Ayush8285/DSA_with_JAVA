package interviewQuestions.LinkedList;


// 🔶 Problem Name : Palindrome Linked List



// 🔍 Problem 
// Check if a singly linked list is a palindrome (reads the same forward and backward).



// 🧠 Approach
// Find the middle of the linked list using fast and slow pointers.
// Reverse the second half of the list in place.
// Compare the first half and the reversed second half.
// If all corresponding nodes are equal → it's a palindrome.



// 📊 Example
// Input:  1 → 2 → 2 → 1
// Middle:     ↑ slow
// Reverse:      1 → 2
// Compare:   1 == 1, 2 == 2 ✅ → Palindrome


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle of list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode prev = null;
        while (slow != null) {
            ListNode nextTemp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextTemp;
        }

        // Step 3: Compare both halves
        ListNode left = head;
        ListNode right = prev;
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindromeLinkedList pll = new PalindromeLinkedList();
        boolean result = pll.isPalindrome(head);
        System.out.println("Is Palindrome? " + result);
    }
}




// 📈 Time and Space Complexity
// Time: O(n) — one pass to find mid, one to reverse, one to compare

// Space: O(1) — no extra data structures used


