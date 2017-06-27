package br.com.diegogusava.graphs.mst.prim.eager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex implements Comparable<Vertex> {

    public String name;
    public Edge minEdge;
    public Vertex previous;
    public List<Edge> edges = new ArrayList<>();
    public int distance = Integer.MAX_VALUE;
    public boolean visited;

    public void add(Edge edge) {
        edges.add(edge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(distance, o.distance);
    }
}
