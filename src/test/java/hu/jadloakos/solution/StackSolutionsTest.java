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

  @Test
  public void testDailyTemperatures() {
    // Arrange & Act & Assert
    assertArrayEquals(
        new int[] {1, 1, 4, 2, 1, 1, 0, 0},
        stackSolutions.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73}));
    assertArrayEquals(
        new int[] {1, 1, 1, 0}, stackSolutions.dailyTemperatures(new int[] {30, 40, 50, 60}));
    assertArrayEquals(
        new int[] {1, 1, 0}, stackSolutions.dailyTemperatures(new int[] {30, 60, 90}));
  }

  @Test
  public void testCarFleet() {
    // Arrange & Act & Assert
    assertEquals(
        3, stackSolutions.carFleet(12, new int[] {10, 8, 0, 5, 3}, new int[] {2, 4, 1, 1, 3}));
    assertEquals(1, stackSolutions.carFleet(10, new int[] {3}, new int[] {3}));
    assertEquals(1, stackSolutions.carFleet(100, new int[] {0, 2, 4}, new int[] {4, 2, 1}));
  }

  @Test
  public void testLargestRectangleArea() {
    // Arrange & Act & Assert
    assertEquals(10, stackSolutions.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
    assertEquals(12, stackSolutions.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3, 2, 2}));
    assertEquals(
        13, stackSolutions.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3, 1, 1, 1, 1, 1, 1, 1}));
    assertEquals(6, stackSolutions.largestRectangleArea(new int[] {2, 1, 1, 2, 2, 2}));
  }
}
