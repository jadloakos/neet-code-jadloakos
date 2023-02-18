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
}
