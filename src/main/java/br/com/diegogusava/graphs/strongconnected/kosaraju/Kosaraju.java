package br.com.diegogusava.graphs.strongconnected.kosaraju;

import java.util.HashSet;
import java.util.Set;

public class Kosaraju {

    Set<Vertex> visited = new HashSet<>();

    private Graph graph;

    private Graph transposeGraph;

    private int count;

    public Kosaraju(Graph graph) {
        this.graph = graph;
        this.transposeGraph = graph.transpose();
    }

    public void execute() {

        final TopologicalSort topologicalSort = new TopologicalSort();
        for (Vertex vertex : graph.vertices) {
            topologicalSort.dfs(vertex);
        }

        for (Vertex vertex : topologicalSort.vertices) {
            final Vertex vertexTranspose = transposeGraph.getVertex(vertex);
            if (!visited.contains(vertexTranspose)) {
                dfs(vertexTranspose);
                count++;
            }
        }

    }

    private void dfs(Vertex vertex) {
        visited.add(vertex);
        vertex.componentId = count;

        for (Vertex adj : vertex.adjs) {
            if (!visited.contains(adj)) {
                dfs(adj);
            }
        }
    }

}
