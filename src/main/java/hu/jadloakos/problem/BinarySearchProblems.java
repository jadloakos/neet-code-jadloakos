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
}
