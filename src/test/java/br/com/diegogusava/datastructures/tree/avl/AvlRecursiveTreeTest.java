package br.com.diegogusava.datastructures.tree.avl;

import br.com.diegogusava.datastructures.tree.api.Tree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AvlRecursiveTreeTest {

    private Tree tree;

    @Before
    public void setup() {
        tree = new AvlRecursiveTree();
    }

    @Test
    public void insertLeftLeftSituation() throws Exception {
        tree.insert(100);
        tree.insert(75);
        tree.insert(50);

        Assert.assertEquals(75, tree.root().value);
        Assert.assertEquals(1, tree.root().height);

        Assert.assertEquals(50, tree.root().left.value);
        Assert.assertEquals(0, tree.root().left.height);

        Assert.assertEquals(100, tree.root().right.value);
        Assert.assertEquals(0, tree.root().right.height);
    }

    @Test
    public void insertLeftRightSituation() {
        tree.insert(100);
        tree.insert(50);
        tree.insert(75);

        Assert.assertEquals(75, tree.root().value);
        Assert.assertEquals(1, tree.root().height);

        Assert.assertEquals(50, tree.root().left.value);
        Assert.assertEquals(0, tree.root().left.height);

        Assert.assertEquals(100, tree.root().right.value);
        Assert.assertEquals(0, tree.root().right.height);
    }

    @Test
    public void insertRightRightSituation() {
        tree.insert(50);
        tree.insert(75);
        tree.insert(100);

        Assert.assertEquals(75, tree.root().value);
        Assert.assertEquals(1, tree.root().height);

        Assert.assertEquals(50, tree.root().left.value);
        Assert.assertEquals(0, tree.root().left.height);

        Assert.assertEquals(100, tree.root().right.value);
        Assert.assertEquals(0, tree.root().right.height);
    }

    @Test
    public void insertRightLeftSituation() {
        tree.insert(50);
        tree.insert(100);
        tree.insert(75);

        Assert.assertEquals(75, tree.root().value);
        Assert.assertEquals(1, tree.root().height);

        Assert.assertEquals(50, tree.root().left.value);
        Assert.assertEquals(0, tree.root().left.height);

        Assert.assertEquals(100, tree.root().right.value);
        Assert.assertEquals(0, tree.root().right.height);
    }

    @Test
    public void deleteLeftLeft() {
        tree.insert(50);
        tree.insert(25);
        tree.insert(100);
        tree.insert(5);

        tree.delete(100);

        Assert.assertEquals(25, tree.root().value);
        Assert.assertEquals(1, tree.root().height);

        Assert.assertEquals(5, tree.root().left.value);
        Assert.assertEquals(0, tree.root().left.height);

        Assert.assertEquals(50, tree.root().right.value);
        Assert.assertEquals(0, tree.root().right.height);
    }

    @Test
    public void deleteLeftLeftWithChild() {
        tree.insert(35);
        tree.insert(50);
        tree.insert(25);
        tree.insert(30);
        tree.insert(5);

        tree.delete(50);

        Assert.assertEquals(25, tree.root().value);
        Assert.assertEquals(2, tree.root().height);

        Assert.assertEquals(5, tree.root().left.value);
        Assert.assertEquals(0, tree.root().left.height);

        Assert.assertEquals(35, tree.root().right.value);
        Assert.assertEquals(1, tree.root().right.height);

        Assert.assertEquals(30, tree.root().right.left.value);
        Assert.assertEquals(0, tree.root().right.left.height);
    }

    @Test
    public void deleteRightRightWithChild() {
        tree.insert(100);
        tree.insert(50);
        tree.insert(150);
        tree.insert(125);
        tree.insert(175);

        tree.delete(50);

        Assert.assertEquals(150, tree.root().value);
        Assert.assertEquals(2, tree.root().height);

        Assert.assertEquals(100, tree.root().left.value);
        Assert.assertEquals(1, tree.root().left.height);

        Assert.assertEquals(125, tree.root().left.right.value);
        Assert.assertEquals(0, tree.root().left.right.height);

        Assert.assertEquals(175, tree.root().right.value);
        Assert.assertEquals(0, tree.root().right.height);
    }

    @Test
    public void deleteRightRight() {
        tree.insert(100);
        tree.insert(50);
        tree.insert(150);
        tree.insert(175);

        tree.delete(50);

        Assert.assertEquals(150, tree.root().value);
        Assert.assertEquals(1, tree.root().height);

        Assert.assertEquals(100, tree.root().left.value);
        Assert.assertEquals(0, tree.root().left.height);

        Assert.assertEquals(175, tree.root().right.value);
        Assert.assertEquals(0, tree.root().right.height);
    }

}