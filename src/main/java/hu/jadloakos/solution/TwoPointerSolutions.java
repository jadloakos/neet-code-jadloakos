package hu.jadloakos.solution;

import hu.jadloakos.problem.TwoPointerProblems;

/** Solutions for problems in {@link TwoPointerProblems}. */
public class TwoPointerSolutions implements TwoPointerProblems {

  @Override
  public boolean isPalindrome(String s) {
    var uppercase = s.toLowerCase();

    for (int tail = 0, head = uppercase.length() - 1; tail < head; ) {
      var charAtTail = uppercase.charAt(tail);
      if (!Character.isDigit(charAtTail) && !Character.isAlphabetic(charAtTail)) {
        tail++;
        continue;
      }

      var charAtHead = uppercase.charAt(head);
      if (!Character.isDigit(charAtHead) && !Character.isAlphabetic(charAtHead)) {
        head--;
        continue;
      }

      if (charAtHead != charAtTail) {
        return false;
      }

      tail++;
      head--;
    }

    return true;
  }
}
