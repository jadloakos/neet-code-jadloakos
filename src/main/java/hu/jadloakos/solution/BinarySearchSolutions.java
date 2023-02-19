package hu.jadloakos.solution;

import hu.jadloakos.problem.BinarySearchProblems;

import java.util.*;

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
    return nums[findMinIndex(nums)];
  }

  @Override
  public int searchRotated(int[] nums, int target) {
    var minIndex = findMinIndex(nums);

    // binary search all values after min index
    var headIndex = Arrays.binarySearch(nums, minIndex, nums.length, target);
    if (headIndex >= 0) {
      return headIndex;
    }

    // binary search all values before min index
    var tailIndex = Arrays.binarySearch(nums, 0, minIndex, target);
    if (tailIndex >= 0) {
      return tailIndex;
    }

    return -1;
  }

  @Override
  public TimeMap getTimeMap() {
    return new TimeMapSolution();
  }

  private int findMinIndex(int[] nums) {
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

    return tail;
  }

  private static class TimeMapSolution implements TimeMap {

    private Map<String, List<TimeValue>> map = new HashMap<>();

    @Override
    public void set(String key, String value, int timestamp) {
      var timeValues = map.get(key);
      if (timeValues == null) {
        var newTimeValues = new ArrayList<TimeValue>();
        newTimeValues.add(new TimeValue(timestamp, value));
        map.put(key, newTimeValues);
        return;
      }

      var index = Collections.binarySearch(timeValues, timestamp);
      if (index < 0) {
        index = -(index + 1);
      }

      timeValues.add(index, new TimeValue(timestamp, value));
    }

    @Override
    public String get(String key, int timestamp) {
      var timeValues = map.get(key);
      var index = Collections.binarySearch(timeValues, timestamp);
      if (index >= 0) {
        return timeValues.get(index).value;
      }

      var insertionPoint = -(index + 1);
      return timeValues.get(insertionPoint - 1).value;
    }
  }

  private static class TimeValue implements Comparable<Integer> {

    private int time;
    private String value;

    public TimeValue(int time, String value) {
      this.time = time;
      this.value = value;
    }

    @Override
    public int compareTo(Integer value) {
      return Integer.compare(time, value);
    }
  }
}
