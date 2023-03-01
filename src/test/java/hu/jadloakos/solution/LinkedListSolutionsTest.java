package hu.jadloakos.solution;

import hu.jadloakos.problem.LinkedListProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Test class for {@link LinkedListSolutions} */
public class LinkedListSolutionsTest {

  private LinkedListProblems linkedListSolutions;

  @BeforeEach
  void setup() {
    linkedListSolutions = new LinkedListSolutions();
  }

  @Test
  void testReverseList() {
    // Arrange & Act & Assert
    assertListNode(
        new int[] {5, 4, 3, 2, 1},
        linkedListSolutions.reverseList(buildListNode(new int[] {1, 2, 3, 4, 5})));
    assertListNode(
        new int[] {2, 1}, linkedListSolutions.reverseList(buildListNode(new int[] {1, 2})));
    assertListNode(new int[] {}, linkedListSolutions.reverseList(buildListNode(new int[] {})));
  }

  @Test
  void testMergeTwoLists() {
    // Arrange & Act & Assert
    assertListNode(
        new int[] {1, 1, 2, 3, 4, 4},
        linkedListSolutions.mergeTwoLists(
            buildListNode(new int[] {1, 2, 4}), buildListNode(new int[] {1, 3, 4})));
    assertListNode(
        new int[] {},
        linkedListSolutions.mergeTwoLists(
            buildListNode(new int[] {}), buildListNode(new int[] {})));
    assertListNode(
        new int[] {0},
        linkedListSolutions.mergeTwoLists(
            buildListNode(new int[] {}), buildListNode(new int[] {0})));
  }

  @Test
  void testReorderList() {
    // Arrange
    var listNodeOne = buildListNode(new int[] {1, 2, 3, 4});
    var listNodeTwo = buildListNode(new int[] {1, 2, 3, 4, 5});

    // Act
    linkedListSolutions.reorderList(listNodeOne);
    linkedListSolutions.reorderList(listNodeTwo);

    // Assert
    assertListNode(new int[] {1, 4, 2, 3}, listNodeOne);
    assertListNode(new int[] {1, 5, 2, 4, 3}, listNodeTwo);
  }

  @Test
  void testRemoveNthFromEnd() {
    // Arrange & Act & Assert
    assertListNode(
        new int[] {1, 2, 3, 5},
        linkedListSolutions.removeNthFromEnd(buildListNode(new int[] {1, 2, 3, 4, 5}), 2));
    assertListNode(
        new int[] {}, linkedListSolutions.removeNthFromEnd(buildListNode(new int[] {1}), 1));
    assertListNode(
        new int[] {1}, linkedListSolutions.removeNthFromEnd(buildListNode(new int[] {1, 2}), 1));
  }

  @Test
  void testAddTwoNumbers() {
    // Arrange & Act & Assert
    assertListNode(
        new int[] {7, 0, 8},
        linkedListSolutions.addTwoNumbers(
            buildListNode(new int[] {2, 4, 3}), buildListNode(new int[] {5, 6, 4})));
    assertListNode(
        new int[] {0},
        linkedListSolutions.addTwoNumbers(
            buildListNode(new int[] {0}), buildListNode(new int[] {0})));
    assertListNode(
        new int[] {8, 9, 9, 9, 0, 0, 0, 1},
        linkedListSolutions.addTwoNumbers(
            buildListNode(new int[] {9, 9, 9, 9, 9, 9, 9}), buildListNode(new int[] {9, 9, 9, 9})));
  }

  private void assertListNode(int[] values, LinkedListProblems.ListNode head) {
    int i = 0;
    while (head != null) {
      assertEquals(values[i], head.getVal());
      head = head.getNext();
      i++;
    }

    assert i == values.length;
  }

  private LinkedListProblems.ListNode buildListNode(int[] values) {
    if (values == null || values.length == 0) {
      return null;
    }

    var head = new LinkedListProblems.ListNode(values[values.length - 1]);
    for (int i = values.length - 2; i >= 0; i--) {
      head = new LinkedListProblems.ListNode(values[i], head);
    }

    return head;
  }
}
