package hu.jadloakos.solution;

import hu.jadloakos.problem.SlidingWindowProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Test class for {@link hu.jadloakos.solution.SlidingWindowSolutions} */
public class SlidingWindowSolutionsTest {

  private SlidingWindowProblems slidingWindowSolutions;

  @BeforeEach
  void setup() {
    slidingWindowSolutions = new SlidingWindowSolutions();
  }

  @Test
  void testMaxProfit() {
    // Arrange & Act & Assert
    assertEquals(5, slidingWindowSolutions.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    assertEquals(0, slidingWindowSolutions.maxProfit(new int[] {7, 6, 4, 3, 1}));
  }

  @Test
  void testLengthOfLongestSubstring() {
    assertEquals(3, slidingWindowSolutions.lengthOfLongestSubstring("abcabcbb"));
    assertEquals(1, slidingWindowSolutions.lengthOfLongestSubstring("bbbbb"));
    assertEquals(3, slidingWindowSolutions.lengthOfLongestSubstring("pwwkew"));
  }
}
