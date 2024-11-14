package com.db.task14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

  @Test
   void testConstructorValidTriangle() {
    Triangle triangle = new Triangle(3, 4, 5);
    assertEquals(3, triangle.getSideA());
    assertEquals(4, triangle.getSideB());
    assertEquals(5, triangle.getSideC());
  }

  @Test
   void testConstructorInvalidTriangle() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 3));
    assertEquals("Invalid side lengths for a triangle", exception.getMessage());
  }

  @Test
   void testSetSideAValid() {
    Triangle triangle = new Triangle(3, 4, 5);
    triangle.setSideA(6);
    assertEquals(6, triangle.getSideA());
  }

  @Test
   void testSetSideAInvalid() {
    Triangle triangle = new Triangle(3, 4, 5);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> triangle.setSideA(10));
    assertEquals("Invalid side length for a triangle", exception.getMessage());
  }

  @Test
   void testSetSideBValid() {
    Triangle triangle = new Triangle(3, 4, 5);
    triangle.setSideB(6);
    assertEquals(6, triangle.getSideB());
  }

  @Test
   void testSetSideBInvalid() {
    Triangle triangle = new Triangle(3, 4, 5);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> triangle.setSideB(10));
    assertEquals("Invalid side length for a triangle", exception.getMessage());
  }

  @Test
   void testSetSideCValid() {
    Triangle triangle = new Triangle(3, 4, 5);
    triangle.setSideC(6);
    assertEquals(6, triangle.getSideC());
  }

  @Test
   void testSetSideCInvalid() {
    Triangle triangle = new Triangle(3, 4, 5);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> triangle.setSideC(10));
    assertEquals("Invalid side length for a triangle", exception.getMessage());
  }

  @Test
   void testCalculatePerimeter() {
    Triangle triangle = new Triangle(3, 4, 5);
    assertEquals(12, triangle.calculatePerimeter(), 0.001);
  }

  @Test
   void testCalculateArea() {
    Triangle triangle = new Triangle(3, 4, 5);
    assertEquals(6, triangle.calculateArea(), 0.001);
  }
}
