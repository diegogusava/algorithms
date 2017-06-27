package br.com.diegogusava.graphs.strongconnected.tarjan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tarjan {

    private Stack<Vertex> stack = new Stack<>();
    private List<Vertex> vertices;
    private int timeVisited;
    private int count = 0;

    private List<List<Vertex>> components = new ArrayList<>();


    public void add(Vertex vertex) {
        this.vertices.add(vertex);
    }

    public void execute() {
        for (Vertex vertex : vertices) {
            if (!vertex.visited) {
                dfs(vertex);
            }
        }
    }

    private void dfs(Vertex vertex) {

        vertex.lowlink = timeVisited++;
        vertex.visited = true;
        stack.push(vertex);

        boolean componentRoot = true;

        for (Vertex adj : vertex.adjs) {
            if (!adj.visited) {
                dfs(vertex);
            }


            if (vertex.lowlink > adj.lowlink) {
                vertex.lowlink = adj.lowlink;
                componentRoot = false;
            }
        }

        if (componentRoot) {

            count++;

            List<Vertex> component = new ArrayList<>();

            while (true) {

                final Vertex curr = stack.pop();

                component.add(curr);
                curr.lowlink = Integer.MAX_VALUE;

                if (curr.name.equals(vertex.name)) {
                    break;
                }

                components.add(component);
            }

        }
    }

}
