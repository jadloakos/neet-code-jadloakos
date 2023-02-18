package hu.jadloakos.solution;

import hu.jadloakos.problem.TwoPointerProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
