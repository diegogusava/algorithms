package br.com.diegogusava.graphs.shortspath.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Integer> {

    public String name;
    public List<Edge> adjs = new ArrayList<>();
    public boolean visited;
    public int distance = Integer.MAX_VALUE;
    public Vertex predecessor;

    public void add(Vertex target, int weight) {
        adjs.add(new Edge(this, target, weight));
    }


    @Override
    public int compareTo(Integer o) {
        return Integer.compare(distance, o);
    }

}
