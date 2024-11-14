package com.db.task28;

/**
 * Клас, який розширює {@link ComplexNumber} і додає функціональність для обчислення
 * та представлення комплексного числа в експоненційній формі.
 * <p>
 * Цей клас розширює можливості базового класу {@link ComplexNumber}, надаючи методи для обчислення
 * величини (модулю) та аргументу комплексного числа, а також для виведення цього числа в експоненційній формі.
 * </p>
 */
public class ExtendedComplexNumber extends ComplexNumber implements ComplexCalculations {

  /**
   * Конструктор для створення розширеного комплексного числа з заданими реальними та уявними частинами.
   *
   * @param realPart      Реальна частина комплексного числа.
   * @param imaginaryPart Уявна частина комплексного числа.
   */
  public ExtendedComplexNumber(double realPart, double imaginaryPart) {
    super(realPart, imaginaryPart);
  }

  @Override
  public double getMagnitude() {
    return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
  }

  @Override
  public double getArgument() {
    return Math.atan2(imaginaryPart, realPart);
  }

  /**
   * Повертає експоненційну форму комплексного числа у вигляді "r * e^(iθ)",
   * де r — величина (модуль) комплексного числа, а θ — його аргумент (фаза).
   *
   * @return Експоненціальна форма комплексного числа.
   */
  @Override
  public String toExponentialForm() {
    double magnitude = getMagnitude();
    double argument = getArgument();
    return String.format("%.2f * e^(i%.2f)", magnitude, argument);
  }

  @Override
  public String toString() {
    return super.toString() + "\nExponential form: " + toExponentialForm();
  }
}
