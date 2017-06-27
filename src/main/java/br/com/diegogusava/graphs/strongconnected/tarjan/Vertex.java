package br.com.diegogusava.graphs.strongconnected.tarjan;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    public String name;
    public List<Vertex> adjs = new ArrayList<>();
    public Vertex predecessor;
    public boolean visited;
    public int lowlink;

    public void add(Vertex vertex) {
        this.adjs.add(vertex);
    }

}
