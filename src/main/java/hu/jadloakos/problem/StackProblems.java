package hu.jadloakos.problem;

/** Interface for stack problems */
public interface StackProblems {

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

  /**
   * Returns a solution for the MinStack problem.
   *
   * @return a {@link MinStack} implementation
   */
  MinStack getMinStack();

  /**
   * Design a stack that supports push, pop, top, and retrieving the minimum element in constant
   * time.
   *
   * <p>Implement the MinStack class:
   *
   * <p>MinStack() initializes the stack object. void push(int val) pushes the element val onto the
   * stack. void pop() removes the element on the top of the stack. int top() gets the top element
   * of the stack. int getMin() retrieves the minimum element in the stack. You must implement a
   * solution with O(1) time complexity for each function.
   */
  interface MinStack {

    void push(int val);

    void pop();

    int top();

    int getMin();
  }
}
