import java.util.InputMismatchException;
import java.util.Scanner;

public class DollarEvaluator {
    public static void main(String[] args) {
        final int YOU_BROKE = 0, GOT_BENJAMIN = 100;
        int dollars;

        Scanner scanDollars = new Scanner(System.in);

        System.out.println("This program will evaluate your cash situation.");
        try {
            System.out.print("Please enter how many dollars you have: ");
            dollars = scanDollars.nextInt();
            if (dollars == YOU_BROKE) 
                System.out.println("Sorry kid. You're broke!");
            else if (dollars < GOT_BENJAMIN) 
                System.out.println("You've got some spending money!");
            else 
                System.out.println("Looks to me like you're rich!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a positive integer.");
        } finally {
            scanDollars.close();
        }
    }
}