/*
PP 2.11
Write an application that prompts for and reads the numerator
and denominator of a fraction as integers and then prints the deci-
mal equivalent of the fraction.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class FractionAnalyzer {
    public static void main(String[] args) {
        Scanner fractionInput = new Scanner(System.in);
        int numerator, denominator;

        try {
            System.out.print("Enter the numerator: ");
            numerator = fractionInput.nextInt();

            System.out.print("Enter the denominator: ");
            denominator = fractionInput.nextInt();

            if (denominator == 0) {
                System.out.println("The denominator cannot be 0. Try again.");
            } else {
                double decimalEquivalent = (double) numerator / denominator;
                System.out.println("The decimal equivalent to this fraction is: " + decimalEquivalent);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Try again.");
        } finally {
            fractionInput.close();
        }
    }
}