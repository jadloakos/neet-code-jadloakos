package hu.jadloakos.solution;

import hu.jadloakos.problem.BinaryTreeProblems;

/** Solutions for problems in {@link BinaryTreeProblems}. */
public class BinaryTreeSolutions implements BinaryTreeProblems {

  @Override
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    var left = root.getLeft();
    root.setLeft(root.getRight());
    root.setRight(left);

    invertTree(root.getLeft());
    invertTree(root.getRight());

    return root;
  }
}
