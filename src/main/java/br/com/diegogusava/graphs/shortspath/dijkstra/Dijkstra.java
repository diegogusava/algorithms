package br.com.diegogusava.graphs.shortspath.dijkstra;

import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

    public void execute(Vertex vertex) {

        vertex.distance = 0;
        Queue<Vertex> queue = new PriorityQueue<>();

        queue.offer(vertex);

        while (!queue.isEmpty()) {

            final Vertex curr = queue.poll();

            if (!curr.visited) {
                curr.visited = true;

                for (Edge adj : curr.adjs) {

                    final Vertex target = adj.target;

                    if (!target.visited) {
                        queue.offer(target);
                    }

                    if (curr.distance + adj.weight < target.distance) {
                        target.predecessor = curr;
                        target.distance = curr.distance + adj.weight;
                    }

                }

            }
        }

    }

}
