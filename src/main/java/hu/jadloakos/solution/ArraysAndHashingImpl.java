package hu.jadloakos.solution;

import hu.jadloakos.problem.ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

  @Override
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> groups = new ArrayList<>();

    for (String str : strs) {
      groups.stream()
          .filter(group -> isAnagram(group.get(0), str))
          .findAny()
          .ifPresentOrElse(
              group -> group.add(str),
              () -> groups.add(Stream.of(str).collect(Collectors.toList())));
    }

    return groups;
  }
}
