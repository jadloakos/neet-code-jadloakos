package hu.jadloakos.solution;

import hu.jadloakos.problem.SlidingWindowProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

  @Test
  void testCharacterReplacement() {
    // Arrange & Act & Assert
    assertEquals(4, slidingWindowSolutions.characterReplacement("ABAB", 2));
    assertEquals(4, slidingWindowSolutions.characterReplacement("AABABBA", 1));
    assertEquals(6, slidingWindowSolutions.characterReplacement("ABCDEEEEE", 1));
  }

  @Test
  void testCheckInclusion() {
    assertTrue(slidingWindowSolutions.checkInclusion("ab", "eidbaooo"));
    assertFalse(slidingWindowSolutions.checkInclusion("ab", "eidboaoo"));
  }

  @Test
  void testMinWindow() {
    assertEquals("BANC", slidingWindowSolutions.minWindow("ADOBECODEBANC", "ABC"));
    assertEquals("a", slidingWindowSolutions.minWindow("a", "a"));
    assertEquals("", slidingWindowSolutions.minWindow("a", "aa"));
  }

  @Test
  void testMaxSlidingWindow() {
    // Arrange & Act & Assert
    assertArrayEquals(
        new int[] {3, 3, 5, 5, 6, 7},
        slidingWindowSolutions.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
    assertArrayEquals(new int[] {1}, slidingWindowSolutions.maxSlidingWindow(new int[] {1}, 1));
  }
}
