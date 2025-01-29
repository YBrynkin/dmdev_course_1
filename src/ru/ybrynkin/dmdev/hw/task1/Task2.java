package ru.ybrynkin.dmdev.hw.task1;

  /**
   * Задание 2
   *
   * Даны 3 переменные:
   *
   * - operand1 (double)
   * - operand2 (double)
   * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
   *
   * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает
   * результат операции. Протестировать функцию в main.
   *
   * Например: Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’ Результат: 34.5 (24.4 +
   * 10.1)
   */

  public class Task2 {

    private static double doOperationByParam(double operand1, double operand2, char operation) {
      return switch (operation) {
        case '+' -> operand1 + operand2;
        case '-' -> operand1 - operand2;
        case '*' -> operand1 * operand2;
        case '/' -> operand1 / operand2;
        case '%' -> operand1 % operand2;
        default -> {
          System.out.println(
              "Wrong operation type: operation takes only this ‘+’, ‘-’, ‘*’, ‘/’, ‘%’");
          yield Double.NaN;
        }
      };
    }

    public static void main(String[] args) {
      System.out.println(doOperationByParam(0.125, 9, '*'));
      System.out.println(doOperationByParam(24.4, 10.1, '+'));
      System.out.println(doOperationByParam(24.4, 0, '/'));
      System.out.println(doOperationByParam(-24.4, 0, '/'));
      System.out.println(doOperationByParam(0, 0, '/'));
      System.out.println(doOperationByParam(25, -4, '/'));
      System.out.println(doOperationByParam(11, 5.4, '%'));
      System.out.println(doOperationByParam(24.4, 10.1, 'a'));

    }

  }
