package br.com.diegogusava.datastructures.linkedlist.doubly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by diegogusava on 4/10/17.
 */
public class DoublyLinkedListTest {

    private DoublyLinkedList list;

    @Before
    public void setup() throws Exception {
        list = new DoublyLinkedList();
    }

    @Test
    public void add() throws Exception {

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        assertEquals(40, list.head.value);
        assertEquals(10, list.tail.value);

    }

    @Test
    public void remove1() throws Exception {
        list.add(10);
        list.remove(10);
        assertEquals(null, list.head);
        assertEquals(null, list.tail);
    }

    @Test
    public void remove2() throws Exception {
        list.add(10);
        list.add(20);
        list.remove(10);

        assertEquals(20, list.head.value);
        assertEquals(20, list.tail.value);
    }



}