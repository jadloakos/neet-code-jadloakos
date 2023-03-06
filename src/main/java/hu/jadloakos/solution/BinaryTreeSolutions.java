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

  @Override
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (Math.abs(maxDepth(root.getLeft()) - maxDepth(root.getRight())) > 1) {
      return false;
    }

    return isBalanced(root.getLeft()) && isBalanced(root.getRight());
  }

  @Override
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p == null || q == null || p.getVal() != q.getVal()) {
      return false;
    }

    return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
  }

  @Override
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return false;
    }

    return isSameTree(root, subRoot)
        || isSubtree(root.getLeft(), subRoot)
        || isSubtree(root.getRight(), subRoot);
  }

  @Override
  public Integer lowestCommonAncestor(TreeNode root, Integer p, Integer q) {
    if (root == null) {
      return null;
    }

    var value = root.getVal();
    if (value < p && value > q || value > p && value < q || value == p || value == q) {
      return value;
    }

    return Math.min(
        value, lowestCommonAncestor(p < value ? root.getLeft() : root.getRight(), p, q));
  }
}
