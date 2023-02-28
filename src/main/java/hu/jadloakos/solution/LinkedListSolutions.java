package hu.jadloakos.solution;

import hu.jadloakos.problem.LinkedListProblems;

/** Solutions for problems in {@link LinkedListProblems}. */
public class LinkedListSolutions implements LinkedListProblems {

  @Override
  public ListNode reverseList(ListNode head) {
    ListNode previous = null;
    ListNode current;
    while (head.getNext() != null) {
      current = head;
      head = head.getNext();
      current.setNext(previous);
      previous = current;
    }

    return head;
  }
}
