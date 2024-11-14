package com.db.task38;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

  @Test
  void testValidTriangleCreation() {
    Triangle triangle = new Triangle(3, 4, 5);
    assertEquals(3, triangle.getSideA());
    assertEquals(4, triangle.getSideB());
    assertEquals(5, triangle.getSideC());
  }

  @Test
  void testInvalidTriangleCreation() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 3));
    assertEquals("Invalid side lengths for a triangle", exception.getMessage());
  }

  @Test
  void testCalculateArea() {
    Triangle triangle = new Triangle(3, 4, 5);
    assertEquals(6, triangle.calculateArea(), 0.001);
  }

  @Test
  void testToString() {
    Triangle triangle = new Triangle(3, 4, 5);
    assertEquals("Triangle with sides: 3.0, 4.0, 5.0", triangle.toString());
  }
}
