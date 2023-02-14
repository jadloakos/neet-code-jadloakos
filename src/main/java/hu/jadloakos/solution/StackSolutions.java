package hu.jadloakos.solution;

import hu.jadloakos.problem.StackProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/** Solutions for problems in {@link StackProblems}. */
public class StackSolutions implements StackProblems {

  @Override
  public boolean isValid(String s) {
    List<Character> openBrackets = Arrays.asList('(', '[', '{');
    List<Character> closeBrackets = Arrays.asList(')', ']', '}');
    Stack<Character> unclosedOpenBrackets = new Stack<>();

    for (char c : s.toCharArray()) {
      var closeIndex = closeBrackets.indexOf(c);
      if (closeIndex != -1) {
        var lastOpenBracket = unclosedOpenBrackets.pop();
        if (closeIndex != openBrackets.indexOf(lastOpenBracket)) {
          return false;
        }
      }

      var openIndex = openBrackets.indexOf(c);
      if (openIndex != -1) {
        unclosedOpenBrackets.push(c);
      }
    }

    return unclosedOpenBrackets.empty();
  }

  @Override
  public MinStack getMinStack() {
    return new MinStackSolution();
  }

  private static class MinStackSolution implements MinStack {

    private final Stack<Integer> min = new Stack<>();
    private final Stack<Integer> stack = new Stack<>();

    @Override
    public void push(int val) {
      stack.push(val);
      min.push(Math.min(val, min.empty() ? val : min.peek()));
    }

    @Override
    public void pop() {
      min.pop();
      stack.pop();
    }

    @Override
    public int top() {
      return stack.peek();
    }

    @Override
    public int getMin() {
      return min.peek();
    }
  }
}
