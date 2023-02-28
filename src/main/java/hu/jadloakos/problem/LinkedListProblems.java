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
