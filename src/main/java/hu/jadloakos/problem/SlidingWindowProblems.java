package hu.jadloakos.problem;

/** Interface for sliding window problems. */
public interface SlidingWindowProblems {

  /**
   * You are given an array prices where prices[i] is the price of a given stock on the ith day.
   *
   * <p>You want to maximize your profit by choosing a single day to buy one stock and choosing a
   * different day in the future to sell that stock.
   *
   * <p>Return the maximum profit you can achieve from this transaction. If you cannot achieve any
   * profit, return 0.
   *
   * @param prices array of prices
   * @return maximum profit
   */
  int maxProfit(int[] prices);

  /**
   * Given a string s, find the length of the longest substring without repeating characters.
   *
   * @param s string
   * @return length of the longest substring without repeating characters
   */
  int lengthOfLongestSubstring(String s);

  /**
   * You are given a string s and an integer k. You can choose any character of the string and
   * change it to any other uppercase English character. You can perform this operation at most k
   * times.
   *
   * <p>Return the length of the longest substring containing the same letter you can get after
   * performing the above operations.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Input: s = "ABAB", k = 2
   *   <li>Output: 4
   *   <li>Explanation: Replace the two 'A's with two 'B's or vice versa.
   * </ul>
   *
   * @param s string
   * @param k times a character can be changed to any other uppercase english character
   * @return longest substring with same letter after changes
   */
  int characterReplacement(String s, int k);
}
