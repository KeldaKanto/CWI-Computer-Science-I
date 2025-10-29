import java.util.InputMismatchException;
import java.util.Scanner;

public class FitnessTracker {
    public static void main(String[] args) {
        final int STEPS_GOAL = 10000;
        int userSteps;

        Scanner scanSteps = new Scanner (System.in);
        
        System.out.println("This program will evaluate your steps.");
        try {
            System.out.print("Please enter how many steps you have taken today: ");
            userSteps = scanSteps.nextInt();
            if (userSteps < (STEPS_GOAL / 10))
                System.out.println("Way to get a good start today!");
            else if (userSteps < (STEPS_GOAL / 2))
                System.out.println("You're almost halfway there!");
            else if (userSteps >= (STEPS_GOAL / 2))
                System.out.println("You're over halfway there!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a positive integer.");
        } finally {
            scanSteps.close();
        }
    }
}