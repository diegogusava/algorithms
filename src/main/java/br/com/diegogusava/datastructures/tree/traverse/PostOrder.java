package br.com.diegogusava.datastructures.tree.traverse;


import br.com.diegogusava.datastructures.tree.api.Node;
import br.com.diegogusava.datastructures.tree.api.Tree;

/**
 * Created by diegogusava on 3/18/17.
 */
public class PostOrder implements TraverseVisitor {
    @Override
    public void visit(Tree bst) {
        postorder(bst.root());
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            postorder(node.getLeft());
        }

        if (node.getRight() != null) {
            postorder(node.getRight());
        }

        System.out.println(node.value);
    }
}
