package hu.jadloakos.problem;

/** Interface for stack problems */
public interface Stack {

  /**
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if
   * the input string is valid.
   *
   * <p>An input string is valid if:
   *
   * <p>Open brackets must be closed by the same type of brackets. Open brackets must be closed in
   * the correct order. Every close bracket has a corresponding open bracket of the same type.
   *
   * @param s string of special characters
   * @return true if valid, false otherwise
   */
  boolean isValid(String s);
}
