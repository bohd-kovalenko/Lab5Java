package com.db.task14;

public class Main {
  public static void main(String[] args) {
    try {
      Triangle triangle = new Triangle(3, 4, 5);
      System.out.println("Triangle sides: " + triangle.getSideA() + ", " + triangle.getSideB() + ", " + triangle.getSideC());
      System.out.println("Perimeter: " + triangle.calculatePerimeter());
      System.out.println("Area: " + triangle.calculateArea());

      triangle.setSideA(1);
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
