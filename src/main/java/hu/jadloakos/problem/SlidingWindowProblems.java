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

  /**
   * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false
   * otherwise.
   *
   * <p>In other words, return true if one of s1's permutations is the substring of s2.
   *
   * @param s1 first string
   * @param s2 second string
   * @return true if s1's permutations is the substring of s2, false otherwise
   */
  boolean checkInclusion(String s1, String s2);

  /**
   * Given two strings s and t of lengths m and n respectively, return the minimum window substring
   * of s such that every character in t (including duplicates) is included in the window. If there
   * is no such substring, return the empty string "".
   *
   * <p>The testcases will be generated such that the answer is unique.
   *
   * @param s string to find minimum window in
   * @param t characters to find in s
   * @return the minimum window
   */
  String minWindow(String s, String t);
}
