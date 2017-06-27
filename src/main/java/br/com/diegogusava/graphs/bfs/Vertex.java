package br.com.diegogusava.graphs.bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    public String name;

    public List<Vertex> adjs = new ArrayList<>();
    public boolean visited;

    public Vertex(String name) {
        this.name = name;
    }

    public void addAdj(Vertex... vertex) {
        for (Vertex v : vertex) {
            adjs.add(v);
        }
    }

}