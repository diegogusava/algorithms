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
        for (int i = low; i <= high; i++) {
            temp[i] = values[i];
        }

        int indexLeftSubArray = low;
        int indexRightSubArray = middle + 1;
        int indexTempArray = low;

        while (indexLeftSubArray <= middle && indexRightSubArray <= high) {

            if (temp[indexLeftSubArray] <= temp[indexRightSubArray]) {
                values[indexTempArray] = temp[indexLeftSubArray];
                indexLeftSubArray++;
            } else {
                values[indexTempArray] = temp[indexRightSubArray];
                indexRightSubArray++;
            }

            indexTempArray++;
        }

        while (indexLeftSubArray <= middle) {
            values[indexTempArray] = temp[indexLeftSubArray];
            indexLeftSubArray++;
            indexTempArray++;
        }

        while (indexRightSubArray <= high) {
            values[indexTempArray] = temp[indexRightSubArray];
            indexRightSubArray++;
            indexTempArray++;
        }

    }
}
