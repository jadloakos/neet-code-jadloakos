package hu.jadloakos.problem;

/** Interface for binary search problems. */
public interface BinarySearchProblems {

  /**
   * Given an array of integers nums which is sorted in ascending order, and an integer target,
   * write a function to search target in nums. If target exists, then return its index. Otherwise,
   * return -1.
   *
   * <p>You must write an algorithm with O(log n) runtime complexity.
   *
   * @param nums array of numbers
   * @param target number to find
   * @return index of target, -1 otherwise
   */
  int search(int[] nums, int target);

  /**
   * You are given an m x n integer matrix with the following two properties:
   *
   * <p>Each row is sorted in non-decreasing order. The first integer of each row is greater than
   * the last integer of the previous row. Given an integer target, return true if target is in
   * matrix or false otherwise.
   *
   * <p>You must write a solution in O(log(m * n)) time complexity.
   *
   * @param matrix the matrix
   * @param target value to find
   * @return true if matrix contains target, false otherwise
   */
  boolean searchMatrix(int[][] matrix, int target);

  /**
   * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The
   * guards have gone and will come back in h hours.
   *
   * <p>Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of
   * bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of
   * them instead and will not eat any more bananas during this hour.
   *
   * <p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards
   * return.
   *
   * <p>Return the minimum integer k such that she can eat all the bananas within h hours.
   *
   * @param piles n piles of bananas where ith pile has piles[i] bananas
   * @param h hours till the guards come back
   * @return the minimum bananas-per-hour eating speed to eat all bananas
   */
  int minEatingSpeed(int[] piles, int h);

  /**
   * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For
   * example, the array nums = [0,1,2,4,5,6,7] might become:
   *
   * <p>[4,5,6,7,0,1,2] if it was rotated 4 times. [0,1,2,4,5,6,7] if it was rotated 7 times. Notice
   * that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1],
   * a[0], a[1], a[2], ..., a[n-2]].
   *
   * <p>Given the sorted rotated array nums of unique elements, return the minimum element of this
   * array.
   *
   * <p>You must write an algorithm that runs in O(log n) time.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Input: nums = [3,4,5,1,2]
   *   <li>Output: 1
   *   <li>Explanation: The original array was [1,2,3,4,5] rotated 3 times.
   * </ul>
   *
   * @param nums rotated array of nums
   * @return minimum element
   */
  int findMin(int[] nums);

  /**
   * There is an integer array nums sorted in ascending order (with distinct values).
   *
   * <p>Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
   * (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1],
   * nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at
   * pivot index 3 and become [4,5,6,7,0,1,2].
   *
   * <p>Given the array nums after the possible rotation and an integer target, return the index of
   * target if it is in nums, or -1 if it is not in nums.
   *
   * <p>You must write an algorithm with O(log n) runtime complexity.
   *
   * @param nums rotated array of nums
   * @param target target to find
   * @return index of target
   */
  int searchRotated(int[] nums, int target);
}
