package hu.jadloakos.solution;

import hu.jadloakos.problem.StackProblems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
