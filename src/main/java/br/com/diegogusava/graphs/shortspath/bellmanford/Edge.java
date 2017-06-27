package br.com.diegogusava.graphs.shortspath.bellmanford;

public class Edge {

    public Vertex source;

    public Vertex target;

    public int distance;

    public Edge(Vertex source, Vertex target, int distance) {
        this.source = source;
        this.target = target;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("%s - %s : %s", source, target, distance);
    }
}
