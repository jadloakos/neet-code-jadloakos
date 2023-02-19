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

  @Test
  void findMin() {
    // Arrange & Act & Assert
    assertEquals(1, binarySearchSolutions.findMin(new int[] {3, 4, 5, 1, 2}));
    assertEquals(0, binarySearchSolutions.findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
    assertEquals(11, binarySearchSolutions.findMin(new int[] {11, 13, 15, 17}));
    assertEquals(2, binarySearchSolutions.findMin(new int[] {3, 4, 2}));
    assertEquals(
        2, binarySearchSolutions.findMin(new int[] {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 2}));
  }

  @Test
  void testSearchRotated() {
    // Arrange & Act & Assert
    assertEquals(4, binarySearchSolutions.searchRotated(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    assertEquals(-1, binarySearchSolutions.searchRotated(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
    assertEquals(-1, binarySearchSolutions.searchRotated(new int[] {1}, 0));
  }

  @Test
  void testGetTimeMap() {
    var timeMap = binarySearchSolutions.getTimeMap();
    timeMap.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1.
    // return "bar"
    assertEquals("bar", timeMap.get("foo", 1));
    // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2,
    // then the only value is at timestamp 1 is "bar".
    assertEquals("bar", timeMap.get("foo", 3));
    timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
    // return "bar2"
    assertEquals("bar2", timeMap.get("foo", 4));
    // return "bar2"
    assertEquals("bar2", timeMap.get("foo", 5));
  }
}
