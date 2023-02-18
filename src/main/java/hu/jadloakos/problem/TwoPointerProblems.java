package hu.jadloakos.problem;

import java.util.List;

/** Interface for two pointer problems. */
public interface TwoPointerProblems {

  /**
   * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
   * removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric
   * characters include letters and numbers.
   *
   * <p>Given a string s, return true if it is a palindrome, or false otherwise.
   *
   * @param s the string to check
   * @return true if it is a palindrome, false otherwise
   */
  boolean isPalindrome(String s);

  /**
   * Given a 1-indexed array of integer numbers that is already sorted in non-decreasing order, find
   * two numbers such that they add up to a specific target number. Let these two numbers be
   * numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
   *
   * <p>Return the indices of the two numbers, index1 and index2, added by one as an integer array
   * [index1, index2] of length 2.
   *
   * <p>The tests are generated such that there is exactly one solution. You may not use the same
   * element twice.
   *
   * <p>Your solution must use only constant extra space.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Input: numbers = [2,7,11,15], target = 9
   *   <li>Output: [1,2]
   *   <li>Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1,
   *       2].
   * </ul>
   *
   * @param numbers the numbers
   * @param target the target sum
   * @return the indices adding up to sum
   */
  int[] twoSum(int[] numbers, int target);

  /**
   * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i !=
   * j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
   *
   * <p>Notice that the solution set must not contain duplicate triplets.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Inputs: nums = [-1,0,1,2,-1,-4]
   *   <li>Output: [[-1,-1,2],[-1,0,1]]
   *   <li>Explanation:
   *       <ul>
   *         <li>nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
   *         <li>nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
   *         <li>nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
   *         <li>The distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order of the
   *             output and the order of the triplets does not matter.
   *       </ul>
   * </ul>
   *
   * @param nums array of numbers
   * @return triplets without duplication
   */
  List<List<Integer>> threeSum(int[] nums);
}
