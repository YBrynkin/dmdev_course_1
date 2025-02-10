package ru.ybrynkin.dmdev.hw.task2.loops;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

  /**
   * Задание 2
   *
   * Дано целое число. Написать функцию, которая принимает целое число, а возвращает целое число
   * обратное этому (не строку!). Результат вывести на консоль. Например: 4508 -> 8054, 4700 -> 74,
   * 1234567 -> 7654321
   *
   * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число,
   * степень)
   */

  private static final Scanner sc = new Scanner(System.in);

  private static final String ZERO = "0";

  private static final String LEADING_ZEROS_REGEX = "^0+";

  private static void printReversedInputInteger(int inputNumber) {
    StringBuilder sb = new StringBuilder(String.valueOf(inputNumber));
    String reversedInputNumber = sb.reverse().toString();
    if (reversedInputNumber.startsWith(ZERO)) {
      reversedInputNumber = cutLeadingZeros(reversedInputNumber);
    }
    System.out.printf("The reversed number of %d is %d\n", inputNumber,
        Integer.parseInt(reversedInputNumber));
  }

  private static String cutLeadingZeros(String reversedInputNumber) {
    Pattern p = Pattern.compile(LEADING_ZEROS_REGEX);
    Matcher m = p.matcher(reversedInputNumber);
    return m.replaceFirst("");
  }

  public static void main(String[] args) {
    System.out.println("Enter any integer number:");
    int inputNumber = sc.nextInt();
    printReversedInputInteger(inputNumber);
  }


}
