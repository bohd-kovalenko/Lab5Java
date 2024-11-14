package com.db.task38;

/**
 * Клас, який представляє чотирикутник. Чотирикутник є похідним класом від трикутника
 * і містить додаткові сторони та діагональ.
 * <p>
 * Цей клас дозволяє обчислювати площу чотирикутника, використовуючи дві трикутні області,
 * створені діагоналлю. Він також перевіряє коректність сторін і діагоналі під час створення об'єкта.
 * </p>
 */
public class Quadrilateral extends Triangle {
  private final double sideD;
  private final double diagonal;

  /**
   * Перевіряє, чи є вхідні значення валідними для чотирикутника.
   * Це перевірка довжин сторін та діагоналі для того, щоб чотирикутник був можливий.
   *
   * @param sideA    Перша сторона.
   * @param sideB    Друга сторона.
   * @param sideC    Третя сторона.
   * @param sideD    Четверта сторона.
   * @param diagonal Діагональ.
   * @return true, якщо всі сторони і діагональ валідні для чотирикутника.
   */
  public Quadrilateral(double sideA, double sideB, double sideC, double sideD, double diagonal) {
    super(sideA, sideB, sideC);
    if (isValidQuadrilateral(sideA, sideB, sideC, sideD, diagonal)) {
      this.sideD = sideD;
      this.diagonal = diagonal;
    } else {
      throw new IllegalArgumentException("Invalid side lengths for a quadrilateral");
    }
  }

  private boolean isValidQuadrilateral(double a, double b, double c, double d, double diag) {
    return a > 0 && b > 0 && c > 0 && d > 0 && diag > 0 &&
        (a + b + c > d) && (a + b + d > c) && (a + c + d > b) && (b + c + d > a);
  }

  /**
   * Обчислює площу чотирикутника, використовуючи два трикутники, що утворюються діагоналлю.
   *
   * @return Площа чотирикутника.
   */
  @Override
  public double calculateArea() {
    Triangle triangle1 = new Triangle(sideA, sideB, diagonal);
    Triangle triangle2 = new Triangle(sideC, sideD, diagonal);
    return triangle1.calculateArea() + triangle2.calculateArea();
  }

  @Override
  public String toString() {
    return "Quadrilateral with sides: " + sideA + ", " + sideB + ", " + sideC + ", " + sideD +
        " and diagonal: " + diagonal;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Quadrilateral that)) return false;

    return Double.compare(sideD, that.sideD) == 0 && Double.compare(diagonal, that.diagonal) == 0;
  }

  @Override
  public int hashCode() {
    int result = Double.hashCode(sideD);
    result = 31 * result + Double.hashCode(diagonal);
    return result;
  }
}
