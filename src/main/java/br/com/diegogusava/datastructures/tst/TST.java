package br.com.diegogusava.datastructures.tst;

public class TST {

    private Node root;

    public void put(String key, int value) {

        int index = 0;

        Node curr = root;
        Node previous = root;

        while (index < key.length()) {

            char keyChar = key.charAt(index);

            if (curr == null) {
                curr = new Node(keyChar);

                if (root == null) {
                    this.root = curr;
                }

                if (previous != null) {
                    previous.middle = curr;
                }

                previous = curr;
                curr = curr.middle;
                index++;

            } else {
                if (curr.key == keyChar) {
                    previous = curr;
                    curr = curr.middle;
                    index++;
                } else if (curr.key > keyChar) {

                    if (curr.left == null) {
                        curr.left = new Node(keyChar);
                        previous = curr.left;
                        curr = null;
                        index++;
                    } else {
                        curr = curr.left;
                    }
                } else if (curr.key < keyChar) {
                    if (curr.right == null) {
                        curr.right = new Node(keyChar);
                        previous = curr.right;
                        curr = null;
                        index++;
                    } else {
                        curr = curr.right;
                    }
                }
            }
        }

        previous.value = value;

    }

    public Integer find(String key) {
        Node curr = this.root;
        int index = 0;

        if (curr == null) {
            return null;
        }

        while (index < key.length()) {

            char keyChar = key.charAt(index);

            if (curr.key == keyChar) {
                if (index + 1 == key.length()) {
                    return curr.value;
                } else {
                    curr = curr.middle;
                    index++;
                }
            } else if (curr.key > keyChar) {
                curr = curr.left;
            } else if (curr.key < keyChar) {
                curr = curr.right;
            }

            if (curr == null) {
                return null;
            }
        }

        return curr.value;
    }

}
