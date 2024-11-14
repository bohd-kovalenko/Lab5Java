package com.db.task38;

/**
 * Клас, який представляє трикутник.
 * <p>
 * Цей клас дозволяє створювати трикутники з трьох сторін і обчислювати площу трикутника
 * за допомогою формули Герона. Також перевіряється коректність сторін трикутника під час
 * створення об'єкта або зміни сторін.
 * </p>
 */
public class Triangle implements GeometricFigure {
  protected double sideA;
  protected double sideB;
  protected double sideC;

  /**
   * Конструктор для створення трикутника з трьох сторін.
   * Перевіряє, чи є сторони валідними для трикутника.
   *
   * @param sideA Перша сторона трикутника.
   * @param sideB Друга сторона трикутника.
   * @param sideC Третя сторона трикутника.
   * @throws IllegalArgumentException Якщо сторони не утворюють валідний трикутник.
   */
  public Triangle(double sideA, double sideB, double sideC) {
    if (isValidTriangle(sideA, sideB, sideC)) {
      this.sideA = sideA;
      this.sideB = sideB;
      this.sideC = sideC;
    } else {
      throw new IllegalArgumentException("Invalid side lengths for a triangle");
    }
  }

  public double getSideA() {
    return sideA;
  }

  public void setSideA(double sideA) {
    this.sideA = sideA;
  }

  public double getSideB() {
    return sideB;
  }

  public void setSideB(double sideB) {
    this.sideB = sideB;
  }

  public double getSideC() {
    return sideC;
  }

  public void setSideC(double sideC) {
    this.sideC = sideC;
  }

  private boolean isValidTriangle(double a, double b, double c) {
    return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
  }

  /**
   * Обчислює площу трикутника за допомогою формули Герона.
   * Формула: площа = √(s * (s - a) * (s - b) * (s - c)),
   * де s — півпериметр трикутника.
   *
   * @return Площа трикутника.
   */
  @Override
  public double calculateArea() {
    double semiPerimeter = (sideA + sideB + sideC) / 2;
    return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
  }

  @Override
  public String toString() {
    return "Triangle with sides: " + sideA + ", " + sideB + ", " + sideC;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Triangle triangle)) return false;

    return Double.compare(sideA, triangle.sideA) == 0 && Double.compare(sideB, triangle.sideB) == 0 && Double.compare(sideC, triangle.sideC) == 0;
  }

  @Override
  public int hashCode() {
    int result = Double.hashCode(sideA);
    result = 31 * result + Double.hashCode(sideB);
    result = 31 * result + Double.hashCode(sideC);
    return result;
  }
}
