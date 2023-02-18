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

  @Override
  public boolean searchMatrix(int[][] matrix, int target) {
    int tail = 0;
    int head = matrix.length * matrix.length - 1;

    while (head - tail > 1) {
      var check = Math.floorDiv(head + tail, 2);
      var valueAtCheck = matrix[check / matrix.length][check % matrix.length];
      if (valueAtCheck == target) {
        return true;
      }

      if (valueAtCheck < target) {
        tail = check;
      } else {
        head = check;
      }
    }

    var valueAtHead = matrix[head / matrix.length][head % matrix.length];
    return valueAtHead == target;
  }

  @Override
  public int minEatingSpeed(int[] piles, int h) {
    return 0;
  }
}
