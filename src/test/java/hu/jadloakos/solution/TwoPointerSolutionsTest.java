package hu.jadloakos.solution;

import hu.jadloakos.problem.TwoPointerProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
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
    assertArrayEquals(new int[] {2, 3}, twoPointerSolutions.twoSum(new int[] {1, 2, -1}, 1));
  }

  @SuppressWarnings("unchecked")
  @Test
  void testThreeSum() {
    // Arrange && Act && Assert
    assertThat(
        twoPointerSolutions.threeSum(new int[] {-1, 0, 1, 2, -1, -4}),
        containsInAnyOrder(containsInAnyOrder(-1, 2, -1), containsInAnyOrder(-1, 0, 1)));
    assertThat(twoPointerSolutions.threeSum(new int[] {0, 1, 1}), empty());
    assertEquals(List.of(List.of(0, 0, 0)), twoPointerSolutions.threeSum(new int[] {0, 0, 0}));
  }

  @Test
  void testMaxArea() {
    // Arrange && Act && Assert
    assertEquals(49, twoPointerSolutions.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    assertEquals(1, twoPointerSolutions.maxArea(new int[] {1, 1}));
  }

  @Test
  void testTrap() {
    // Arrange && Act && Assert
    assertEquals(6, twoPointerSolutions.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    assertEquals(9, twoPointerSolutions.trap(new int[] {4, 2, 0, 3, 2, 5}));
    assertEquals(17, twoPointerSolutions.trap(new int[] {3, 1, 1, 1, 1, 4, 3, 4, 1, 1, 1, 1, 3}));
    assertEquals(15, twoPointerSolutions.trap(new int[] {6, 1, 1, 1, 7}));
    assertEquals(0, twoPointerSolutions.trap(new int[] {0, 1, 10, 1, 0}));
    assertEquals(0, twoPointerSolutions.trap(new int[] {0, 1, 2, 3, 10}));
    assertEquals(4, twoPointerSolutions.trap(new int[] {0, 1, 2, 6, 2, 6, 3, 0}));
    assertEquals(0, twoPointerSolutions.trap(new int[] {1, 1, 2, 2, 2, 1, 1}));
    assertEquals(0, twoPointerSolutions.trap(new int[] {1, 2, 3, 4, 3, 2, 1}));
  }
}
