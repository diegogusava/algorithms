package br.com.diegogusava.search;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void sort() throws Exception {
        final int[] values = { 7, 3, 4, 9, 15 };
        MergeSort.sort(values);

        Arrays.stream(values).forEach(System.out::println);
    }

}
