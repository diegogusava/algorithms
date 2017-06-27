package br.com.diegogusava.graphs.mst.prim.eager;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimEager {

    private List<Vertex> vertices;

    private Queue<Vertex> queue = new PriorityQueue<>();

    public PrimEager(Graph graph) {
        vertices = graph.vertices;
    }

    public void execute() {


        for (Vertex vertex : vertices) {

            if (!vertex.visited) {

                vertex.distance = 0;
                queue.offer(vertex);

                while (!queue.isEmpty()) {

                    final Vertex curr = queue.poll();
                    curr.visited = true;

                    for (Edge edge : curr.edges) {

                        final Vertex target = edge.target;

                        if (target.visited) {
                            continue;
                        }

                        if (edge.weight < target.distance) {

                            target.distance = edge.weight;
                            target.minEdge = edge;

                            //Remove the old target with old distance
                            queue.remove(target);

                            //Put the new target with the smaller distance
                            queue.add(target);


                        }

                    }


                }

            }

        }


    }

}
