package br.com.diegogusava.graphs.maxflow;

import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {

    public int numberVertices;
    public int numberEdges;
    public List<List<Edge>> adjacencies;


    public FlowNetwork(int numberVertices) {
        this.numberVertices = numberVertices;
        this.adjacencies = new ArrayList<>();

        for (int i = 0; i < numberVertices; i++) {
            this.adjacencies.add(new ArrayList<>());
        }
    }

    public void addEdge(Edge edge) {
        final Vertex v = edge.source;
        final Vertex w = edge.target;

        adjacencies.get(v.id).add(edge);
        adjacencies.get(w.id).add(edge);

        numberEdges++;
    }

    public List<Edge> getAdjacency(Vertex vertex) {
        return adjacencies.get(vertex.id);
    }
}
