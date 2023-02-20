package hu.jadloakos.solution;

import hu.jadloakos.problem.SlidingWindowProblems;

/** Solutions for problems in {@link SlidingWindowProblems}. */
public class SlidingWindowSolutions implements SlidingWindowProblems {

  @Override
  public int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }

    var maxProfit = 0;
    var maxPriceAtIndex = prices[prices.length - 1];
    for (int i = prices.length - 2; i >= 0; i--) {
      var price = prices[i];

      maxProfit = Math.max(maxProfit, maxPriceAtIndex - price);
      maxPriceAtIndex = Math.max(maxPriceAtIndex, price);
    }

    return maxProfit;
  }

  @Override
  public int lengthOfLongestSubstring(String s) {
    if (s.length() < 2) {
      return s.length();
    }

    var chars = s.toCharArray();
    var longestCharCount = 1;
    var tail = 0;
    var head = 1;

    while (head < s.length()) {
      var charAtHead = s.charAt(head);
      var matchingIndex = search(chars, tail, head, charAtHead);
      if (matchingIndex == -1) {
        longestCharCount = Math.max(longestCharCount, head - tail + 1);
      } else {
        tail = matchingIndex + 1;
      }

      head++;
    }

    return longestCharCount;
  }

  private int search(char[] chars, int from, int to, char character) {
    for (int i = from; i < to; i++) {
      if (chars[i] == character) {
        return i;
      }
    }

    return -1;
  }
}
