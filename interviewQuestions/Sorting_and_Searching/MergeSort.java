package interviewQuestions.Sorting_and_Searching;

// ⚡ Problem  Name: Merge Sort



// 🧾 Problem Statement:
// Sort an array using the Merge Sort algorithm (Divide & Conquer).


// 🧠 Approach:
// Divide array into halves.
// Recursively sort both halves.
// Merge them.



public class MergeSort {
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.print("Sorted array: ");
        for (int num : arr) System.out.print(num + " ");
    }
}

// 🖨️ Output:
// Sorted array: 5 6 7 11 12 13 



// ⏱️ Complexity:
// Time: O(n log n)

// Space: O(n) (uses temporary arrays)