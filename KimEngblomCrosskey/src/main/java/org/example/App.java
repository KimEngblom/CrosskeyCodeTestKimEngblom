package org.example;

/**
 * Kim Engbloms Code test - Mortage plan
 *
 */
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner InputValue = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Name:");
        String customerName = InputValue.nextLine();

        Scanner scanner = new Scanner(System.in);
        float borrowAmount = getInputFloat("Enter Total amount of loan:", scanner);
        float interest = getInputFloat("Enter Interest:", scanner);
        float yearsOfLoan = getInputFloat("Enter years:", scanner);

        float interestPerMonth = interest / 100 / 12;
        float numberOfPayments = yearsOfLoan * 12;

        double mathPower = Math.pow(1 + interestPerMonth, numberOfPayments);

        double monthlyPayment = borrowAmount * (interestPerMonth * mathPower / (mathPower - 1));

        System.out.println(customerName + "s montly payment is: " + String.format("%.2f", monthlyPayment) + "€");
        System.out.println(customerName + "s total payment is: " + String.format("%.2f", monthlyPayment * numberOfPayments) + "€");

        //Dubblecheck parameters to see the input values provided.
        System.out.println("customerName is: " + customerName);  // Output for customername
        System.out.println("borrowAmount is: " + borrowAmount);  // Output for Total amount borrowed
        System.out.println("interest is: " + interest + "%");  // Output for interest %
        System.out.println("yearsOfLoan is: " + yearsOfLoan);  // Output for how long the loan is in years
    }

    private static float getInputFloat(String prompt, Scanner scanner) {
        while (true) {
            try {
                System.out.println(prompt);
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number in this format number.number (5.5).");
            }
        }
    }
}