package br.com.diegogusava.datastructures.tree.api;

public interface Tree {

    Node root();

    void insert(int value);

    void delete(int value);

}
