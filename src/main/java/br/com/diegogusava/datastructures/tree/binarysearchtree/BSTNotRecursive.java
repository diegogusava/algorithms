package br.com.diegogusava.datastructures.tree.binarysearchtree;

import br.com.diegogusava.datastructures.tree.api.Node;
import br.com.diegogusava.datastructures.tree.api.Tree;

/**
 * Not Recursive Binary Search Tree
 */
public class BSTNotRecursive implements Tree {

    private Node root;

    @Override
    public Node root() {
        return root;
    }

    @Override
    public void insert(int value) {
        if (this.root == null) {
            this.root = new Node(value);
        }

        Node current = this.root;

        while (current != null) {
            if (current.value > value) {
                if (current.left == null) {
                    current.left = new Node(value);
                } else {
                    current = current.left;
                }
            } else if (current.value < value) {
                if (current.right == null) {
                    current.right = new Node(value);
                } else {
                    current = current.right;
                }
            } else {
                //Duplicates are not allowed
                current = null;
            }
        }

    }

    @Override
    public void delete(int value) {
        if (root == null) {
            return;
        }

        Node parent = null;
        Node current = this.root;
        boolean abort = current == null;

        //Search for the element
        //-------------------------------------
        while (!abort) {
            if (current.value > value) {
                if (current.left == null) { //not found
                    abort = true;
                    current = null;
                } else {
                    parent = current;
                    current = current.left;
                }
            } else if (current.value < value) {
                if (current.right == null) { //not found
                    abort = true;
                    current = null;
                } else {
                    parent = current;
                    current = current.right;
                }
            } else if (current.value == value) {
                //found
                abort = true;
            }
        }

        //not found, abort the program
        if (current == null) {
            return;
        }
        //-------------------------------------


        if (current.left == null && current.right == null) {
            if (parent == null) {
                this.root = null;
                return;
            }
            if (parent.right == current) {
                parent.right = null;
            }
            if (parent.left == current) {
                parent.left = null;
            }
        } else if (current.left != null && current.right != null) {

            //-------------------------------------
            //Search for the predecessor
            Node predecessor = current.left;
            Node predecessorParent = current;

            while (predecessor.right != null) {
                predecessorParent = predecessor;
                predecessor = predecessor.right;
            }

            //-------------------------------------


            current.value = predecessor.value;

            //The predecessor can be left child or right child
            //Its only left if the parent is the current node to delete
            //And it not have right child (because its the predecessor)
            if (predecessorParent == current) {
                predecessorParent.left = predecessor.left;
            } else {
                predecessorParent.right = predecessor.left;
            }


        } else {
            Node child = current.left == null ? current.right : current.left;
            if (parent == null) {
                this.root = child;
                return;
            }
            if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }


    }
}
