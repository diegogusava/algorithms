package br.com.diegogusava.graphs.shortspath.dijkstra;

public class Edge {

    public Vertex source;
    public Vertex target;
    public int weight;

    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

}
