package projects;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

  public static void main(String[] args) {

    // Mortgage Calculator

    // Formula = M = P((r(1 + r)^n) / ((1 + r)^n) - 1)
    // P = Principal Amount
    // r = monthly interest rate - Annual rate / 12
    // n = number of payments = years * 12

    Scanner input = new Scanner(System.in);
    int principal;
    float annualInterest;
    int years;

    while(true) {
      System.out.print("Enter the Principal amount($1k - $1M): ");
      principal = input.nextInt();

      if (principal >= 1000 && principal <= 1000000) {
        break;
      } else System.out.println("Principal must be a value between 1,000 and 1,000,000");
    }

    while (true) {
      System.out.print("Enter Annual Interest Rate(1 - 30): ");
      annualInterest = input.nextFloat();

      if (annualInterest >= 1 && annualInterest <= 30) {
        break;
      } else System.out.println("Annual Interest must be a value between 1 and 30");
    }

    while (true) {
      System.out.print("Enter Mortgage Years(1 - 30): ");
      years = input.nextInt();
      if (years >= 1 && years <= 30) {
        break;
      } else System.out.println("Mortgage must be a value between 1 and 30");

    }

    double amount = calculateMortgage(principal, annualInterest, years);
    String formattedAmount = NumberFormat.getCurrencyInstance().format(amount);
    System.out.println(formattedAmount);
  }

  private static double calculateMortgage(int principal, float annualInterest, int years) {
    final int MONTH_IN_A_YEAR = 12;
    final int PERCENTAGE = 100;

    float monthlyInterest = (annualInterest / PERCENTAGE) / MONTH_IN_A_YEAR;
    int numberOfPayments = years * MONTH_IN_A_YEAR;
    float onePlusR = (1 + monthlyInterest);

    return principal * ((monthlyInterest * Math.pow(onePlusR, numberOfPayments)) / (Math.pow(onePlusR, numberOfPayments) - 1));
  }
}
