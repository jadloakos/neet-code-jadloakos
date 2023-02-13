package hu.jadloakos.solution;

import hu.jadloakos.problem.ArraysAndHashing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

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

  @Test
  public void testGroupAnagrams() {
    // Arrange
    var strs = new String[] {"asd", "dsa", "qwe"};

    // Act
    var result = arraysAndHashing.groupAnagrams(strs);

    // Assert
    var qweGroupIndex = result.get(0).size() == 1 ? 0 : 1;
    var asdGroupIndex = qweGroupIndex == 0 ? 1 : 0;

    assertEquals(List.of("qwe"), result.get(qweGroupIndex));
    assertThat(
        result.get(asdGroupIndex), anyOf(is(List.of("asd", "dsa")), is(List.of("dsa", "asd"))));
  }

  @Test
  public void testTopKFrequent() {
    // Arrange
    var nums = new int[] {1, 1, 1, 2, 2, 3};
    var k = 2;

    // Act & Assert
    assertThat(
        arraysAndHashing.topKFrequent(nums, k), anyOf(is(new int[] {1, 2}), is(new int[] {2, 1})));
  }

  @Test
  public void testProductExceptSelf() {
    // Arrange
    var nums = new int[] {-1, 1, 0, -3, 3};

    // Act & Assert
    assertArrayEquals(new int[] {0, 0, 9, 0, 0}, arraysAndHashing.productExceptSelf(nums));
  }

  @Test
  public void testIsValidSudoku() {
    // Arrange
    var validBoard =
        new char[][] {
          new char[] {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
          new char[] {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          new char[] {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          new char[] {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          new char[] {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          new char[] {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          new char[] {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          new char[] {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          new char[] {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
    var invalidBoard =
        new char[][] {
          new char[] {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
          new char[] {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          new char[] {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          new char[] {'5', '.', '.', '.', '6', '.', '.', '.', '3'},
          new char[] {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          new char[] {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          new char[] {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          new char[] {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          new char[] {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

    // Act & Assert
    assertTrue(arraysAndHashing.isValidSudoku(validBoard));
    assertFalse(arraysAndHashing.isValidSudoku(invalidBoard));
  }

  @Test
  public void testEncodeDecode() {
    // Arrange
    var input = List.of("lint", "code", "love", "you");
    var harderInput = List.of("we", "say", ":", "yes");

    // Act & Assert
    assertEquals(input, arraysAndHashing.decode(arraysAndHashing.encode(input)));
    assertEquals(harderInput, arraysAndHashing.decode(arraysAndHashing.encode(harderInput)));
  }
}
