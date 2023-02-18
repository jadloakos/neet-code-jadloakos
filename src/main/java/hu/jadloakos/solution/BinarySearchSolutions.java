package hu.jadloakos.solution;

import hu.jadloakos.problem.BinarySearchProblems;

/** Solutions for problems in {@link BinarySearchProblems}. */
public class BinarySearchSolutions implements BinarySearchProblems {

  @Override
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (right - left > 1) {
      var check = Math.floorDiv(right + left, 2);
      if (nums[check] == target) {
        return check;
      }

      if (nums[check] < target) {
        left = check;
      } else {
        right = check;
      }
    }

    return nums[right] == target ? right : -1;
  }
}
