package hu.jadloakos.solution;

import hu.jadloakos.problem.StackProblems;

import java.util.*;
import java.util.function.BiFunction;

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

  @Override
  public int evalRPN(String[] tokens) {
    Map<String, BiFunction<Integer, Integer, Integer>> operationMap =
        Map.of(
            "+", Integer::sum,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b);
    List<String> operators = List.of("+", "-", "*", "/");

    Stack<Integer> numberTokens = new Stack<>();
    Integer result = null;

    for (String token : tokens) {
      var indexOfOperator = operators.indexOf(token);

      if (indexOfOperator == -1) {
        numberTokens.push(Integer.parseInt(token));
      } else {
        if (result == null) {
          result = numberTokens.pop();
        }
        result = operationMap.get(operators.get(indexOfOperator)).apply(numberTokens.pop(), result);
      }
    }

    return Optional.ofNullable(result).orElse(0);
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
