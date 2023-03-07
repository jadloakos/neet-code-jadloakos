package hu.jadloakos.solution;

import hu.jadloakos.problem.BinaryTreeProblems;

import java.util.ArrayList;
import java.util.List;

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

  @Override
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levelOrder = new ArrayList<>();
    levelOrder(root, 0, levelOrder);
    return levelOrder;
  }

  @Override
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightSideView = new ArrayList<>();
    rightSideView(root, 0, rightSideView);
    return rightSideView;
  }

  @Override
  public int goodNodes(TreeNode root) {
    return goodNodes(root, null);
  }

  private void levelOrder(TreeNode root, int lvl, List<List<Integer>> levelOrder) {
    if (root == null) {
      return;
    }

    if (levelOrder.size() < lvl + 1) {
      levelOrder.add(new ArrayList<>());
    }
    levelOrder.get(lvl).add(root.getVal());

    levelOrder(root.getLeft(), lvl + 1, levelOrder);
    levelOrder(root.getRight(), lvl + 1, levelOrder);
  }

  private void rightSideView(TreeNode root, int lvl, List<Integer> rightSideView) {
    if (root == null) {
      return;
    }

    if (rightSideView.size() <= lvl) {
      rightSideView.add(root.getVal());
    }

    rightSideView(root.getRight(), lvl + 1, rightSideView);
    rightSideView(root.getLeft(), lvl + 1, rightSideView);
  }

  private int goodNodes(TreeNode node, Integer max) {
    if (node == null) {
      return 0;
    }

    var value = node.getVal();
    var goodNodeCount = 0;
    if (max == null || value >= max) {
      goodNodeCount++;
    }

    var newMax = max == null ? value : Math.max(max, value);
    goodNodeCount += goodNodes(node.getLeft(), newMax);
    goodNodeCount += goodNodes(node.getRight(), newMax);

    return goodNodeCount;
  }
}
