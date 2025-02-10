package ru.ybrynkin.dmdev.hw.task2.loops;

import java.util.Scanner;

public class Task1 {

  /**
   * Задание 1
   *
   * Посчитать четные и нечетные цифры целого числа и вывести их на консоль. Для решения написать 2
   * функции, которые будут принимать введенное целое число, а возвращать количество четных цифр
   * (вторая функция - нечетных).
   *
   * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9,
   * 1).
   */

  private static final Scanner sc = new Scanner(System.in);

  private static void processInputNumber(int inputNumber) {
    String evenNumbers = getEvenNumbersString(inputNumber);
    String oddNumbers = getOddNumbersString(inputNumber);
    printProcessingResult(inputNumber, evenNumbers, oddNumbers);
  }

  private static String getOddNumbersString(int inputNumber) {
    String number = String.valueOf(Math.abs(inputNumber));
    StringBuilder oddNumbers = new StringBuilder();
    for (int i = 0; i < number.length(); i++) {
      int num = Character.getNumericValue(number.charAt(i));
      if (num % 2 != 0) {
        oddNumbers.append(num);
      }
    }
    return oddNumbers.toString();
  }

  private static String getEvenNumbersString(int inputNumber) {
    String number = String.valueOf(Math.abs(inputNumber));
    StringBuilder evenNumbers = new StringBuilder();
    for (int i = 0; i < number.length(); i++) {
      int num = Character.getNumericValue(number.charAt(i));
      if (num % 2 == 0) {
        evenNumbers.append(num);
      }
    }
    return evenNumbers.toString();
  }


  private static void printProcessingResult(int inputNumber, String evenNumbers,
      String oddNumbers) {
    System.out.printf(
        "The entered number is %d.\n %d - the number of even numbers; %d - the number of odd numbers\n",
        inputNumber,
        evenNumbers.length(), oddNumbers.length());
  }

  public static void main(String[] args) {
    System.out.println("Enter any integer number:");
    int inputNumber = sc.nextInt();
    processInputNumber(inputNumber);
  }

}




