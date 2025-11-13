//*****************************************************************
// This version of ParkingFinder uses a class/driver combo to make 
// managing parking spots easier. 
//*****************************************************************

import java.util.Scanner;
import java.util.InputMismatchException;

public class ParkingFinderDriver {
    public static void main(String[] args) {
        String repeat;
        long seed;
        int parkingTime;

        Scanner userInput = new Scanner(System.in);
        System.out.println("This program will determine how much it would cost to park in several different "
                       + "\nparking spots for a given amount of time and which spot is closest to you. \n");
        try {
            do {
                // 1. b. i.
                System.out.print("Please enter a random seed value: ");
                seed = userInput.nextLong();
                ParkingFinderClass parkingClass = new ParkingFinderClass(seed);

                // 1. b. ii.
                System.out.print("Please enter how much parking time you need in minutes: ");
                parkingTime = userInput.nextInt();

                // 2. b.
                System.out.printf("%nThe position of your vehicle is:    X: %2d  Y: %2d%n%n", parkingClass.getCarX(), parkingClass.getCarY());

                // 4. a, b, & c
                for (int i = 1; i <= parkingClass.getNumSpots(); i++) {
                    System.out.printf(java.util.Locale.US,"Spot %1d: %80s%n\tDistance:   %2d%n\tTotal Cost:   $%,.2f%n", i, parkingClass.fmtToString(i), parkingClass.getSpotDistance(i), parkingClass.getParkingCost(i,parkingTime));
                } System.out.println();

                // 5. b.
                for (int i = 1; i <= parkingClass.getNumSpots(); i++) {
                    if (parkingClass.getClosestSpotDistance() == parkingClass.getSpotDistance(i))
                        System.out.printf("Distance to closest spot: %2d%nClosest spot: %80s%n%n", parkingClass.getClosestSpotDistance(), parkingClass.fmtToString(i));
                }
                
                System.out.print("Would you like to find parking spots with another seed value? [Y/N]: ");
                repeat = userInput.next();
            } while (repeat.equalsIgnoreCase("y"));

            System.out.println("\nThank you for using ParkingFinder!");

        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a number.");
            System.exit(1);
        } finally {
            userInput.close();
        }
    }
}
