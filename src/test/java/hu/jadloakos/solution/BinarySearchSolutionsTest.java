package hu.jadloakos.solution;

import hu.jadloakos.problem.BinarySearchProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Test class for {@link BinarySearchSolutions}. */
public class BinarySearchSolutionsTest {

  private BinarySearchProblems binarySearchSolutions;

  @BeforeEach
  void setup() {
    binarySearchSolutions = new BinarySearchSolutions();
  }

  @Test
  void testSearch() {
    // Arrange & Act & Assert
    assertEquals(4, binarySearchSolutions.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
    assertEquals(-1, binarySearchSolutions.search(new int[] {-1, 0, 3, 5, 9, 12}, 2));
  }

  @Test
  void testSearchMatrix() {
    // Arrange & Act & Assert
    assertTrue(
        binarySearchSolutions.searchMatrix(
            new int[][] {
              new int[] {1, 3, 5, 7},
              new int[] {10, 11, 16, 20},
              new int[] {23, 30, 34, 60}
            },
            3));
    assertFalse(
        binarySearchSolutions.searchMatrix(
            new int[][] {
              new int[] {1, 3, 5, 7},
              new int[] {10, 11, 16, 20},
              new int[] {23, 30, 34, 60}
            },
            13));
  }

  @Test
  void testMinEatingSpeed() {
    // Arrange & Act & Assert
    assertEquals(4, binarySearchSolutions.minEatingSpeed(new int[] {3, 6, 7, 11}, 8));
    assertEquals(30, binarySearchSolutions.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 5));
    assertEquals(23, binarySearchSolutions.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 6));
  }
}
