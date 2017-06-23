package br.com.diegogusava.graphs.mst.kruskal;

import br.com.diegogusava.datastructures.disjoinset.Node;

public class Vertex {

    public String value;

    public Node node;

    @Override
    public String toString() {
        return this.value;
    }
}
