package hu.jadloakos.problem;

/** Interface for linked list problems. */
public interface LinkedListProblems {

  /**
   * Given the head of a singly linked list, reverse the list, and return the reversed list.
   *
   * @param head the head
   * @return reversed list
   */
  ListNode reverseList(ListNode head);

  /**
   * You are given the heads of two sorted linked lists list1 and list2.
   *
   * <p>Merge the two lists in a one sorted list. The list should be made by splicing together the
   * nodes of the first two lists.
   *
   * <p>Return the head of the merged linked list.
   *
   * @param list1 first sorted list
   * @param list2 second sorted list
   * @return combined sorted list
   */
  ListNode mergeTwoLists(ListNode list1, ListNode list2);

  /**
   * You are given the head of a singly linked-list. The list can be represented as:
   *
   * <p>L0 → L1 → … → Ln - 1 → Ln Reorder the list to be on the following form:
   *
   * <p>L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … You may not modify the values in the list's nodes.
   * Only nodes themselves may be changed.
   *
   * @param head head of the list to reorder
   */
  void reorderList(ListNode head);

  /**
   * Given the head of a linked list, remove the nth node from the end of the list and return its
   * head.
   *
   * @param head head of a linked list
   * @param n index of node counted from the end
   * @return head of the linked list with node removed
   */
  ListNode removeNthFromEnd(ListNode head, int n);

  /**
   * You are given two non-empty linked lists representing two non-negative integers. The digits are
   * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers
   * and return the sum as a linked list.
   *
   * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
   *
   * @param l1 first linked list
   * @param l2 second linked list
   * @return sum as a linked list
   */
  ListNode addTwoNumbers(ListNode l1, ListNode l2);

  /**
   * Given head, the head of a linked list, determine if the linked list has a cycle in it.
   *
   * <p>There is a cycle in a linked list if there is some node in the list that can be reached
   * again by continuously following the next pointer. Internally, pos is used to denote the index
   * of the node that tail's next pointer is connected to. Note that pos is not passed as a
   * parameter.
   *
   * <p>Return true if there is a cycle in the linked list. Otherwise, return false.
   *
   * @param head head of a linked list
   * @return true if the list has a cycle in it, false otherwise
   */
  boolean hasCycle(ListNode head);

  class ListNode {

    int val;

    ListNode next;

    public ListNode() {}

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    public int getVal() {
      return val;
    }

    public ListNode getNext() {
      return next;
    }

    public void setNext(ListNode next) {
      this.next = next;
    }
  }
}
