package br.com.diegogusava.datastructures.disjoinset;

public class Node {

    public int id;
    public int rank;
    public Node parent;
    public String value;

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}
