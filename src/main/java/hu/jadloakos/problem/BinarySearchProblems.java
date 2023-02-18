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
}
