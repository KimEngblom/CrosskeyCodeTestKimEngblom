package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testMonthlyPaymentCalculation() {
        String input = "Juha\n1000\n5\n2\n"; // the values for the calculations
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);

        Scanner InputValue = new Scanner(System.in);

        String customerName = InputValue.nextLine();
        assertEquals("Juha", customerName);

        float borrowAmount = InputValue.nextFloat();
        assertEquals(1000.0f, borrowAmount);

        float interest = InputValue.nextFloat();
        assertEquals(5.0f, interest);

        float yearsOfLoan = InputValue.nextFloat();
        assertEquals(2.0f, yearsOfLoan);

        float interestPerMonth = interest / 100 / 12;
        float numberOfPayments = yearsOfLoan * 12;
        double mathPower = Math.pow(1 + interestPerMonth, numberOfPayments);
        double monthlyPayment = borrowAmount * (interestPerMonth * mathPower / (mathPower - 1));

        assertEquals(43.87, monthlyPayment, 0.01);
    }
}
