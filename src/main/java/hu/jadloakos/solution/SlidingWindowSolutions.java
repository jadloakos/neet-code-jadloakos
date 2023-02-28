package hu.jadloakos.solution;

import hu.jadloakos.problem.SlidingWindowProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

  @Override
  public int characterReplacement(String s, int k) {
    if (s.length() < 2) {
      return s.length();
    }

    var longest = 1;
    int tail = 0;
    int head = 1;
    int remainingK = k;

    while (head < s.length()) {
      var charAtHead = s.charAt(head);
      var charAtTail = s.charAt(tail);
      if (charAtHead == charAtTail) {
        longest = Math.max(longest, Math.min(s.length(), head - tail + 1 + remainingK));
        head++;
      } else {
        if (remainingK > 0) {
          remainingK--;
          longest = Math.max(longest, Math.min(s.length(), head - tail + 1 + remainingK));
          head++;
        } else {
          tail++;
          head = tail + 1;
          remainingK = k;
        }
      }
    }

    return longest;
  }

  @Override
  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Long> charsForPermutation =
        s1.chars()
            .mapToObj(ch -> (char) ch)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    Map<Character, Long> charCounter = new HashMap<>();
    var index = 0;
    while (index < s2.length()) {
      var charAtIndex = s2.charAt(index);
      var permutationMax = charsForPermutation.get(charAtIndex);
      if (permutationMax == null) {
        charCounter.clear();
        index++;
        continue;
      }

      var newCount =
          charCounter.compute(charAtIndex, (key, value) -> (value == null ? 0L : 1L) + 1L);
      if (newCount > permutationMax) {
        charCounter.clear();
      } else if (newCount.equals(permutationMax) && charsForPermutation.equals(charCounter)) {
        return true;
      }
      index++;
    }

    return false;
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
