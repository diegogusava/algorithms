package br.com.diegogusava.search;

/**
 * - Stable: mantain the order of items with equals values
 * - Not in place: need additional memory
 * - On average: O(N log n)
 */
public class MergeSort {

    public static void sort(int[] values) {
        sort(values, new int[values.length], 0, values.length - 1);
    }


    public static void sort(int[] values, int[] temp, int low, int high) {

        if (low >= high) {
            return;
        }

        int middle = low + ((high - low) / 2);

        sort(values, temp, low, middle);
        sort(values, temp, middle + 1, high);
        merge(values, temp, low, middle, high);

    }

    private static void merge(int[] values, int[] temp, int low, int middle, int high) {

        //Copy the numbers that will be comparated
        for (int i = low; i < high; i++) {
            temp[i] = values[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (temp[i] < temp[j]) {
                values[k] = temp[i];
                i++;
            } else {
                values[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            values[k] = values[i];
            i++;
            k++;
        }

        while (j <= high) {
            values[k] = values[j];
            j++;
            k++;
        }

    }
}
