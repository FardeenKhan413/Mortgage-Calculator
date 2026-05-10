package mortagecalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class MortageCalculator {

    // Class Variables (shared by all methods)
    static double rate;
    static double amount;
    static double downPayment;
    static int loanTerm;
    static double monthlyPayment;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean continueProgram = true;

        while (continueProgram) {

            getUserInput();
            calculateMortgage();
            displayResults();

            System.out.print("Would you like another calculation? (yes/no): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("no")) {
                continueProgram = false;
            }
        }
    }

    // INPUT METHOD
    public static void getUserInput() {

        System.out.print("Enter mortgage rate: ");
        rate = scanner.nextDouble();

        System.out.print("Enter mortgage amount: ");
        amount = scanner.nextDouble();

        System.out.print("Enter downpayment: ");
        downPayment = scanner.nextDouble();

        System.out.print("Enter Loan Term: ");
        loanTerm = scanner.nextInt();

        System.out.println("Calculating Mortgage...");
    }

    // CALCULATION METHOD
    public static void calculateMortgage() {

        double principal = amount - downPayment;
        double monthlyRate = rate / 100 / 12;
        int numberOfPayments = loanTerm * 12;

        monthlyPayment = (principal * monthlyRate) /
                (1 - Math.pow(1 + monthlyRate, -numberOfPayments));

        System.out.printf("Your monthly payment is: %.2f\n", monthlyPayment);
    }

    // DISPLAY METHOD
    public static void displayResults() {

        ArrayList<String> mortgageDetails = new ArrayList<>();

        mortgageDetails.add("Mortgage Rate: " + rate + "%");
        mortgageDetails.add("Mortgage Amount: " + amount);
        mortgageDetails.add("Down Payment: " + downPayment);
        mortgageDetails.add("Monthly Payment: " + String.format("%.2f", monthlyPayment));

        System.out.println("\nSaved Mortgage Details:");

        for (String detail : mortgageDetails) {
            System.out.println(detail);
        }
    }
}