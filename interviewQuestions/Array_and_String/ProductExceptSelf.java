package interviewQuestions.Array_and_String;

// 🔷 Problem Name: Product of Array Except Self

// 🔶 Problem Summary:
// Given an array, return a new array where each element at index
//  i is the product of all elements except nums[i].

// Constraints:
//      Do it in O(n) time
//      No division allowed
//      Constant space (besides the result)


// 🧠 Thought Process:
// 1. For each position i, we want:
//      output[i] = product of elements before i * product of elements after i

// 2. Compute this in two passes:
//      Left Pass: left[i] = product of all elements before i
//      Right Pass: update output array by multiplying with right product from the end



// ✅ Detailed Steps:
// --Initialize output array with 1
// --Left pass:
//      output[i] = output[i - 1] * nums[i - 1]
// --Right pass:
//      Track a right product
//      output[i] *= right and update right *= nums[i]


// 🔍 Dry Run:
// Input: [1, 2, 3, 4]
// Left pass → [1, 1, 2, 6]
// Right pass → Multiply with [24, 12, 8, 6]
// Answer: [24, 12, 8, 6]


public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Step 1: Build prefix product (left)
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Step 2: Build suffix product (right) in reverse
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * right;
            right *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = pes.productExceptSelf(nums);

        for (int val : result)
            System.out.print(val + " ");  // Output: 24 12 8 6
    }
}


// ✅ Time Complexity: O(n)
// ✅ Space Complexity: O(1) (excluding output array)
