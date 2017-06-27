package br.com.diegogusava.graphs.strongconnected.kosaraju;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {

    public String name;

    public Boolean visited;

    public List<Vertex> adjs = new ArrayList<>();

    public int componentId;

    public Vertex(String name) {
        this.name = name;
    }

    public void add(Vertex vertex) {
        this.adjs.add(vertex);
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
