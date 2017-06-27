package br.com.diegogusava.graphs.mst.prim.eager;

public class Edge implements Comparable<Integer> {

    public int weight;
    public Vertex source;
    public Vertex target;

    @Override
    public int compareTo(Integer o) {
        return Integer.compare(weight, o);
    }

    public Edge reverse() {
        final Edge edge = new Edge();
        edge.source = this.target;
        edge.target = this.source;
        edge.weight = this.weight;
        return edge;
    }

}