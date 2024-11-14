package com.db.task2;

/**
 * Клас, що представляє еліпс другого порядку у вигляді функції y(x).
 * <p>
 * Клас надає можливість обчислювати координати точки еліпса на основі значення x або y, залежно від типу обчислення.
 * </p>
 */
public class Ellipse implements Function {
  private final double a;
  private final double b;

  /**
   * Конструктор для створення еліпса з заданими значеннями піввісей.
   *
   * @param a Довжина великої піввісі еліпса.
   * @param b Довжина малої піввісі еліпса.
   */
  public Ellipse(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double getA() {
    return a;
  }

  public double getB() {
    return b;
  }

  /**
   * Обчислює координати еліпса залежно від значення змінної (x або y).
   * Метод виконує обчислення за допомогою формул для еліпса другого порядку:
   * <ul>
   * <li>Для обчислення x з y використовується формула: x = a * sqrt(1 - (y^2 / b^2))</li>
   * <li>Для обчислення y з x використовується формула: y = b * sqrt(1 - (x^2 / a^2))</li>
   * </ul>
   *
   * @param variable Значення x або y для обчислення відповідної координати.
   * @param calculationType Тип обчислення (X або Y).
   * @return Массив, що містить два значення для x або y (два можливих значення, враховуючи симетрію еліпса).
   * @throws IllegalArgumentException Якщо значення змінної виходить за межі можливих значень для еліпса.
   * @throws UnsupportedOperationException Якщо переданий невідомий тип обчислення.
   */
  @Override
  public double[] calculate(double variable, CalculationType calculationType) {
    switch (calculationType) {
      case X:
        if (Math.abs(variable) > b) {
          throw new IllegalArgumentException("The value of y is out of the ellipse range");
        }
        double x = a * Math.sqrt(1 - (variable * variable) / (b * b));
        return new double[]{x, -x};

      case Y:
        if (Math.abs(variable) > a) {
          throw new IllegalArgumentException("The value of x is out of the ellipse range");
        }
        double y = b * Math.sqrt(1 - (variable * variable) / (a * a));
        return new double[]{y, -y};

      default:
        throw new UnsupportedOperationException("Unknown calculation type");
    }
  }

  @Override
  public String toString() {
    return "Ellipse{" +
        "a=" + a +
        ", b=" + b +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Ellipse ellipse)) return false;

    return Double.compare(a, ellipse.a) == 0 && Double.compare(b, ellipse.b) == 0;
  }

  @Override
  public int hashCode() {
    int result = Double.hashCode(a);
    result = 31 * result + Double.hashCode(b);
    return result;
  }
}
