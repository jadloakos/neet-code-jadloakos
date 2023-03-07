package hu.jadloakos.problem;

import java.util.List;

/** Interface for binary tree problems. */
public interface BinaryTreeProblems {

  /**
   * Given the root of a binary tree, invert the tree, and return its root.
   *
   * @param root root of a binary tree
   * @return root of inverted tree
   */
  TreeNode invertTree(TreeNode root);

  /**
   * Given the root of a binary tree, return its maximum depth.
   *
   * <p>A binary tree's maximum depth is the number of nodes along the longest path from the root
   * node down to the farthest leaf node.
   *
   * @param root root of a binary tree
   * @return maximum depth
   */
  int maxDepth(TreeNode root);

  /**
   * Given the root of a binary tree, return the length of the diameter of the tree.
   *
   * <p>The diameter of a binary tree is the length of the longest path between any two nodes in a
   * tree. This path may or may not pass through the root.
   *
   * <p>The length of a path between two nodes is represented by the number of edges between them.
   *
   * @param root the root of the binary tree
   * @return diameter of tree
   */
  int diameterOfBinaryTree(TreeNode root);

  /**
   * Given a binary tree, determine if it is height-balanced.
   *
   * <p>A height-balanced binary tree is a binary tree in which the depth of the two subtrees of
   * every node never differs by more than one.
   *
   * @param root root of a binary tree
   * @return true if tree is height-balanced, false otherwise
   */
  boolean isBalanced(TreeNode root);

  /**
   * Given the roots of two binary trees p and q, write a function to check if they are the same or
   * not.
   *
   * <p>Two binary trees are considered the same if they are structurally identical, and the nodes
   * have the same value.
   *
   * @param p first tree
   * @param q second tree
   * @return true if binary trees are identical, false otherwise
   */
  boolean isSameTree(TreeNode p, TreeNode q);

  /**
   * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root
   * with the same structure and node values of subRoot and false otherwise.
   *
   * <p>A subtree of a binary tree is a tree that consists of a node in tree and all of this node's
   * descendants. The tree could also be considered as a subtree of itself.
   *
   * @param root root of a binary tree
   * @param subRoot root of a binary
   * @return true if first tree contains second, false otherwise
   */
  boolean isSubtree(TreeNode root, TreeNode subRoot);

  /**
   * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes
   * in the BST.
   *
   * <p>According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
   * between two nodes p and q as the lowest node in T that has both p and q as descendants (where
   * we allow a node to be a descendant of itself).”
   *
   * @param root root of a binary search tree
   * @param p first value to find the lowest ancestor for
   * @param q second value to find the lowest ancestor for
   * @return the lowst common ancestor
   */
  Integer lowestCommonAncestor(TreeNode root, Integer p, Integer q);

  /**
   * Given the root of a binary tree, return the level order traversal of its node's values. (i.e.,
   * from left to right, level by level).
   *
   * @param root root of a binary tree
   * @return the level order traversal of its node's values
   */
  List<List<Integer>> levelOrder(TreeNode root);

  /**
   * Given the root of a binary tree, imagine yourself standing on the right side of it, return the
   * values of the nodes you can see ordered from top to bottom.
   *
   * @param root root of a binary tree
   * @return list of nodes you can see from right from top to bottom
   */
  List<Integer> rightSideView(TreeNode root);

  /**
   * Given a binary tree root, a node X in the tree is named good if in the path from root to X
   * there are no nodes with a value greater than X.
   *
   * <p>Return the number of good nodes in the binary tree.
   *
   * @param root root of a binary tree
   * @return number of good nodes
   */
  int goodNodes(TreeNode root);

  class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
      this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public int getVal() {
      return val;
    }

    public TreeNode getLeft() {
      return left;
    }

    public void setLeft(TreeNode left) {
      this.left = left;
    }

    public TreeNode getRight() {
      return right;
    }

    public void setRight(TreeNode right) {
      this.right = right;
    }
  }
}
