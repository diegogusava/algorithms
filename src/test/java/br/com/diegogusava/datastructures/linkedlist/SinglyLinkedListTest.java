package br.com.diegogusava.datastructures.linkedlist;

import br.com.diegogusava.datastructures.linkedlist.singly.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void addElements() {
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Assert.assertEquals(10, list.getSize());

    }

    @Test
    public void addElementsAndRemoveAllElements() {
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.remove(5);


        Assert.assertEquals(9, list.getSize());

    }

    @Test
    public void addAndRemove() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(5);
        boolean remove = list.remove(5);


        Assert.assertEquals(true, remove);
    }

    @Test
    public void addAndRemoveDifferentItem() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(5);
        boolean remove = list.remove(4);


        Assert.assertEquals(false, remove);
    }

    @Test
    public void removeElementEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();

        boolean remove = list.remove(5);


        Assert.assertEquals(false, remove);
    }

    @Test
    public void removeLastItem() {
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.remove(0);


        Assert.assertEquals(9, list.getSize());

        Assert.assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, list.toArray());
    }

    @Test
    public void removeFirstItem() {
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.remove(9);


        Assert.assertEquals(9, list.getSize());

        Assert.assertArrayEquals(new int[]{8, 7, 6, 5, 4, 3, 2, 1, 0}, list.toArray());
    }

    @Test
    public void removeRootAddNewRoot() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.remove(1);
        list.add(2);
        list.add(3);

        Assert.assertEquals(2, list.getSize());

        Assert.assertEquals(3, list.getRoot().getData());
        Assert.assertEquals(2, list.getRoot().getNext().getData());
    }


}
