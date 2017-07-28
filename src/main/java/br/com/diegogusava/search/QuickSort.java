package br.com.diegogusava.search;

/**
 * - Not Stable: does not mantain the order of items with equals values
 * - In place: does not any additional memory
 * - On average: O(N log n)
 * - Worst case: O(n^2)
 * - Primitive types usually uses quicksort
 * - Reference/Objects types uses mergesort
 */
public class QuickSort {

    public static void sort(int[] values) {

        sort(values, 0, values.length - 1);

    }

    public static void sort(int[] values, int low, int high) {

        if (low >= high) {
            return;
        }

        int pivot = partition(values, low, high);

        //Pivot is sorted, so does not need to be sorted again
        sort(values, low, pivot - 1);
        sort(values, pivot + 1, high);

    }

    // 9 5 8 3 1
    // pivot = 8
    // 9 5 1 3 8
    // i = 1, j = 0; 9 5 1 3 8
    // i = 2, j = 1; 5 9 1 3 8
    // i = 3, j = 2; 5 1 9 3 8
    // i = 4, j = 3; 5 1 3 9 8
    // 5 1 3 8 9
    private static int partition(int[] values, int low, int high) {

        int pivot = low + (high - low / 2);

        swap(values, pivot, high);

        int p = low;

        for (int i = 0; i < high; i++) {
            if (values[i] <= values[high]) {
                swap(values, i, p);
                p++;
            }
        }

        swap(values, high, p);

        return pivot;
    }

    private static void swap(int[] values, int pivot, int high) {
        final int temp = values[pivot];
        values[pivot] = values[high];
        values[high] = temp;
    }

}
