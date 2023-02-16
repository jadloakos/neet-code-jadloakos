package hu.jadloakos.solution;

import hu.jadloakos.problem.StackProblems;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

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

  @Override
  public List<String> generateParenthesis(int n) {
    if (n == 1) {
      return List.of("()");
    }

    var combinations = new HashSet<String>();

    var simpleCombination = new char[n * 2];
    Arrays.fill(simpleCombination, 0, n, '(');
    Arrays.fill(simpleCombination, n, n * 2, ')');
    combinations.add(new String(simpleCombination));

    var smallerCombinations = generateParenthesis(n - 1);
    // right
    combinations.addAll(
        smallerCombinations.stream()
            .map(smallerCombination -> smallerCombination + "()")
            .collect(Collectors.toList()));
    // left
    combinations.addAll(
        smallerCombinations.stream()
            .map(smallerCombination -> "()" + smallerCombination)
            .collect(Collectors.toList()));
    // inside
    combinations.addAll(
        smallerCombinations.stream()
            .map(smallerCombination -> "(" + smallerCombination + ")")
            .collect(Collectors.toList()));

    return new ArrayList<>(combinations);
  }

  @Override
  public int[] dailyTemperatures(int[] temperatures) {
    var result = new int[temperatures.length];
    var processedTemperatures = new Stack<Integer>();
    var daysForProcessedTemperatures = new Stack<Integer>();

    if (temperatures.length < 2) {
      return result;
    }

    processedTemperatures.push(temperatures[temperatures.length - 1]);
    daysForProcessedTemperatures.push(0);

    for (int i = temperatures.length - 2; i >= 0; i--) {
      var temperature = temperatures[i];

      var daysToWait = 1;
      while (!processedTemperatures.empty()) {
        var lastProcessedTemperature = processedTemperatures.peek();
        if (temperature > lastProcessedTemperature) {
          processedTemperatures.pop();
          daysToWait += daysForProcessedTemperatures.pop();
        } else {
          result[i] = daysToWait;
          break;
        }
      }

      processedTemperatures.push(temperature);
      daysForProcessedTemperatures.push(result[i]);
    }

    return result;
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
