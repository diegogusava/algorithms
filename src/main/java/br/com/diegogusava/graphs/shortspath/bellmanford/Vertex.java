package br.com.diegogusava.graphs.shortspath.bellmanford;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    public String value;

    public int distance = Integer.MAX_VALUE;

    public List<Edge> adjacencies = new ArrayList<>();

    public Vertex parent;

    public Vertex(String value) {
        this.value = value;
    }

    public void addAdjacency(Edge edge) {
        this.adjacencies.add(edge);
    }

    @Override
    public String toString() {
        return value;
    }
}
