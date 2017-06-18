package br.com.diegogusava.datastructures.tries;

public class Node {

    public char value;
    public Node[] children;

    public Node(char value) {
        this.value = value;
        children = new Node[26];
    }


}
