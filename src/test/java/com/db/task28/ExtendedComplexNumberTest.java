package com.db.task28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedComplexNumberTest {

  @Test
  void testConstructor() {
    ExtendedComplexNumber complexNumber = new ExtendedComplexNumber(3, 4);
    assertEquals(3, complexNumber.getRealPart());
    assertEquals(4, complexNumber.getImaginaryPart());
  }

  @Test
  void testGetMagnitude() {
    ExtendedComplexNumber complexNumber = new ExtendedComplexNumber(3, 4);
    assertEquals(5.0, complexNumber.getMagnitude(), 0.001);
  }

  @Test
  void testGetArgument() {
    ExtendedComplexNumber complexNumber = new ExtendedComplexNumber(1, Math.sqrt(3));
    assertEquals(Math.PI / 3, complexNumber.getArgument(), 0.001);
  }

  @Test
  void testToExponentialForm() {
    ExtendedComplexNumber complexNumber = new ExtendedComplexNumber(3, 4);
    String exponentialForm = complexNumber.toExponentialForm();
    double expectedMagnitude = 5.00;

    assertTrue(exponentialForm.contains(String.format("%.2f", expectedMagnitude)));
    assertTrue(exponentialForm.contains("e^(i"));
  }

  @Test
  void testToString() {
    ExtendedComplexNumber complexNumber = new ExtendedComplexNumber(3, 4);
    String result = complexNumber.toString();
    double expectedMagnitude = 5.00;

    assertTrue(result.contains("3.0 + 4.0i"), "Standard form part is missing or incorrect");
    assertTrue(result.contains("Exponential form:"), "Exponential form label is missing");
    assertTrue(result.contains(String.format("%.2f", expectedMagnitude)), "Magnitude part is incorrect");
    assertTrue(result.contains("e^(i"), "Exponential format is missing or incorrect");
  }

  @Test
  void testToStringNegativeImaginary() {
    ExtendedComplexNumber complexNumber = new ExtendedComplexNumber(3, -4);
    String result = complexNumber.toString();
    assertTrue(result.contains("3.0 - 4.0i"));
  }
}
