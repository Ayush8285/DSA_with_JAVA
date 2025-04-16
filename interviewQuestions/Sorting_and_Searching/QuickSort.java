package interviewQuestions.Sorting_and_Searching;

// ⚡ Problem  Name: Quick Sort



// 🧾 Problem Statement:
// Sort an array using the Quick Sort algorithm.



// 🧠 Approach:
// Choose pivot (last element).
// Partition array.
// Recursively sort partitions.




public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }

        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.print("Sorted array: ");
        for (int num : arr) System.out.print(num + " ");
    }
}


// 🖨️ Output:
// Sorted array: 1 5 7 8 9 10 


// ⏱️ Complexity:
// Best/Average Time: O(n log n)

// Worst Time: O(n²) (when pivot is worst case)

// Space: O(log n) (due to recursive stack)