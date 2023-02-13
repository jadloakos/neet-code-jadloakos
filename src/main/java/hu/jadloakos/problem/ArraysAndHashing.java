package hu.jadloakos.problem;

import java.util.List;

/** Interface for arrays & hashing problems */
public interface ArraysAndHashing {

  /**
   * Given an integer array nums, return true if any value appears at least twice in the array, and
   * return false if every element is distinct.
   *
   * @param nums array of nums
   * @return true if value appears at least twice, false otherwise
   */
  boolean containsDuplicate(int[] nums);

  /**
   * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
   *
   * <p>An Anagram is a word or phrase formed by rearranging the letters of a different word or
   * phrase, typically using all the original letters exactly once.
   *
   * @param s base word
   * @param t possible anagram
   * @return true if t is an anagram of s, false otherwise
   */
  boolean isAnagram(String s, String t);

  /**
   * Given an array of integers nums and an integer target, return indices of the two numbers such
   * that they add up to target.
   *
   * <p>You may assume that each input would have exactly one solution, and you may not use the same
   * element twice.
   *
   * <p>You can return the answer in any order.
   *
   * @param nums array of integers
   * @param target the required sum
   * @return indicies of the two numbers
   */
  int[] twoSum(int[] nums, int target);

  /**
   * Given an array of strings, group the anagrams together. You can return the answer in any order.
   *
   * <p>An Anagram is a word or phrase formed by rearranging the letters of a different word or
   * phrase, typically using all the original letters exactly once.
   *
   * @param strs list of strings
   * @return grouped anagrams
   */
  List<List<String>> groupAnagrams(String[] strs);

  /**
   * Given an integer array nums and an integer k, return the k most frequent elements. You may
   * return the answer in any order.
   *
   * @param nums array of numbers
   * @param k required frequent elements
   * @return the k most frequent element
   */
  int[] topKFrequent(int[] nums, int k);

  /**
   * Given an integer array nums, return an array answer such that answer[i] is equal to the product
   * of all the elements of nums except nums[i].
   *
   * <p>The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
   *
   * <p>You must write an algorithm that runs in O(n) time and without using the division operation.
   *
   * @param nums array of nums
   * @return array of sums without num in current index
   */
  int[] productExceptSelf(int[] nums);

  /**
   * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated
   * according to the following rules:
   *
   * <p>Each row must contain the digits 1-9 without repetition. Each column must contain the digits
   * 1-9 without repetition. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits
   * 1-9 without repetition.
   *
   * <p>Note:
   *
   * <ul>
   *   <li>A Sudoku board (partially filled) could be valid but is not necessarily solvable.
   *   <li>Only the filled cells need to be validated according to the mentioned rules.
   * </ul>
   *
   * @param board sudoku board to validate
   * @return true if board is valid, false otherwise
   */
  boolean isValidSudoku(char[][] board);
}
