package com.db.task28;

public class Main {
  public static void main(String[] args) {
    ExtendedComplexNumber complexNumber = new ExtendedComplexNumber(3, 4);

    System.out.println("Complex number in standard form:");
    System.out.println(complexNumber);

    System.out.println("Magnitude: " + complexNumber.getMagnitude());
    System.out.println("Argument (radians): " + complexNumber.getArgument());
  }
}
