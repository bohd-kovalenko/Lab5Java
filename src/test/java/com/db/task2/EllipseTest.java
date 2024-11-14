package com.db.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EllipseTest {

  @Test
  void testCalculateYFromXValidInput() {
    Ellipse ellipse = new Ellipse(5, 3);

    double[] yValues = ellipse.calculate(2, CalculationType.Y);
    assertNotNull(yValues);
    assertEquals(2, yValues.length);
    assertTrue(yValues[0] > 0 && yValues[1] < 0);
  }

  @Test
  void testCalculateYFromXOutOfRange() {
    Ellipse ellipse = new Ellipse(5, 3);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> ellipse.calculate(6, CalculationType.Y));
    assertEquals("The value of x is out of the ellipse range", exception.getMessage());
  }

  @Test
  void testCalculateXFromYValidInput() {
    Ellipse ellipse = new Ellipse(5, 3);

    double[] xValues = ellipse.calculate(2, CalculationType.X);
    assertNotNull(xValues);
    assertEquals(2, xValues.length);
    assertTrue(xValues[0] > 0 && xValues[1] < 0);
  }

  @Test
  void testCalculateXFromYOutOfRange() {
    Ellipse ellipse = new Ellipse(5, 3);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> ellipse.calculate(4, CalculationType.X));
    assertEquals("The value of y is out of the ellipse range", exception.getMessage());
  }
}
