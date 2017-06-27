package br.com.diegogusava.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void test() {
        BinarySearch bs = new BinarySearch();

        int len = 10;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = i;
        }

        final int inde1x = bs.iterative(a, 4);

        for (int i = 0; i < len; i++) {
            final int index = bs.iterative(a, i);
            System.out.println(i + " -> " + index);
            assertEquals(i, index);
        }

    }


}