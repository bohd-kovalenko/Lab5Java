package com.db.task14;

/**
 * Клас, який представляє трикутник з трьома сторонами.
 * <p>
 * Клас надає функції для обчислення периметра і площі трикутника. Також містить методи для
 * отримання та встановлення значень сторін трикутника з перевіркою коректності введених значень.
 * </p>
 */
public class Triangle implements GeometricFigure {
  private double sideA;
  private double sideB;
  private double sideC;

  /**
   * Конструктор для створення трикутника з заданими сторонами.
   *
   * @param sideA Довжина першої сторони трикутника.
   * @param sideB Довжина другої сторони трикутника.
   * @param sideC Довжина третьої сторони трикутника.
   * @throws IllegalArgumentException Якщо введені сторони не можуть утворити трикутник (не виконуються умови для сторін трикутника).
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
    if (isValidTriangle(sideA, this.sideB, this.sideC)) {
      this.sideA = sideA;
    } else {
      throw new IllegalArgumentException("Invalid side length for a triangle");
    }
  }

  public double getSideB() {
    return sideB;
  }

  public void setSideB(double sideB) {
    if (isValidTriangle(this.sideA, sideB, this.sideC)) {
      this.sideB = sideB;
    } else {
      throw new IllegalArgumentException("Invalid side length for a triangle");
    }
  }

  public double getSideC() {
    return sideC;
  }

  public void setSideC(double sideC) {
    if (isValidTriangle(this.sideA, this.sideB, sideC)) {
      this.sideC = sideC;
    } else {
      throw new IllegalArgumentException("Invalid side length for a triangle");
    }
  }

  private boolean isValidTriangle(double a, double b, double c) {
    return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
  }

  /**
   * Обчислює площу трикутника за формулою Герона.
   * Площа обчислюється через півпериметр і сторони трикутника.
   *
   * @return Площа трикутника.
   */
  @Override
  public double calculateArea() {
    double semiPerimeter = calculatePerimeter() / 2;
    return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
  }

  /**
   * Обчислює периметр трикутника як суму його сторін.
   *
   * @return Периметр трикутника.
   */
  @Override
  public double calculatePerimeter() {
    return sideA + sideB + sideC;
  }

  @Override
  public String toString() {
    return "Triangle{" +
        "sideA=" + sideA +
        ", sideB=" + sideB +
        ", sideC=" + sideC +
        '}';
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
