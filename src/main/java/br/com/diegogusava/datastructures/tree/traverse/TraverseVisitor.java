package br.com.diegogusava.datastructures.tree.traverse;

import br.com.diegogusava.datastructures.tree.api.Tree;

public interface TraverseVisitor {
    void visit(Tree tree);
}
