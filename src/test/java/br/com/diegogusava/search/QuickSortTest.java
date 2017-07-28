package br.com.diegogusava.search;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by diegogusava on 7/16/17.
 */
public class QuickSortTest {
    @Test
    public void sort() throws Exception {
        final int[] values = {5, 1, 3, 9, 8};
        QuickSort.sort(values);

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

}