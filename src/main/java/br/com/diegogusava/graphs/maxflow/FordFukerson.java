package br.com.diegogusava.graphs.maxflow;

import java.util.LinkedList;
import java.util.Queue;

public class FordFukerson {

    private boolean[] marked; //marked[vertex.id] = true -> there is a path from source to v in residual graph
    private Edge[] edgeTo; // edge[vertex.id] = edges in the augmenting path
    private int valueMaxFlow;

    public FordFukerson(FlowNetwork flowNetwork, Vertex source, Vertex sink) {

        while (hasAugmentingPath(flowNetwork, source, sink)) {

            int minValue = Integer.MAX_VALUE;

            for (Vertex curr = sink; curr != source; curr = edgeTo[curr.id].getOther(curr)) {
                minValue = Math.min(minValue, edgeTo[curr.id].getResidualCapacity(curr));
            }

            for (Vertex curr = sink; curr != source; curr = edgeTo[curr.id].getOther(curr)) {

                edgeTo[curr.id].addResidualFlowTo(curr, minValue);

            }

            valueMaxFlow += minValue;

        }

    }

    private boolean hasAugmentingPath(FlowNetwork flowNetwork, Vertex source, Vertex sink) {

        edgeTo = new Edge[flowNetwork.numberVertices];
        marked = new boolean[flowNetwork.numberVertices];

        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(source);
        marked[source.id] = true;

        while (!queue.isEmpty() && !marked[sink.id]) {

            final Vertex curr = queue.poll();

            for (Edge edge : flowNetwork.getAdjacency(curr)) {
                final Vertex other = edge.getOther(curr);

                if (edge.getResidualCapacity(other) > 0) {
                    if (!marked[other.id]) {
                        edgeTo[other.id] = edge;
                        marked[other.id] = true;
                        queue.add(other);
                    }
                }
            }

        }

        return marked[sink.id];
    }
}
