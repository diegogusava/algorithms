package br.com.diegogusava.datastructures.tree.traverse;

import br.com.diegogusava.datastructures.tree.api.Node;
import br.com.diegogusava.datastructures.tree.api.Tree;

public class InOrder implements TraverseVisitor {

    @Override
    public void visit(Tree tree) {
        Node node = tree.root();
        inorder(node);
    }

    private void inorder(Node node) {

        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            inorder(node.getLeft());
        }

        System.out.println(node.getValue());


        if (node.getRight() != null) {
            inorder(node.getRight());
        }

    }


}
