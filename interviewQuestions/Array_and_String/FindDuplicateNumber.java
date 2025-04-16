package interviewQuestions.Array_and_String;

// 🔷 Problem Name: Find Duplicate Number

// 🔶 Problem Statement:
// Given an array nums containing n + 1 integers where each integer
//  is in the range [1, n], find the duplicate number (only one duplicate).


// 🔷 Approach (Floyd’s Tortoise and Hare):
// Use slow and fast pointers to detect a cycle (like Linked List cycle).

// Phase 1: Detect intersection point.

// Phase 2: Move both from start and intersection to find the entry point = duplicate.


public class FindDuplicateNumber {
    
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entry point (duplicate)
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    public static void main(String[] args) {
        FindDuplicateNumber fd = new FindDuplicateNumber();
        int result = fd.findDuplicate(new int[] {1, 3, 4, 2, 2});
        System.out.println("Duplicate Number: " + result); // Output: 2
    }
}


// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(1)
