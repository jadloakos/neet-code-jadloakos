package hu.jadloakos.solution;

import hu.jadloakos.problem.BinaryTreeProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test class for {@link BinaryTreeSolutions}. */
public class BinaryTreeSolutionsTest {

  private BinaryTreeProblems binaryTreeSolutions;

  @BeforeEach
  void setup() {
    binaryTreeSolutions = new BinaryTreeSolutions();
  }

  @Test
  void testInvertTree() {
    // Arrange & Act & Assert
    assertTree(
        new int[] {4, 7, 2, 9, 6, 3, 1},
        binaryTreeSolutions.invertTree(buildTree(new int[] {4, 2, 7, 1, 3, 6, 9})));
    assertTree(new int[] {2, 3, 1}, binaryTreeSolutions.invertTree(buildTree(new int[] {2, 1, 3})));
    assertTree(new int[] {}, binaryTreeSolutions.invertTree(buildTree(new int[] {})));
  }

  private BinaryTreeProblems.TreeNode buildTree(int[] values) {
    if (values == null || values.length == 0) {
      return null;
    }

    var root = new BinaryTreeProblems.TreeNode(values[0]);

    for (int i = 1; i < values.length; i++) {
      var lvl = 1.0;
      var childSum = Math.pow(2, lvl);
      while (i / childSum > 1) {
        lvl++;
        childSum += Math.pow(2, lvl);
      }

      var indexInLvl = Math.pow(2, lvl) - (childSum - i);
      var parent = root;
      while (lvl > 0) {
        var bisector = Math.pow(2, lvl) / 2;
        if (bisector < indexInLvl) {
          if (lvl != 1) {
            parent = parent.getRight();
          } else {
            parent.setRight(new BinaryTreeProblems.TreeNode(values[i]));
          }
          indexInLvl -= bisector;
        } else {
          if (lvl != 1) {
            parent = parent.getLeft();
          } else {
            parent.setLeft(new BinaryTreeProblems.TreeNode(values[i]));
          }
        }
        lvl--;
      }
    }

    return root;
  }

  private void assertTree(int[] values, BinaryTreeProblems.TreeNode root) {
    if (values == null || values.length == 0) {
      assert root == null;
      return;
    }

    assert values.length == getTreeSize(root);
    assert root.getVal() == values[0];

    for (int i = 1; i < values.length; i++) {
      var lvl = 1.0;
      var childSum = Math.pow(2, lvl);
      while (i / childSum > 1) {
        lvl++;
        childSum += Math.pow(2, lvl);
      }

      var indexInLvl = Math.pow(2, lvl) - (childSum - i);
      var parent = root;
      while (lvl > 0) {
        assert parent != null;
        var bisector = Math.pow(2, lvl) / 2;
        if (bisector < indexInLvl) {
          if (lvl != 1) {
            parent = parent.getRight();
          } else {
            assert parent.getRight() != null;
            assert parent.getRight().getVal() == values[i];
          }
          indexInLvl -= bisector;
        } else {
          if (lvl != 1) {
            parent = parent.getLeft();
          } else {
            assert parent.getLeft() != null;
            assert parent.getLeft().getVal() == values[i];
          }
        }
        lvl--;
      }
    }
  }

  private int getTreeSize(BinaryTreeProblems.TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + getTreeSize(root.getLeft()) + getTreeSize(root.getRight());
  }
}
