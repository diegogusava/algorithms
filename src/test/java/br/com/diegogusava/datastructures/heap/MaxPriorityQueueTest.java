package br.com.diegogusava.datastructures.heap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxPriorityQueueTest {


    private MaxPriorityQueue queue;

    @Before
    public void setUp() throws Exception {
        queue = new MaxPriorityQueue(10);
    }

    @Test
    public void insert() throws Exception {
        queue.insert(100);
        queue.insert(200);
        queue.insert(50);
        queue.insert(75);
        queue.insert(500);
        assertEquals(5, queue.getSize());
    }

    @Test
    public void max() throws Exception {
        queue.insert(100);
        queue.insert(200);
        queue.insert(50);
        queue.insert(75);
        queue.insert(500);

        assertEquals(500,queue.extract());
        assertEquals(200,queue.extract());
        assertEquals(100,queue.extract());
        assertEquals(75,queue.extract());
        assertEquals(50,queue.extract());
    }

    @Test
    public void max2() throws Exception {
        queue.insert(100);
        assertEquals(100,queue.extract());

    }
}