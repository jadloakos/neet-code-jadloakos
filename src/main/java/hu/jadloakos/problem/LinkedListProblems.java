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

    public void setVal(int val) {
      this.val = val;
    }

    public ListNode getNext() {
      return next;
    }

    public void setNext(ListNode next) {
      this.next = next;
    }
  }
}
