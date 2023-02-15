package hu.jadloakos.solution;

import hu.jadloakos.problem.StackProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/** Test class for {@link StackSolutions} */
public class StackSolutionsTest {

  private StackProblems stackSolutions;

  @BeforeEach
  public void setup() {
    stackSolutions = new StackSolutions();
  }

  @Test
  public void testIsValid() {
    // Arrange
    var valid = "()";
    var complexValid = "()[]{}";
    var invalid = "(]";

    // Act & Assert
    assertTrue(stackSolutions.isValid(valid));
    assertTrue(stackSolutions.isValid(complexValid));
    assertFalse(stackSolutions.isValid(invalid));
  }

  @Test
  public void testMinStack() {
    // Arrange
    var minStack = stackSolutions.getMinStack();

    // Act & Assert
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assertEquals(-3, minStack.getMin());
    minStack.pop();
    assertEquals(0, minStack.top());
    assertEquals(-2, minStack.getMin());
  }

  @Test
  public void testEvalRPN() {
    // Arrange
    var tokensOne = new String[] {"2", "1", "+", "3", "*"};
    var tokenTwo = new String[] {"4", "13", "5", "/", "+"};
    var tokenThree =
        new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

    // Act & Assert
    assertEquals(9, stackSolutions.evalRPN(tokensOne));
    assertEquals(6, stackSolutions.evalRPN(tokenTwo));
    assertEquals(22, stackSolutions.evalRPN(tokenThree));
  }

  @Test
  public void testGenerateParenthesis() {
    // Arrange & Act & Assert
    assertEquals(List.of("()"), stackSolutions.generateParenthesis(1));
    assertEquals(
        Stream.of("((()))", "(()())", "(())()", "()(())", "()()()")
            .sorted()
            .collect(Collectors.toList()),
        stackSolutions.generateParenthesis(3).stream().sorted().collect(Collectors.toList()));
  }
}
