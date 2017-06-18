package br.com.diegogusava.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueLinkedListTest {

    private QueueLinkedList queue;

    @Before
    public void setUp() {
        queue = new QueueLinkedList();
    }

    @Test
    public void enqueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.getSize());
    }

    @Test
    public void dequeueEmptyQueue() {

        Integer result = queue.dequeue();
        assertEquals(null, result);
        assertEquals(0, queue.getSize());
    }

    @Test
    public void queueOrder() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);


        assertEquals(new Integer(1), queue.dequeue());
        assertEquals(new Integer(2), queue.dequeue());
        assertEquals(new Integer(3), queue.dequeue());
        assertEquals(null, queue.dequeue());
        assertEquals(0, queue.getSize());
    }

    @Test
    public void enqueueAndDequeue() {
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.getSize());
        queue.dequeue();
        assertEquals(new Integer(2), queue.dequeue());
    }

}