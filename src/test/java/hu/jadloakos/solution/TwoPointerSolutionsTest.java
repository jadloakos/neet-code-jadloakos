package hu.jadloakos.solution;

import hu.jadloakos.problem.TwoPointerProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Test class for {@link TwoPointerSolutions} */
class TwoPointerSolutionsTest {

  private TwoPointerProblems twoPointerSolutions;

  @BeforeEach
  void setup() {
    twoPointerSolutions = new TwoPointerSolutions();
  }

  @Test
  void testIsPalindrome() {
    // Arrange && Act && Assert
    assertTrue(twoPointerSolutions.isPalindrome("A man, a plan, a canal: Panama"));
    assertFalse(twoPointerSolutions.isPalindrome("race a car"));
    assertTrue(twoPointerSolutions.isPalindrome(" "));
  }

  @Test
  void testTwoSum() {
    // Arrange && Act && Assert
    assertArrayEquals(new int[] {1, 2}, twoPointerSolutions.twoSum(new int[] {2, 7, 11, 15}, 9));
    assertArrayEquals(new int[] {1, 3}, twoPointerSolutions.twoSum(new int[] {2, 3, 4}, 6));
    assertArrayEquals(new int[] {1, 2}, twoPointerSolutions.twoSum(new int[] {-1, 0}, -1));
  }
}
