package hu.jadloakos.solution;

import hu.jadloakos.problem.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Test class for {@link StackImpl} */
public class StackImplTest {

  private Stack stack;

  @BeforeEach
  public void setup() {
    stack = new StackImpl();
  }

  @Test
  public void testIsValid() {
    // Arrange
    var valid = "()";
    var complexValid = "()[]{}";
    var invalid = "(]";

    // Act & Assert
    assertTrue(stack.isValid(valid));
    assertTrue(stack.isValid(complexValid));
    assertFalse(stack.isValid(invalid));
  }
}
