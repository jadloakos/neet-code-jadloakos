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
    // Arrange
    var headOne = buildListNode(new int[] {1, 2, 3, 4, 5});
    var headTwo = buildListNode(new int[] {1, 2});
    var headThree = buildListNode(new int[] {});

    // Act & Assert
    assertListNode(new int[] {5, 4, 3, 2, 1}, linkedListSolutions.reverseList(headOne));
    assertListNode(new int[] {2, 1}, linkedListSolutions.reverseList(headTwo));
    assertListNode(new int[] {}, linkedListSolutions.reverseList(headThree));
  }

  private void assertListNode(int[] values, LinkedListProblems.ListNode head) {
    var currentHead = head;
    assert currentHead != null;

    for (int i = 0; currentHead.getNext() != null; i++) {
      assertEquals(values[i], currentHead.getVal());
      currentHead = head.getNext();
      assert currentHead != null;
    }
  }

  private LinkedListProblems.ListNode buildListNode(int[] values) {
    if (values == null || values.length == 0) {
      return new LinkedListProblems.ListNode();
    }

    var head = new LinkedListProblems.ListNode(values[values.length - 1]);
    for (int i = values.length - 2; i >= 0; i--) {
      head = new LinkedListProblems.ListNode(values[i], head);
    }

    return head;
  }
}
