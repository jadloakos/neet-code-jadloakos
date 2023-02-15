package hu.jadloakos.problem;

import java.util.List;

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
   * You are given an array of strings tokens that represent an arithmetic expression in a Reverse
   * Polish Notation.
   *
   * <p>Evaluate the expression. Return an integer that represents the value of the expression.
   *
   * <p>Note that:
   *
   * <ul>
   *   <li>The valid operators are '+', '-', '*', and '/'.
   *   <li>Each operand may be an integer or another expression.
   *   <li>The division between two integers always truncates toward zero.
   *   <li>There will not be any division by zero.
   *   <li>The input represents a valid arithmetic expression in a reverse polish notation.
   *   <li>The answer and all the intermediate calculations can be represented in a 32-bit integer.
   * </ul>
   *
   * Example:
   *
   * <ul>
   *   <li>Input: ["4","13","5","/","+"]
   *   <li>Output: 6
   *   <li>Explanation: (4 + (13 / 5)) = 6
   * </ul>
   *
   * @param tokens array of string containing operators and numbers
   * @return result of the evaluation
   */
  int evalRPN(String[] tokens);

  /**
   * Given n pairs of parentheses, write a function to generate all combinations of well-formed
   * parentheses.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Input: 3
   *   <li>Output: ["((()))","(()())","(())()","()(())","()()()"]
   * </ul>
   *
   * @param n parentheses pair count
   * @return all valid combinations
   */
  List<String> generateParenthesis(int n);

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
