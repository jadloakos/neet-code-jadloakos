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
}