package hu.jadloakos.solution;

import hu.jadloakos.problem.LinkedListProblems;

import java.util.Stack;

/** Solutions for problems in {@link LinkedListProblems}. */
public class LinkedListSolutions implements LinkedListProblems {

  @Override
  public ListNode reverseList(ListNode head) {
    ListNode previous = null;
    ListNode current = null;
    while (head != null) {
      current = head;
      head = head.getNext();
      current.setNext(previous);
      previous = current;
    }

    return current;
  }

  @Override
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode root = null;
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
        root = head;
        continue;
      }

      head.setNext(smaller);
      head = smaller;
    }

    return root;
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
        stackTop.setNext(null);
        return;
      }

      stackTop.setNext(next);
      node = next;
    }

    node.setNext(null);
  }

  @Override
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode previous = null;
    ListNode nodeToRemove = null;
    var currentNode = head;

    for (int i = 1; currentNode != null; i++) {
      if (i >= n) {
        previous = nodeToRemove;
        nodeToRemove = nodeToRemove == null ? head : nodeToRemove.getNext();
      }

      currentNode = currentNode.getNext();
    }

    if (previous == null) {
      if (nodeToRemove != null) {
        return nodeToRemove.getNext() != null ? nodeToRemove.getNext() : null;
      }

      return head;
    }

    previous.setNext(nodeToRemove.getNext());
    nodeToRemove.setNext(null);

    return head;
  }
}
