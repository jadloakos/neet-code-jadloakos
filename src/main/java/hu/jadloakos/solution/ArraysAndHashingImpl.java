package hu.jadloakos.solution;

import hu.jadloakos.problem.ArraysAndHashing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Solutions for problems in {@link ArraysAndHashing}. */
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

  @Override
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> counter = new HashMap<>();

    for (int num : nums) {
      var newValue = counter.computeIfPresent(num, (key, count) -> count++);
      if (newValue == null) {
        counter.put(num, 1);
      }
    }

    var numsInOrder =
        counter.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .map(Map.Entry::getKey)
            .mapToInt(Integer::intValue)
            .toArray();
    return Arrays.copyOfRange(numsInOrder, 0, k);
  }

  @Override
  public int[] productExceptSelf(int[] nums) {
    var productExceptSelf = new int[nums.length];
    var left = 1;
    var right = 1;

    for (int i = 0; i < nums.length; i++) {
      productExceptSelf[i] = left;
      left *= nums[i];
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      productExceptSelf[i] *= right;
      right *= nums[i];
    }

    return productExceptSelf;
  }

  @Override
  public boolean isValidSudoku(char[][] board) {
    Map<Integer, Set<Character>> rowValidators = new HashMap<>();
    Map<Integer, Set<Character>> columnValidators = new HashMap<>();
    Map<Integer, Set<Character>> subBoxValidators = new HashMap<>();

    var subBoxSeparator = 3;
    var subBoxIndexMultiplier = board.length;

    for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
      var row = board[rowIndex];
      for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
        var cell = row[columnIndex];
        if ('.' == cell) {
          continue;
        }

        var rowValidator = rowValidators.computeIfAbsent(rowIndex, key -> new HashSet<>());
        if (!rowValidator.add(cell)) {
          return false;
        }

        var columnValidator = columnValidators.computeIfAbsent(columnIndex, key -> new HashSet<>());
        if (!columnValidator.add(cell)) {
          return false;
        }

        var subBoxIndex =
            rowIndex / subBoxSeparator + columnIndex / subBoxSeparator * subBoxIndexMultiplier;
        var subBoxValidator = subBoxValidators.computeIfAbsent(subBoxIndex, key -> new HashSet<>());
        if (!subBoxValidator.add(cell)) {
          return false;
        }
      }
    }

    return true;
  }

  @Override
  public String encode(List<String> strs) {
    var encoded = new StringBuilder();

    for (String str : strs) {
      encoded.append(str.length()).append('#').append(str);
    }

    return encoded.toString();
  }

  @Override
  public List<String> decode(String str) {
    var decoded = new ArrayList<String>();

    var index = 0;
    var characterCounter = 0;
    var nextStr = new StringBuilder();
    var nextStrLength = new StringBuilder();

    while (index != str.length()) {
      var charAtIndex = str.charAt(index);

      if (characterCounter > 0) {
        nextStr.append(charAtIndex);
        characterCounter--;

        if (characterCounter == 0) {
          decoded.add(nextStr.toString());
          nextStr.delete(0, nextStr.length());
        }
      } else if ('#' == charAtIndex) {
        characterCounter = Integer.parseInt(nextStrLength.toString());
        nextStrLength.delete(0, nextStrLength.length());
      } else {
        nextStrLength.append(charAtIndex);
      }

      index++;
    }

    return decoded;
  }

  @Override
  public int longestConsecutive(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }

    var orderedNums = Arrays.stream(nums).distinct().sorted().toArray();

    var longest = 1;
    var counter = 1;
    var previous = orderedNums[0];

    for (int i = 1; i < orderedNums.length; i++) {
      var numAtIndex = orderedNums[i];
      if (numAtIndex == previous + 1) {
        counter++;
        longest = Math.max(longest, counter);
      } else {
        counter = 1;
      }

      previous = numAtIndex;
    }

    return longest;
  }
}
