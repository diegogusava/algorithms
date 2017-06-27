package br.com.diegogusava.graphs.strongconnected.kosaraju;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph {

    public List<Vertex> vertices = new ArrayList<>();

    public void add(Vertex vertex) {
        vertices.add(vertex);
    }

    public Graph transpose() {
        Graph graph = new Graph();

        final Map<String, Vertex> map = this.vertices.stream()
                .map(v -> new Vertex(v.name))
                .collect(Collectors.toMap(v -> v.name, v -> v));

        for (Vertex vertex : this.vertices) {
            for (Vertex adj : vertex.adjs) {
                final Vertex vertexTranspose = map.get(adj.name);
                vertexTranspose.add(vertex);
            }
        }

        graph.vertices = new ArrayList<>(map.values());

        return graph;
    }

    public Vertex getVertex(Vertex curr) {
        return vertices.stream().filter(v -> v.equals(curr))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Vertex not found"));
    }
}
