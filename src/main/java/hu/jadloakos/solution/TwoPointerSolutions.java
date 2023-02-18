package hu.jadloakos.solution;

import hu.jadloakos.problem.TwoPointerProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Solutions for problems in {@link TwoPointerProblems}. */
public class TwoPointerSolutions implements TwoPointerProblems {

  @Override
  public boolean isPalindrome(String s) {
    var uppercase = s.toLowerCase();

    for (int tail = 0, head = uppercase.length() - 1; tail < head; ) {
      var charAtTail = uppercase.charAt(tail);
      if (!Character.isDigit(charAtTail) && !Character.isAlphabetic(charAtTail)) {
        tail++;
        continue;
      }

      var charAtHead = uppercase.charAt(head);
      if (!Character.isDigit(charAtHead) && !Character.isAlphabetic(charAtHead)) {
        head--;
        continue;
      }

      if (charAtHead != charAtTail) {
        return false;
      }

      tail++;
      head--;
    }

    return true;
  }

  @Override
  public int[] twoSum(int[] numbers, int target) {
    if (numbers.length == 2 && numbers[0] + numbers[1] == target) {
      return new int[] {1, 2};
    }

    for (int i = 0; i < numbers.length - 1; i++) {
      var sumPairIndex = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
      if (sumPairIndex >= 0) {
        return new int[] {i + 1, sumPairIndex + 1};
      }
    }

    return null;
  }

  @Override
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) {
      return List.of();
    }

    Arrays.sort(nums);
    var sums = new ArrayList<List<Integer>>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int j = i + 1;
      while (j < nums.length - 1) {
        var twoSumArray = Arrays.copyOfRange(nums, j, nums.length);
        var result = twoSum(twoSumArray, -nums[i]);
        if (result != null) {
          sums.add(List.of(nums[i], nums[result[0] - 1 + j], nums[result[1] - 1 + j]));
          j += result[0];
        } else {
          break;
        }
      }
    }

    return sums;
  }

  @Override
  public int maxArea(int[] height) {
    var max = 0;
    for (int tail = 0, head = height.length - 1; tail < head; ) {
      var minHeight = Math.min(height[tail], height[head]);
      max = Math.max(max, minHeight * (head - tail));

      if (height[tail] > height[head]) {
        head--;
      } else {
        tail++;
      }
    }

    return max;
  }

  @Override
  public int trap(int[] height) {
    if (height.length < 3) {
      return 0;
    }

    int trap = 0;
    int tail = 0;
    int head = height.length - 1;

    int tailHeight = tail;
    int tailSum = height[tailHeight];

    int headHeight = head;
    int headSum = height[headHeight];

    while (head - tail != 1) {
      if (height[tailHeight] < height[headHeight]) {
        tail++;

        if (height[tail] >= height[tailHeight]) {
          trap += height[tailHeight] * (tail - tailHeight) - tailSum;
          tailHeight = tail;
          tailSum = height[tailHeight];
        } else {
          tailSum += height[tail];
        }
      } else {
        head--;

        if (height[head] >= height[headHeight]) {
          trap += height[headHeight] * (headHeight - head) - headSum;
          headHeight = head;
          headSum = height[headHeight];
        } else {
          headSum += height[head];
        }
      }
    }

    trap +=
        Math.min(height[tailHeight], height[headHeight]) * (headHeight - tailHeight - 1)
            - tailSum
            - headSum
            + height[tailHeight]
            + height[headHeight];

    return trap;
  }
}
