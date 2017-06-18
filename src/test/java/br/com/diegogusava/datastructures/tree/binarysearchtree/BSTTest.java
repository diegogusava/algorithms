package br.com.diegogusava.datastructures.tree.binarysearchtree;

import br.com.diegogusava.datastructures.tree.api.Node;
import br.com.diegogusava.datastructures.tree.api.Tree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BSTTest {

    private Tree tree;

    @Before
    public void setup() {
        tree = new BSTNotRecursive();
    }

    @Test
    public void insert() throws Exception {
        tree.insert(100);
        tree.insert(50);
        tree.insert(200);

        assertEquals(100, tree.root().value);
        assertEquals(50, tree.root().left.value);
        assertEquals(200, tree.root().right.value);

    }

    @Test
    public void deleteRootWithoutChild() throws Exception {
        tree.insert(100);
        tree.delete(100);
        assertEquals(null, tree.root());
    }

    @Test
    public void deleteRootWithLeftChild() throws Exception {
        tree.insert(100);
        tree.insert(50);
        tree.delete(100);
        assertEquals(50, tree.root().value);
    }

    @Test
    public void deleteRootWithRightChild() throws Exception {
        tree.insert(100);
        tree.insert(200);
        tree.delete(100);
        assertEquals(200, tree.root().value);
    }

    @Test
    public void deleteRootWithLeftAndRightChild() {
        tree.insert(100);
        tree.insert(50);
        tree.insert(200);
        tree.delete(100);
        assertEquals(50, tree.root().value);
        assertEquals(null, tree.root().left);
        assertEquals(200, tree.root().right.value);
    }

    @Test
    public void deleteRootWithLeftAndRightChildAndDeeperPredecessor() {
        tree.insert(100);
        tree.insert(50);
        tree.insert(75);
        tree.insert(60);
        tree.insert(200);

        tree.delete(50);

        assertEquals(100, tree.root().value);
        assertEquals(75, tree.root().left.value);
        assertEquals(null, tree.root().left.right);
        assertEquals(60, tree.root().left.left.value);
        assertEquals(200, tree.root().right.value);
    }

    @Test
    public void deleteRootWithChildren() {
        tree.insert(100);
        tree.insert(75);
        tree.insert(50);
        tree.insert(90);
        tree.insert(80);
        tree.insert(200);

        tree.delete(100);

        Node root = tree.root();

        assertEquals(90, root.value);
        assertEquals(75, root.left.value);
        assertEquals(200, root.right.value);

        assertEquals(50, root.left.left.value);
        assertEquals(80, root.left.right.value);
    }

    @Test
    public void deleteNodeWithLeftChild() {
        tree.insert(100);
        tree.insert(50);
        tree.insert(200);
        tree.insert(20);
        tree.delete(50);

        assertEquals(100, tree.root().value);
        assertEquals(20, tree.root().left.value);
        assertEquals(null, tree.root().left.left);
        assertEquals(200, tree.root().right.value);
    }

    @Test
    public void deleteNodeWithRightChild() {
        tree.insert(100);
        tree.insert(50);
        tree.insert(200);
        tree.insert(500);
        tree.delete(200);

        assertEquals(100, tree.root().value);
        assertEquals(50, tree.root().left.value);
        assertEquals(500, tree.root().right.value);
    }

    @Test
    public void deleteNodeWithLeftAndRightChild() {
        tree.insert(100);
        tree.insert(50);
        tree.insert(75);
        tree.insert(25);
        tree.insert(35);

        tree.delete(50);

        assertEquals(100, tree.root().value);
        assertEquals(35, tree.root().left.value);
        assertEquals(25, tree.root().left.left.value);
        assertEquals(75, tree.root().left.right.value);
    }


    /**
     * Delete Root
     * Root is the predecessor parent
     * Predecessor has left child
     */
    @Test
    public void deleteRoot1() {
        //@formatter:off
        //      100             75
        //    75   200   ->        200
        //@formatter:on

        tree.insert(100);
        tree.insert(75);
        tree.insert(200);

        tree.delete(100);

        assertEquals(75, tree.root().value);
        assertEquals(null, tree.root().left);
        assertEquals(200, tree.root().right.value);
    }

    /**
     * Delete Root
     * Root is the predecessor parent
     * Predecessor has left child
     */
    @Test
    public void deleteRoot2() {
        //@formatter:off
        //      100             75
        //    75   200   ->  50    200
        //  50
        //@formatter:on
        tree.insert(100);
        tree.insert(75);
        tree.insert(50);
        tree.insert(200);

        tree.delete(100);

        assertEquals(75, tree.root().value);
        assertEquals(50, tree.root().left.value);
        assertEquals(200, tree.root().right.value);
    }


    /**
     * Delete Root
     * Root isn't the predecessor parent
     * Predecessor has no left child
     */
    @Test
    public void deleteRoot4() {
        //@formatter:off
        //       100               90
        //    75    200   ->   75     200
        // 50    90         50
        //@formatter:on

        tree.insert(100);
        tree.insert(75);
        tree.insert(50);
        tree.insert(90);
        tree.insert(200);

        tree.delete(100);

        assertEquals(90, tree.root().value);
        assertEquals(75, tree.root().left.value);
        assertEquals(null, tree.root().left.right);
        assertEquals(50, tree.root().left.left.value);
        assertEquals(200, tree.root().right.value);
    }

    /**
     * Delete Root
     * Root isn't the predecessor parent
     * Predecessor has no left child
     */
    @Test
    public void deleteRoot5() {
        //@formatter:off
        //       100               90
        //    75    200   ->   75     200
        // 50    90         50   80
        //     80
        //@formatter:on

        tree.insert(100);
        tree.insert(75);
        tree.insert(50);
        tree.insert(90);
        tree.insert(80);
        tree.insert(200);

        tree.delete(100);

        assertEquals(90, tree.root().value);
        assertEquals(75, tree.root().left.value);
        assertEquals(50, tree.root().left.left.value);
        assertEquals(80, tree.root().left.right.value);
        assertEquals(200, tree.root().right.value);
    }

    /**
     * Delete Root
     * Root isn't the predecessor parent
     * Predecessor has no left child
     */
    @Test
    public void deletePredecessorParent1() {
        //@formatter:off
        //       100                  100
        //    75    200   ->      50      200
        // 50    90                 90
        //@formatter:on

        tree.insert(100);
        tree.insert(75);
        tree.insert(50);
        tree.insert(90);
        tree.insert(200);

        tree.delete(75);

        assertEquals(100, tree.root().value);
        assertEquals(50, tree.root().left.value);
        assertEquals(null, tree.root().left.left);
        assertEquals(90, tree.root().left.right.value);
        assertEquals(200, tree.root().right.value);
    }

    /**
     * Delete Root
     * Root isn't the predecessor parent
     * Predecessor has no left child
     */
    @Test
    public void deletePredecessorParent2() {
        //@formatter:off
        //       100                  100
        //    75    200   ->      60      200
        // 50    90            50    90
        //   60
        //@formatter:on

        tree.insert(100);
        tree.insert(75);
        tree.insert(50);
        tree.insert(90);
        tree.insert(60);
        tree.insert(200);

        tree.delete(75);

        assertEquals(100, tree.root().value);
        assertEquals(60, tree.root().left.value);
        assertEquals(50, tree.root().left.left.value);
        assertEquals(90, tree.root().left.right.value);
        assertEquals(200, tree.root().right.value);
    }

}