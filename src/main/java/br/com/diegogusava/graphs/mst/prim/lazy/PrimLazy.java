package br.com.diegogusava.graphs.mst.prim.lazy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Add new neighbour edges to the heap without deleting
 */
public class PrimLazy {

    private Set<Vertex> unvisitedVertices = new HashSet<>();

    private PriorityQueue<Edge> edges = new PriorityQueue<>();

    private List<Edge> mst = new ArrayList<>();

    private double fullCost = 0.0;

    public void execute(Vertex curr) {


        unvisitedVertices.remove(curr);

        while (!unvisitedVertices.isEmpty()) {


            for (Edge edge : curr.edgeList) {

                //Verify, to not create a cycle.
                if (unvisitedVertices.contains(edge.target)) {
                    edges.add(edge);
                }

            }

            final Edge edgeMin = edges.remove();

            mst.add(edgeMin);

            fullCost += edgeMin.weight;

            curr = edgeMin.target;

            unvisitedVertices.remove(curr);

        }


    }

}
