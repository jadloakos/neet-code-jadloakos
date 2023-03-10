package hu.jadloakos.solution;

import hu.jadloakos.problem.BinaryTreeProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.junit.jupiter.api.Assertions.*;

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
        new Integer[] {4, 7, 2, 9, 6, 3, 1},
        binaryTreeSolutions.invertTree(buildTree(new Integer[] {4, 2, 7, 1, 3, 6, 9})));
    assertTree(
        new Integer[] {2, 3, 1},
        binaryTreeSolutions.invertTree(buildTree(new Integer[] {2, 1, 3})));
    assertTree(new Integer[] {}, binaryTreeSolutions.invertTree(buildTree(new Integer[] {})));
    assertTree(
        new Integer[] {3, 20, 9, 7, 15, null, null},
        binaryTreeSolutions.invertTree(buildTree(new Integer[] {3, 9, 20, null, null, 15, 7})));
  }

  @Test
  void testMaxDepth() {
    assertEquals(
        3, binaryTreeSolutions.maxDepth(buildTree(new Integer[] {3, 9, 20, null, null, 15, 7})));
    assertEquals(2, binaryTreeSolutions.maxDepth(buildTree(new Integer[] {1, null, 2})));
  }

  @Test
  void testDiameterOfBinaryTree() {
    // Arrange & Act & Assert
    assertEquals(
        3, binaryTreeSolutions.diameterOfBinaryTree(buildTree(new Integer[] {1, 2, 3, 4, 5})));
    assertEquals(1, binaryTreeSolutions.diameterOfBinaryTree(buildTree(new Integer[] {1, 2})));
    assertEquals(
        3,
        binaryTreeSolutions.diameterOfBinaryTree(
            buildTree(
                new Integer[] {1, 2, null, 3, 4, null, null, null, null, null, 1, null, null})));
  }

  @Test
  void testIsBalanced() {
    // Arrange & Act & Assert
    assertTrue(
        binaryTreeSolutions.isBalanced(buildTree(new Integer[] {3, 9, 20, null, null, 15, 7})));
    assertFalse(
        binaryTreeSolutions.isBalanced(buildTree(new Integer[] {1, 2, 2, 3, 3, null, null, 4, 4})));
    assertTrue(binaryTreeSolutions.isBalanced(buildTree(new Integer[] {})));
  }

  @Test
  void testSameTree() {
    // Arrange & Act & Assert
    assertTrue(
        binaryTreeSolutions.isSameTree(
            buildTree(new Integer[] {1, 2, 3}), buildTree(new Integer[] {1, 2, 3})));
    assertFalse(
        binaryTreeSolutions.isSameTree(
            buildTree(new Integer[] {1, 2}), buildTree(new Integer[] {1, null, 2})));
    assertFalse(
        binaryTreeSolutions.isSameTree(
            buildTree(new Integer[] {1, 2, 1}), buildTree(new Integer[] {1, 1, 2})));
  }

  @Test
  void testIsSubTree() {
    // Arrange & Act & Assert
    assertTrue(
        binaryTreeSolutions.isSubtree(
            buildTree(new Integer[] {3, 4, 5, 1, 2}), buildTree(new Integer[] {4, 1, 2})));
    assertFalse(
        binaryTreeSolutions.isSubtree(
            buildTree(new Integer[] {3, 4, 5, 1, 2, null, null, null, null, 0}),
            buildTree(new Integer[] {4, 1, 2})));
  }

  @Test
  void testLowestCommonAncestor() {
    // Arrange & Act & Assert
    assertEquals(
        6,
        binaryTreeSolutions.lowestCommonAncestor(
            buildTree(new Integer[] {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}), 2, 8));
    assertEquals(
        2,
        binaryTreeSolutions.lowestCommonAncestor(
            buildTree(new Integer[] {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}), 2, 4));
    assertEquals(
        2, binaryTreeSolutions.lowestCommonAncestor(buildTree(new Integer[] {2, 1}), 2, 1));
  }

  @SuppressWarnings("unchecked")
  @Test
  void testLevelOrder() {
    // Arrange & Act & Assert
    assertThat(
        binaryTreeSolutions.levelOrder(buildTree(new Integer[] {3, 9, 20, null, null, 15, 7})),
        contains(contains(3), contains(9, 20), contains(15, 7)));
    assertThat(binaryTreeSolutions.levelOrder(buildTree(new Integer[] {1})), contains(contains(1)));
    assertThat(binaryTreeSolutions.levelOrder(buildTree(new Integer[] {})), empty());
  }

  @Test
  void testRightSideView() {
    // Arrange & Act & Assert
    assertThat(
        binaryTreeSolutions.rightSideView(
            buildTree(new Integer[] {1, 2, 3, null, 5, null, 4, null, null, 7})),
        contains(1, 3, 4, 7));
    assertThat(
        binaryTreeSolutions.rightSideView(buildTree(new Integer[] {1, null, 3})), contains(1, 3));
    assertThat(binaryTreeSolutions.rightSideView(buildTree(new Integer[] {})), empty());
  }

  @Test
  void testGoodNodes() {
    // Arrange & Act & Assert
    assertEquals(
        4, binaryTreeSolutions.goodNodes(buildTree(new Integer[] {3, 1, 4, 3, null, 1, 5})));
    assertEquals(3, binaryTreeSolutions.goodNodes(buildTree(new Integer[] {3, 3, null, 4, 2})));
    assertEquals(1, binaryTreeSolutions.goodNodes(buildTree(new Integer[] {1})));
  }

  private BinaryTreeProblems.TreeNode buildTree(Integer[] values) {
    if (values == null || values.length == 0) {
      return null;
    }

    var root = new BinaryTreeProblems.TreeNode(values[0]);

    for (int i = 1; i < values.length; i++) {
      if (values[i] == null) {
        continue;
      }

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

  private void assertTree(Integer[] values, BinaryTreeProblems.TreeNode root) {
    if (values == null || values.length == 0) {
      assert root == null;
      return;
    }

    assert Arrays.stream(values).filter(Objects::nonNull).count() == getTreeSize(root);
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
            if (values[i] == null) {
              assert parent.getRight() == null;
            } else {
              assert parent.getRight().getVal() == values[i];
            }
          }
          indexInLvl -= bisector;
        } else {
          if (lvl != 1) {
            parent = parent.getLeft();
          } else {
            if (values[i] == null) {
              assert parent.getLeft() == null;
            } else {
              assert parent.getLeft().getVal() == values[i];
            }
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
