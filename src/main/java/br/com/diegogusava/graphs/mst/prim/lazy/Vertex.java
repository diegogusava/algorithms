package br.com.diegogusava.graphs.mst.prim.lazy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {

    public String name;
    public Vertex previous;
    public List<Edge> edgeList = new ArrayList<>();

    public void add(Edge edge) {
        edgeList.add(edge);
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
}
