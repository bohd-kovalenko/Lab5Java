package com.db.task28;

/**
 * Клас, який представляє комплексне число.
 * <p>
 * Цей клас дозволяє зберігати та працювати з комплексними числами, включаючи реальну та уявну частини.
 * Крім того, він надає метод для виведення комплексного числа в стандартній алгебраїчній формі.
 * </p>
 */
public class ComplexNumber {
  protected double realPart;
  protected double imaginaryPart;

  /**
   * Конструктор для створення комплексного числа з заданими реальними та уявними частинами.
   *
   * @param realPart Реальна частина комплексного числа.
   * @param imaginaryPart Уявна частина комплексного числа.
   */
  public ComplexNumber(double realPart, double imaginaryPart) {
    this.realPart = realPart;
    this.imaginaryPart = imaginaryPart;
  }

  public double getRealPart() {
    return realPart;
  }

  public double getImaginaryPart() {
    return imaginaryPart;
  }

  @Override
  public String toString() {
    return realPart + (imaginaryPart >= 0 ? " + " : " - ") + Math.abs(imaginaryPart) + "i";
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ComplexNumber that)) return false;

    return Double.compare(realPart, that.realPart) == 0 && Double.compare(imaginaryPart, that.imaginaryPart) == 0;
  }

  @Override
  public int hashCode() {
    int result = Double.hashCode(realPart);
    result = 31 * result + Double.hashCode(imaginaryPart);
    return result;
  }
}
