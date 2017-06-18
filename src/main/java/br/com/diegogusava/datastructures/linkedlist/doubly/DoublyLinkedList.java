package br.com.diegogusava.datastructures.linkedlist.doubly;

public class DoublyLinkedList {

    public Node head;
    public Node tail;

    public void add(int value) {
        Node node = new Node(value);
        if (head != null) {
            head.previous = node;
        }
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    public boolean remove(int value) {
        Node current = head;

        while (current != null) {

            if (current.value == value) {

                Node parent = current.previous;
                Node next = current.next;

                //is the last element
                if (next == null) {
                    tail = current.previous;
                }

                //is the first node
                if (parent == null) {
                    head = current.next;
                    if (next != null) {
                        next.previous = null;
                    }
                } else {
                    current.previous = next;
                    if (next != null) {
                        next.previous = current.previous;
                    }
                }


                return true;
            } else {
                current = current.next;
            }


        }

        return false;

    }

}
