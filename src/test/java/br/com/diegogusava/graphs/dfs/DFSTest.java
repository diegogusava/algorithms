package br.com.diegogusava.graphs.dfs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DFSTest {

    @Test
    public void iterative() {
        final DFS dfs = new DFS();


        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        a.addAdj(b, c);
        b.addAdj(d, e);
        c.addAdj(d, e);
        d.addAdj(f);

        final List<Vertex> it = dfs.iterative(a);

        for (Vertex vertex : it) {
            System.out.println(vertex.name);
        }


    }


    @Test
    public void recursive() {

        final DFS dfs = new DFS();


        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        a.addAdj(b, c);
        b.addAdj(d, e);
        c.addAdj(d, e);
        d.addAdj(f);

        final List<Vertex> it = dfs.recursive(a, null);

        for (Vertex vertex : it) {
            System.out.println(vertex.name);
        }
    }

}