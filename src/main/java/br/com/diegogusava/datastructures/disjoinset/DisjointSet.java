package br.com.diegogusava.datastructures.disjoinset;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    List<Node> nodes = new ArrayList<>();

    public Node makeSet(String value) {
        Node node = new Node();
        node.value = value;
        nodes.add(node);
        node.id = nodes.size() - 1;
        return node;
    }

    public int find(Node node) {
        Node curr = node;

        while (curr.parent != null) {
            curr = curr.parent;
        }

        Node parent = curr;

        curr = node;

        while (curr.parent != null) {
            Node temp = curr.parent;
            curr.parent = parent;
            curr = temp;
        }

        return parent.id;
    }


    public void union(Node node1, Node node2) {

        final int root1Id = find(node1);
        final int root2Id = find(node2);

        if (root1Id == root2Id) {
            return;
        }

        final Node root1 = nodes.get(root1Id);
        final Node root2 = nodes.get(root2Id);

        if (root1.rank < root2.rank) {
            root1.parent = root2.parent;
        } else if (root1.rank > root2.rank) {
            root2.parent = root1.parent;
        } else {
            root2.parent = root1;
            root1.rank++;
        }
    }

}
