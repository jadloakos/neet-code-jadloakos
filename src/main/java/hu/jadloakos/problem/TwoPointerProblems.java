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

  /**
   * You are given an integer array height of length n. There are n vertical lines drawn such that
   * the two endpoints of the ith line are (i, 0) and (i, height[i]).
   *
   * <p>Find two lines that together with the x-axis form a container, such that the container
   * contains the most water.
   *
   * <p>Return the maximum amount of water a container can store.
   *
   * <p>Notice that you may not slant the container.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Input: height = [1,8,6,2,5,4,8,3,7]
   *   <li>Output: 49
   *   <li>Explanation: The vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this
   *       case, the max area of water in the container can contain is 49 (area between index 1 with
   *       value 8 and index 8 with value 7).
   * </ul>
   *
   * @param height array of heights
   * @return max amount of water the container can store
   */
  int maxArea(int[] height);
}
