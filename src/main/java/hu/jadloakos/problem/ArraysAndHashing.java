package hu.jadloakos.problem;

/** Interface for arrays & hashing problems */
public interface ArraysAndHashing {

  /**
   * Given an integer array nums, return true if any value appears at least twice in the array, and
   * return false if every element is distinct.
   *
   * @param nums array of nums
   * @return true if value appears at least twice, false otherwise
   */
  boolean containsDuplicate(int[] nums);

  /**
   * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
   *
   * <p>An Anagram is a word or phrase formed by rearranging the letters of a different word or
   * phrase, typically using all the original letters exactly once.
   *
   * @param s base word
   * @param t possible anagram
   * @return true if t is an anagram of s, false otherwise
   */
  boolean isAnagram(String s, String t);
}
