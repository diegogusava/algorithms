package br.com.diegogusava.graphs.maxflow;

public class Edge {

    public Vertex source;
    public Vertex target;
    public int capacity;
    public int flow;

    public Edge(Vertex source, Vertex target, int capacity) {
        this.source = source;
        this.target = target;
        this.capacity = capacity;
    }

    public Vertex getOther(Vertex vertex) {
        if (vertex.equals(source)) {
            return target;
        } else {
            return source;
        }
    }

    public int getResidualCapacity(Vertex vertex) {
        if (vertex.equals(source)) {
            return flow; // backward edge
        } else {
            return capacity - flow; // forward edge
        }
    }

    public void addResidualFlowTo(Vertex vertex, int deltaFlow) {
        if (vertex.equals(source)) {
            flow = flow - deltaFlow;
        } else {
            flow = flow + deltaFlow;
        }
    }
}
