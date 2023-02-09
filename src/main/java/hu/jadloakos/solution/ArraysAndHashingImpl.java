package hu.jadloakos.solution;

import hu.jadloakos.problem.ArraysAndHashing;

import java.util.HashSet;
import java.util.stream.Collectors;

public class ArraysAndHashingImpl implements ArraysAndHashing {

  @Override
  public boolean containsDuplicate(int[] nums) {
    var checker = new HashSet<>();

    for (int num : nums) {
      var isAdded = checker.add(num);
      if (!isAdded) {
        return true;
      }
    }

    return false;
  }

  @Override
  public boolean isAnagram(String s, String t) {
    var base = s.chars().boxed().sorted().collect(Collectors.toList());
    var match = t.chars().boxed().sorted().collect(Collectors.toList());
    return base.equals(match);
  }

  @Override
  public int[] twoSum(int[] nums, int target) {
    for (int tail = 0; tail < nums.length - 1; tail++) {
      for (int head = tail + 1; head < nums.length; head++) {
        if (nums[tail] + nums[head] == target) {
          return new int[] {tail, head};
        }
      }
    }

    throw new IllegalArgumentException("No indices where the two numbers add up to target!");
  }
}
