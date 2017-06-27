package br.com.diegogusava.graphs.strongconnected.kosaraju;

import java.util.Stack;

public class TopologicalSort {

    public Stack<Vertex> vertices;

    public void dfs(Vertex vertex) {

        vertex.visited = true;

        for (Vertex adj : vertex.adjs) {
            if (!adj.visited) {
                dfs(adj);
            }
        }

        vertices.push(vertex);
    }

}
