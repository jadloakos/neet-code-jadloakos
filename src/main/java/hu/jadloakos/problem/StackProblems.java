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
   * Given an array of integer temperatures represents the daily temperatures, return an array
   * answer such that answer[i] is the number of days you have to wait after the ith day to get a
   * warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0
   * instead.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Input: [73,74,75,71,69,72,76,73]
   *   <li>Output: [1,1,4,2,1,1,0,0]
   * </ul>
   *
   * @param temperatures array of integers representing daily temperatures
   * @return number of days per day for warmer temperature
   */
  int[] dailyTemperatures(int[] temperatures);

  /**
   * There are n cars going to the same destination along a one-lane road. The destination is target
   * miles away.
   *
   * <p>You are given two integer array position and speed, both of length n, where position[i] is
   * the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
   *
   * <p>A car can never pass another car ahead of it, but it can catch up to it and drive bumper to
   * bumper at the same speed. The faster car will slow down to match the slower car's speed. The
   * distance between these two cars is ignored (i.e., they are assumed to have the same position).
   *
   * <p>A car fleet is some non-empty set of cars driving at the same position and same speed. Note
   * that a single car is also a car fleet.
   *
   * <p>If a car catches up to a car fleet right at the destination point, it will still be
   * considered as one car fleet.
   *
   * <p>Return the number of car fleets that will arrive at the destination.
   *
   * <ul>
   *   <li>Example 1
   *       <ul>
   *         <li>Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
   *         <li>Output: 3
   *         <li>Explanation: The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet,
   *             meeting each other at 12. The car starting at 0 does not catch up to any other car,
   *             so it is a fleet by itself. The cars starting at 5 (speed 1) and 3 (speed 3) become
   *             a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches
   *             target. Note that no other cars meet these fleets before the destination, so the
   *             answer is 3.
   *       </ul>
   *   <li>Example 2
   *       <ul>
   *         <li>Input: target = 10, position = [3], speed = [3]
   *         <li>Output: 1
   *         <li>Explanation: There is only one car, hence there is only one fleet.
   *       </ul>
   *   <li>Example 3
   *       <ul>
   *         <li>Input: target = 100, position = [0,2,4], speed = [4,2,1]
   *         <li>Output: 1
   *         <li>Explanation: The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet,
   *             meeting each other at 4. The fleet moves at speed 2. Then, the fleet (speed 2) and
   *             the car starting at 4 (speed 1) become one fleet, meeting each other at 6. The
   *             fleet moves at speed 1 until it reaches target.
   *       </ul>
   * </ul>
   *
   * @param target distance to the destination in miles
   * @param position position of the ith car
   * @param speed speed of the ith car (in miles per hour)
   * @return number of car fleets that will arrive at the destination
   */
  int carFleet(int target, int[] position, int[] speed);

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
