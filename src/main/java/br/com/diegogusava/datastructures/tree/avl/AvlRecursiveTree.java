package br.com.diegogusava.datastructures.tree.avl;

import br.com.diegogusava.datastructures.tree.api.Node;
import br.com.diegogusava.datastructures.tree.api.Tree;

import static java.lang.Math.max;

public class AvlRecursiveTree implements Tree {

    public Node root;

    @Override
    public Node root() {
        return root;
    }

    public void insert(int value) {
        this.root = insert(value, this.root);
    }

    private Node insert(int value, Node current) {

        if (current == null) {
            current = new Node(value);
        } else if (value < current.value) {
            current.left = insert(value, current.left);
        } else if (value > current.value) {
            current.right = insert(value, current.right);
        }

        return balance(current);
    }

    private Node balance(Node current) {

        if (current == null) {
            return null;
        }

        int height = max(height(current.left), height(current.right)) + 1;
        current.setHeight(height);

        int balance = height(current.left) - height(current.right);

        boolean leftSideHeavier = balance > 1;
        boolean rightSideHeavier = balance < -1;

        if (leftSideHeavier && height(current.left.left) >= height(current.left.right)) {

            //left left
            //@formatter:off
            //      100          75
            //    75      ->  50    100
            //  50
            //@formatter:on
            current = rightRotation(current);

        } else if (leftSideHeavier && height(current.left.left) < height(current.left.right)) {

            //left right

            //@formatter:off
                //     100             100         75
                //   50       ->     75     ->  50    100
                //     75          50
                //@formatter:on
            current.left = leftRotation(current.left);
            current = rightRotation(current);

        } else if (rightSideHeavier && height(current.right.left) <= height(current.right.right)) {
            //right right
            //@formatter:off
                //      100                75
                //          75      -> 100    150
                //             150
                //@formatter:on
            current = leftRotation(current);

        } else if (rightSideHeavier && height(current.right.left) > height(current.right.right)) {
            //right left

            //@formatter:off
                //      100           100                 75
                //          150 ->        75      ->  100    150
                //      75                   150
                //@formatter:on
            current.right = rightRotation(current.right);
            current = leftRotation(current);
        }

        return current;


    }

    //@formatter:off
    //         50        ||         40
    //    40        100  ||     30      50
    // 30    45          ||          45    100
    //
    //@formatter:on
    private Node rightRotation(final Node node) {
        final Node left = node.left;

        node.left = left.right;
        left.right = node;

        //heights
        node.height = max(height(node.left), height(node.right)) + 1;
        left.height = max(height(left.left), height(left.right)) + 1;

        return left;
    }

    //@formatter:off
    //          40         ||        50
    //     30      50      ||    40        100
    //          45    100  || 30    45
    //
    //@formatter:on
    private Node leftRotation(Node node) {
        Node right = node.right;

        node.right = right.left;
        right.left = node;

        //heights
        node.height = max(height(node.left), height(node.right)) + 1;
        right.height = max(height(right.left), height(right.right)) + 1;

        return right;
    }

    public void delete(int value) {
        if (root == null) {
            return;
        }

        this.root = delete(value, this.root);
    }

    private Node delete(int value, Node current) {

        if (current.value == value) {
            if (current.left == null && current.right == null) {
                current = null;
            } else if (current.left != null && current.right != null) {
                Node predecessor = findPredecessor(current.left);
                current.value = predecessor.value;
                current.left = delete(predecessor.value, current.left);
            } else {
                Node child = current.left == null ? current.right : current.left;
                current = child;
            }
        } else if (current.value > value) {
            current.left = delete(value, current.left);
        } else {
            current.right = delete(value, current.right);
        }

        return balance(current);
    }

    private Node findPredecessor(Node node) {
        if (node.right == null) {
            return node;
        }

        return findPredecessor(node.right);
    }

    private int height(Node node) {

        if (node == null) {
            return -1;
        }

        return node.getHeight();
    }


}
