package br.com.diegogusava.graphs.shortspath;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class BellmanFordTest {

    @Test
    public void execute() throws Exception {

        Vertex a = new Vertex("A");

        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        List<Vertex> vs = Arrays.asList(a, b, c, d);

        Edge atb = new Edge(a, b, 5);
        Edge atc = new Edge(a, c, 7);
        Edge btd = new Edge(b, d, -2);
        Edge ctd = new Edge(c, d, 3);
        Edge dta = new Edge(d, a, -1);

        List<Edge> es = Arrays.asList(atb, atc, btd, ctd, dta);

        final BellmanFord bellmanFord = new BellmanFord(vs, es);
        bellmanFord.execute(a);

        final List<String> shortspath = bellmanFord.shortspath(d);
        shortspath.forEach(s -> System.out.print(s + " - "));

    }

    @Test
    public void shortspath() throws Exception {

    }

}