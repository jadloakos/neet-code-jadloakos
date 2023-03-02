package hu.jadloakos.problem;

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
