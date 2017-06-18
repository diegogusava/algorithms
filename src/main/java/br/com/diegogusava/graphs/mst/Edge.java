package br.com.diegogusava.graphs.mst;

public class Edge implements Comparable<Edge> {

    public Vertex source;

    public Vertex target;

    public double weight;

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }

    @Override
    public String toString() {
        return source + " -> " + target + " : " + weight;
    }
}
