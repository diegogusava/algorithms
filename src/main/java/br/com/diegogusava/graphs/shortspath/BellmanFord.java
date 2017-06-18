package br.com.diegogusava.graphs.shortspath;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Running Time: O(E * V)
 */
public class BellmanFord {

    private final List<Vertex> vertexList;
    private final List<Edge> edgeList;

    public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }


    public void execute(Vertex source) {

        source.distance = 0;

        //Relax V - 1 to find the shortspath
        for (int i = 0; i < vertexList.size() - 1; i++) {

            for (Edge edge : edgeList) {

                //If the source is infinity, it's not possible to decrease the distance
                //to reach the target
                if (edge.source.distance == Integer.MAX_VALUE) continue;

                int distance = edge.source.distance + edge.distance;

                if (distance < edge.target.distance) {
                    edge.target.distance = distance;
                    edge.target.parent = edge.source;
                }
            }

        }

        for (Edge edge : edgeList) {
            int distance = edge.source.distance + edge.distance;
            if (distance < edge.target.distance) {
                throw new RuntimeException("there is a negative cycle in the graph");
            }
        }
    }

    public List<String> shortspath(Vertex target) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst(target.value);
        while (target.parent != null) {
            list.addFirst(target.parent.value);
            target = target.parent;
        }
        return list;
    }

}
