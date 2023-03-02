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
