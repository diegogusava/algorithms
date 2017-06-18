package br.com.diegogusava.datastructures.tree.traverse;

import br.com.diegogusava.datastructures.tree.api.Node;
import br.com.diegogusava.datastructures.tree.api.Tree;

public class PreOrder implements TraverseVisitor {

    @Override
    public void visit(Tree bstNotRecursive) {
        preorder(bstNotRecursive.root());
    }

    private void preorder(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node.getValue());

        if (node.getLeft() != null) {
            preorder(node.getLeft());
        }

        if (node.getRight() != null) {
            preorder(node.getRight());
        }
    }
}
