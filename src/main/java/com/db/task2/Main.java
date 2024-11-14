package com.db.task2;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the value of a (semi-major axis): ");
    double a = scanner.nextDouble();
    System.out.print("Enter the value of b (semi-minor axis): ");
    double b = scanner.nextDouble();
    Ellipse ellipse = new Ellipse(a, b);
    while (true) {
      System.out.println("\nChoose an operation:");
      System.out.println("1. Calculate y from x");
      System.out.println("2. Calculate x from y");
      System.out.println("3. Exit");
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          System.out.print("Enter the value of x: ");
          double x = scanner.nextDouble();
          try {
            double[] yValues = ellipse.calculate(x, CalculationType.Y);
            System.out.printf("y values for x = %.2f are: %.2f and %.2f%n", x, yValues[0], yValues[1]);
          } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
          }
          break;
        case 2:
          System.out.print("Enter the value of y: ");
          double y = scanner.nextDouble();
          try {
            double[] xValues = ellipse.calculate(y, CalculationType.X);
            System.out.printf("x values for y = %.2f are: %.2f and %.2f%n", y, xValues[0], xValues[1]);
          } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
          }
          break;
        case 3:
          System.out.println("Exiting the program.");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }
}
