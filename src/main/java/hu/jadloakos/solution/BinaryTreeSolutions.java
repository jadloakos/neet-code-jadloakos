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

  @Override
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return Math.max(1 + maxDepth(root.getLeft()), 1 + maxDepth(root.getRight()));
  }

  @Override
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    var maxFromRoot = maxDepth(root.getLeft()) + maxDepth(root.getRight());
    return Math.max(
        Math.max(maxFromRoot, diameterOfBinaryTree(root.getLeft())),
        diameterOfBinaryTree(root.getRight()));
  }
}
