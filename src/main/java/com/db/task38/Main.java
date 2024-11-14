package com.db.task38;

public class Main {
  public static void main(String[] args) {
    Triangle triangle = new Triangle(3, 4, 5);
    System.out.println(triangle);
    System.out.println("Area of the triangle: " + triangle.calculateArea());

    Quadrilateral quadrilateral = new Quadrilateral(3, 4, 5, 6, 5);
    System.out.println(quadrilateral);
    System.out.println("Area of the quadrilateral: " + quadrilateral.calculateArea());
  }
}
