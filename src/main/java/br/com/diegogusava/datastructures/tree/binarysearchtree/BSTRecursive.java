package br.com.diegogusava.datastructures.tree.binarysearchtree;

import br.com.diegogusava.datastructures.tree.api.Node;
import br.com.diegogusava.datastructures.tree.api.Tree;

/**
 * Recursive Binary Search Tree
 */
public class BSTRecursive implements Tree {

    public Node root;

    @Override
    public Node root() {
        return root;
    }

    public void insert(int value) {
        if (root == null) {
            this.root = new Node(value);
            return;
        }
        insert(value, this.root, null);
    }

    private void insert(int value, Node current, Node parent) {

        if (current == null) {
            if (parent.value > value) {
                parent.left = new Node(value);
            } else {
                parent.right = new Node(value);
            }
            return;
        }

        //Duplicates are not allowed
        if (value == current.value) {
            return;
        } else if (current.value > value) {
            insert(value, current.left, current);
        } else if (current.value < value) {
            insert(value, current.right, current);
        }
    }

    public void delete(int value) {
        if (root == null) {
            return;
        }

        this.root = delete(value, this.root, null);
    }

    private Node delete(int value, Node current, Node parent) {
        if (current.value == value) {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left != null && current.right != null) {
                Node predecessor = findPredecessor(current.left);
                current.value = predecessor.value;
                current.left = delete(predecessor.value, current.left, current);
                return current;
            } else {
                Node child = current.left == null ? current.right : current.left;
                return child;
            }
        } else if (current.value > value) {
            current.left = delete(value, current.left, current);
            return current;
        } else {
            current.right = delete(value, current.right, current);
            return current;
        }
    }

    private Node findPredecessor(Node node) {
        if (node.right == null) {
            return node;
        }

        return findPredecessor(node.right);
    }

}
