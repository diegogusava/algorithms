package br.com.diegogusava.graphs.mst.prim.lazy;

public class Edge implements Comparable<Double> {

    public double weight;
    public Vertex source;
    public Vertex target;

    @Override
    public int compareTo(Double o) {
        return Double.compare(weight, o);
    }
}
