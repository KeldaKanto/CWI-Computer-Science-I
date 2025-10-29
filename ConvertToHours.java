import java.util.Scanner;
import java.util.InputMismatchException;

public class ConvertToHours {
    public static void main(String[] args) {
        final int SECONDS_IN_MINUTE = 60, SECONDS_IN_HOUR = 3600;
        int inputSeconds, remainingSeconds, finalSeconds, minutes, hours;
        double fracHours;

        Scanner userInput = new Scanner(System.in);
        try {
            System.out.print("Please enter the number of seconds: ");
            inputSeconds = userInput.nextInt();

            hours = inputSeconds /  SECONDS_IN_HOUR;
            remainingSeconds = inputSeconds % SECONDS_IN_HOUR;
            minutes = remainingSeconds / SECONDS_IN_MINUTE;
            finalSeconds = remainingSeconds % SECONDS_IN_MINUTE;

            fracHours = inputSeconds / (double)SECONDS_IN_HOUR;

            System.out.println("Total seconds: " + inputSeconds);
            System.out.println("Hours: " + hours);
            System.out.println("Minutes: " + minutes);
            System.out.println("Seconds: " + finalSeconds);
            System.out.println("\nFractional hours: " + fracHours);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
        } finally {
            userInput.close();
        }
    }
}