package br.com.diegogusava.graphs.mst.kruskal;

import br.com.diegogusava.datastructures.disjoinset.DisjointSet;
import br.com.diegogusava.datastructures.disjoinset.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {


    public List<Edge> spanningTree(List<Vertex> vertexList, List<Edge> edgeList) {

        final DisjointSet disjointSet = new DisjointSet();

        for (Vertex vertex : vertexList) {
            final Node node = disjointSet.makeSet(vertex.value);
            vertex.node = node;
        }

        Collections.sort(edgeList);

        //Minimum spanning tree
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edgeList) {

            final Vertex source = edge.source;
            final Vertex target = edge.target;

            if (disjointSet.find(source.node) != disjointSet.find(target.node)) {
                mst.add(edge);
                disjointSet.union(source.node, target.node);
            }

        }

        return mst;

    }

}
