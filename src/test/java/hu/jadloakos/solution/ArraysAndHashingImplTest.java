package hu.jadloakos.solution;

import hu.jadloakos.problem.ArraysAndHashing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Test class for {@link ArraysAndHashingImplTest} */
public class ArraysAndHashingImplTest {

  private ArraysAndHashing arraysAndHashing;

  @BeforeEach
  public void setup() {
    arraysAndHashing = new ArraysAndHashingImpl();
  }

  @Test
  public void testContainsDuplicate() {
    // Arrange
    var noDuplicate = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    var hasDuplicate = new int[] {1, 2, 3, 4, 5, 1, 2, 3, 4};

    // Act & Assert
    assertFalse(arraysAndHashing.containsDuplicate(noDuplicate));
    assertTrue(arraysAndHashing.containsDuplicate(hasDuplicate));
  }

  @Test
  public void testIsAnagram() {
    // Arrange
    var noAnagramBase = "asd";
    var noAnagramMatch = "asw";
    var anagramBase = "asda sd123*% ";
    var anagramMatch = "dsa dsa132%* ";

    // Act & Assert
    assertFalse(arraysAndHashing.isAnagram(noAnagramBase, noAnagramMatch));
    assertTrue(arraysAndHashing.isAnagram(anagramBase, anagramMatch));
  }

  @Test
  public void testTwoSum() {
    // Arrange
    var nums = new int[] {1, 2, 2, 4, 12, 11, 7, 3, 6};
    var target = 10;

    // Act & Assert
    assertThat(
        arraysAndHashing.twoSum(nums, target), anyOf(is(new int[] {3, 8}), is(new int[] {8, 3})));
  }
}
