package br.com.diegogusava.datastructures.queue;

public class QueueLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void enqueue(int value) {
        Node node = new Node(value);
        size++;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public Integer dequeue() {

        Node node = head;

        if (node == null) {
            return null;
        }

        Node next = node.getNext();
        if (next == null) {
            head = null;
            tail = null;
        } else {
            head = next;
        }

        size--;

        return node.getData();
    }

    public int getSize() {
        return size;
    }


}
