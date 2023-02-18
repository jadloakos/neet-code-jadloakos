package hu.jadloakos.solution;

import hu.jadloakos.problem.BinarySearchProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
