package com.db.task38;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadrilateralTest {

  @Test
  void testValidQuadrilateralCreation() {
    Quadrilateral quadrilateral = new Quadrilateral(3, 4, 5, 6, 5);
    assertEquals(3, quadrilateral.getSideA());
    assertEquals(4, quadrilateral.getSideB());
    assertEquals(5, quadrilateral.getSideC());
  }

  @Test
  void testCalculateArea() {
    Quadrilateral quadrilateral = new Quadrilateral(3, 4, 5, 6, 5);
    double area = quadrilateral.calculateArea();
    assertTrue(area > 0, "The area should be greater than 0");
  }

  @Test
  void testToString() {
    Quadrilateral quadrilateral = new Quadrilateral(3, 4, 5, 6, 5);
    assertEquals("Quadrilateral with sides: 3.0, 4.0, 5.0, 6.0 and diagonal: 5.0", quadrilateral.toString());
  }
}
