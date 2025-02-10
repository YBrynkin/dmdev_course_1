package ru.ybrynkin.dmdev.hw.task2.loops;

public class Task3 {

  /**
   * Задание 3
   *
   * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior
   * Java Developer с зарплатой 600$ в месяц. Ему обещали, что будут поднимать зарплату на 400$
   * каждые 6 месяцев. 300$ в месяц Ваня тратит на еду и развлечения. 10% от зарплаты Ваня
   * ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
   *
   * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2
   * месяца.
   */

  private static final int INITIAL_MONTHLY_INCOME = 400;

  private static final int MONTHLY_EXPENSES = 300;

  private static final int PAYMENT_INCREASE_PERIOD = 6;

  private static final int PAYMENT_INCREASE = 400;

  private static final double BROKER_RATIO = 0.1;

  private static final double MONTHLY_INTEREST_RATIO = 0.02;

  private static final int INITIAL_PURE_INCOME = INITIAL_MONTHLY_INCOME - MONTHLY_EXPENSES;

  private static void printCurrentFunds(int months) {
    double currentMainMonthlyIncome = INITIAL_PURE_INCOME;
    double personalBalance = currentMainMonthlyIncome * 0.9;
    double brokerFunds = currentMainMonthlyIncome * 0.1;

    for (int i = 1; i < months; i++) {
      if (i % PAYMENT_INCREASE_PERIOD == 0) {
        currentMainMonthlyIncome += PAYMENT_INCREASE;
      }
      personalBalance += currentMainMonthlyIncome * (1 - BROKER_RATIO);
      brokerFunds += brokerFunds * MONTHLY_INTEREST_RATIO + currentMainMonthlyIncome * BROKER_RATIO;
    }
    System.out.println("Personal balance: " + personalBalance);
    System.out.println("Broker: " + brokerFunds);
  }

  public static void main(String[] args) {
    printCurrentFunds(6);
  }

}
