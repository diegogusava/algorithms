package br.com.diegogusava.search;

public class BinarySearch {

    public int iterative(int[] array, int value) {
        return iterative(array, value, 0, array.length - 1);
    }

    public int iterative(int[] array, int value, int start, int end) {

        int middle = start + ((end - start) / 2);

        while (start <= end) {

            final int middleValue = array[middle];

            if (middleValue == value) {
                return middle;
            } else if (middleValue > value) { //left
                end = middle - 1;
            } else {
                start = middle + 1;
            }

            middle = start + ((end - start) / 2);
        }

        return -1;

    }


}
