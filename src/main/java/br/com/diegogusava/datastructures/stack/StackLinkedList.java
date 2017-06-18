package br.com.diegogusava.datastructures.stack;

public class StackLinkedList {

    private int size;
    private Node root;

    public void push(Integer value) {
        if (root == null) {
            root = new Node(value);
        }

        Node oldRoot = root;
        this.root = new Node(value);
        this.root.setNext(oldRoot);
        size++;
    }

    public Integer pop() {
        if (root == null) {
            return null;
        }

        Node oldRoot = root;
        root = root.getNext();
        size--;
        return oldRoot.getValue();
    }

    public Integer peek() {
        return root == null ? null : root.getValue();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int getSize() {
        return size;
    }
}
