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
}
