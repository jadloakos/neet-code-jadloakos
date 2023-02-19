package hu.jadloakos.solution;

import hu.jadloakos.problem.BinarySearchProblems;

import java.util.Arrays;

/** Solutions for problems in {@link BinarySearchProblems}. */
public class BinarySearchSolutions implements BinarySearchProblems {

  @Override
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (right != left) {
      var check = Math.floorDiv(right + left, 2);
      if (nums[check] == target) {
        return check;
      }

      if (nums[check] < target) {
        left = check + 1;
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

    while (head != tail) {
      var check = Math.floorDiv(head + tail, 2);
      var valueAtCheck = matrix[check / matrix.length][check % matrix.length];
      if (valueAtCheck == target) {
        return true;
      }

      if (valueAtCheck < target) {
        tail = check + 1;
      } else {
        head = check;
      }
    }

    var valueAtHead = matrix[head / matrix.length][head % matrix.length];
    return valueAtHead == target;
  }

  @Override
  public int minEatingSpeed(int[] piles, int h) {
    Arrays.sort(piles);
    int tail = piles[0];
    int head = piles[piles.length - 1];
    while (head != tail) {
      var check = Math.floorDiv(head + tail, 2);
      var eatCount = 0;
      for (int pile : piles) {
        eatCount += pile / check + (pile % check > 0 ? 1 : 0);
      }

      if (eatCount <= h) {
        head = check;
      } else {
        tail = check + 1;
      }
    }

    return tail;
  }

  @Override
  public int findMin(int[] nums) {
    int tail = 0;
    int head = nums.length - 1;

    int lastTail = nums[tail];
    int rotate = nums.length;

    while (nums[tail] > nums[head]) {
      rotate = (int) Math.ceil((double) rotate / 2);
      if (nums[tail] < lastTail) {
        lastTail = nums[tail];
        tail = tail - rotate;
        if (tail < 0) {
          tail = nums.length - tail;
        }

        head = head - rotate;
        if (head < 0) {
          head = nums.length - head;
        }
      } else {
        lastTail = nums[tail];
        tail = tail + rotate;
        if (tail >= nums.length) {
          tail = tail - nums.length;
        }

        head = head + rotate;
        if (head >= nums.length) {
          head = head - nums.length;
        }
      }
    }

    return nums[tail];
  }
}
