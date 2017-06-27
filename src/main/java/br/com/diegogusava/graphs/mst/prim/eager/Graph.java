package br.com.diegogusava.graphs.mst.prim.eager;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public List<Edge> edges = new ArrayList<>();

    public List<Vertex> vertices = new ArrayList<>();

    public void add(Vertex vertex) {
        this.vertices.add(vertex);
    }

    public void add(Edge edge) {
        this.edges.add(edge);
        this.edges.add(edge.reverse());
    }


}
