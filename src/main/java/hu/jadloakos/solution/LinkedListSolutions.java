package hu.jadloakos.solution;

import hu.jadloakos.problem.LinkedListProblems;

import java.util.Stack;

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

  @Override
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = null;
    while (list1 != null || list2 != null) {
      ListNode smaller;
      if (list1 == null) {
        smaller = list2;
        list2 = list2.getNext();
      } else if (list2 == null) {
        smaller = list1;
        list1 = list1.getNext();
      } else if (list1.getVal() < list2.getVal()) {
        smaller = list1;
        list1 = list1.getNext();
      } else {
        smaller = list2;
        list2 = list2.getNext();
      }

      if (head == null) {
        head = smaller;
        continue;
      }

      head.setNext(smaller);
      head = smaller;
    }

    return head;
  }

  @Override
  public void reorderList(ListNode head) {
    Stack<ListNode> stack = new Stack<>();

    var node = head;
    while (node != null) {
      stack.push(node);
      node = node.getNext();
    }

    node = head;
    while (node != stack.peek()) {
      var next = node.getNext();
      var stackTop = stack.pop();
      node.setNext(stackTop);
      if (stackTop == next) {
        break;
      }
      node = next;
    }
  }

  @Override
  public ListNode removeNthFromEnd(ListNode head, int n) {
    return null;
  }
}
