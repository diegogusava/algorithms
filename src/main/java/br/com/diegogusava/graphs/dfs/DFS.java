package br.com.diegogusava.graphs.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

    public List<Vertex> iterative(Vertex vertex) {
        List<Vertex> vertices = new ArrayList<>();
        Stack<Vertex> stack = new Stack();
        stack.push(vertex);
        while (!stack.isEmpty()) {
            final Vertex curr = stack.pop();
            curr.visited = true;
            vertices.add(curr);
            for (Vertex adj : curr.adjs) {
                if (!adj.visited) {
                    stack.push(adj);
                }
            }
        }

        return vertices;
    }

    public List<Vertex> recursive(Vertex vertex, List<Vertex> vertices) {

        if (vertices == null) {
            vertices = new ArrayList<>();
        }

        if (!vertex.visited) {
            vertex.visited = true;
            vertices.add(vertex);
            for (Vertex adj : vertex.adjs) {
                recursive(adj, vertices);
            }
        }

        return vertices;
    }

}
