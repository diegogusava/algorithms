package br.com.diegogusava.datastructures.disjoinset;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisjointSetTest {


    @Test
    public void makeSet() throws Exception {

        DisjointSet ds = new DisjointSet();

        final Node node1 = ds.makeSet("1");

        Assert.assertEquals("1", node1.value);
        Assert.assertEquals(0, node1.rank);
        Assert.assertEquals(null, node1.parent);

    }

    @Test
    public void find() throws Exception {
        DisjointSet ds = new DisjointSet();

        final Node node1 = ds.makeSet("1");

        final int id = ds.find(node1);
        Assert.assertNotNull(id);
    }

    @Test
    public void union() throws Exception {
        DisjointSet ds = new DisjointSet();

        final Node node1 = ds.makeSet("1");
        final Node node2 = ds.makeSet("2");
        final Node node3 = ds.makeSet("3");
        final Node node4 = ds.makeSet("4");

        ds.union(node1, node2);
        ds.union(node2, node3);
        ds.union(node3, node4);


    }

}