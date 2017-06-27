package br.com.diegogusava.graphs.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {


    public void iterative(Vertex vertex) {

        Queue<Vertex> queue = new ArrayDeque<>();
        queue.offer(vertex);

        while (!queue.isEmpty()) {

            Vertex curr = queue.poll();

            if (!curr.visited) {

                curr.visited = true;

                for (Vertex adj : curr.adjs) {
                    queue.offer(adj);
                }

            }

        }

    }

}
