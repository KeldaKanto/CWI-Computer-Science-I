//*********************************************************************
// PP 2.11
// Write an application that prompts for and reads the numerator
// and denominator of a fraction as integers and then prints the deci-
// mal equivalent of the fraction.
//*********************************************************************

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class FractionAnalyzerImproved {
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        String inputNum = null, inputDenom = null, repeat;
        double decimalEquivalent;
        int numerator, denominator;

        try {
            do {
                System.out.printf("%nEnter a fraction separated by a slash [x/y]: ");
                Scanner scanLine = new Scanner(scanInput.nextLine());
                scanLine.useDelimiter("/");
                while (scanLine.hasNext()) {
                    inputNum = scanLine.next().replaceAll("^\\s+|\\s+$", "");
                    inputDenom = scanLine.next().replaceAll("^\\s+|\\s+$", "");
                }
                numerator = Integer.parseInt(inputNum);
                denominator = Integer.parseInt(inputDenom);

                if (denominator == 0) {
                    System.out.printf("%nThe denominator cannot be 0. (Divide by 0 error). Try again%n");
                    repeat = "y";
                } else {
                    System.out.printf("%nYou entered: %d/%d%n", numerator, denominator);
                    decimalEquivalent = (double) numerator / denominator;
                    System.out.printf(Locale.US, "The decimal equivalent to this fraction is: %.4f%n", decimalEquivalent);
                }

                System.out.printf("%nWould you like to evaluate another fraction? [Y/N]: ");
                repeat = scanInput.nextLine();
                scanLine.close();
            } while (repeat.equalsIgnoreCase("y"));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            System.exit(1);
        } finally {
            scanInput.close();
        }
    }
}