package br.com.diegogusava.graphs.mst.prim.lazy;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    public String name;
    public Vertex previous;
    public List<Edge> edgeList = new ArrayList<>();

    public void add(Edge edge) {
        edgeList.add(edge);
    }

}
