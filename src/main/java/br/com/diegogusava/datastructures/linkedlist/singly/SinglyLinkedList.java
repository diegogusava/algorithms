package br.com.diegogusava.datastructures.linkedlist.singly;

public class SinglyLinkedList {

    private Node root;
    private int size;

    public void add(int data) {
        if (root == null) {
            this.root = new Node(data);
        } else {
            Node node = new Node(data);
            node.setNext(this.root);
            this.root = node;
        }

        size++;
    }

    public boolean remove(int data) {

        Node previous = null;
        Node current = root;

        while (current != null) {

            if (current.getData() == data) {
                if (previous == null) {
                    this.root = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return true;
            } else {
                previous = current;
                current = current.getNext();
            }

        }

        return false;
    }

    public int[] toArray() {

        int[] array = new int[size];
        int i = 0;

        Node current = root;

        while (current != null) {
            array[i++] = current.getData();
            current = current.getNext();
        }

        return array;
    }

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

}
