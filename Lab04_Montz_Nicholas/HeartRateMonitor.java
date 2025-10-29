import java.util.InputMismatchException;
import java.util.Scanner;

public class HeartRateMonitor {
    public static void main(String[] args) {
        final int LOWEST_HR = 120, HIGHEST_HR = 150;
        int userHeartRate;

        Scanner scanHeartRate = new Scanner(System.in);

        System.out.println("This program will evaluate your heart rate.");
        try {
            System.out.print("Please enter your current heart rate: ");
            userHeartRate = scanHeartRate.nextInt();
            if (userHeartRate >= LOWEST_HR && userHeartRate <= HIGHEST_HR)
                System.out.println("You're right on track!");
            else if (userHeartRate < LOWEST_HR)
                System.out.println("You're doing great, but try to push it a bit!");
            else if (userHeartRate > HIGHEST_HR)
                System.out.println("You're on fire! Slow it down just a bit.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a positive integer.");
        } finally {
            scanHeartRate.close();
        }
    }
}