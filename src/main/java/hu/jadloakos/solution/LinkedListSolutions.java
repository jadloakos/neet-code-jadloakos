package hu.jadloakos.solution;

import hu.jadloakos.problem.LinkedListProblems;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Optional;
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

  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    l1 = reverseList(l1);
    l2 = reverseList(l2);

    var leftOver = 0;
    ListNode currentNode = null;
    ListNode head = null;

    while (l1 != null || l2 != null) {
      var sum =
          Optional.ofNullable(l1).map(ListNode::getVal).orElse(0)
              + Optional.ofNullable(l2).map(ListNode::getVal).orElse(0)
              + leftOver;
      leftOver = sum / 10;

      if (currentNode == null) {
        currentNode = new ListNode(sum % 10);
        head = currentNode;
      } else {
        var next = new ListNode(sum % 10);
        currentNode.setNext(next);
        currentNode = next;
      }

      if (l1 != null) {
        l1 = l1.getNext();
      }
      if (l2 != null) {
        l2 = l2.getNext();
      }
    }

    if (leftOver != 0) {
      currentNode.setNext(new ListNode(1));
    }

    return head;
  }

  @Override
  public boolean hasCycle(ListNode head) {
    var identitySet = Collections.newSetFromMap(new IdentityHashMap<>());
    while (head != null) {
      if (!identitySet.add(head)) {
        return true;
      }
      head = head.getNext();
    }
    return false;
  }
}
