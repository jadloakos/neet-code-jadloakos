package hu.jadloakos.solution;

import hu.jadloakos.problem.Stack;

import java.util.Arrays;
import java.util.List;

/** Solutions for problems in {@link Stack}. */
public class StackImpl implements Stack {

  @Override
  public boolean isValid(String s) {
    List<Character> openBrackets = Arrays.asList('(', '[', '{');
    List<Character> closeBrackets = Arrays.asList(')', ']', '}');
    java.util.Stack<Character> unclosedOpenBrackets = new java.util.Stack<>();

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
}
