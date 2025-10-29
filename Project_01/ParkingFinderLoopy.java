package Project_01;

import edu.cwi.parking.ParkingSpot;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class ParkingFinderLoopy {
    static final int NUM_SPOTS = 4, SPOTS_INDEX = NUM_SPOTS + 1; //Because arrays start at 0 the spot number will be incorrect (0,1,2,3) unless we add one to compensate
    static ParkingSpot[] ParkingSpots = new ParkingSpot[SPOTS_INDEX]; 
    public static void main(String[] args) {
        final double DEFINED_COST = 0.3;
        String[] Streets = {"Privet Drive", "Pennsylvania Avenue", "Wallaby Way", "Negro Arroyo Lane"}; //String[] Streets = {"1st Street", "2nd Street", "3rd Street", "4th Street"}
        String repeat;
        long seed;
        int parkingTime, carX, carY, longestStreetName = 0, closestSpotDistance = 1000;

        // 1. a.
        Scanner userInput = new Scanner(System.in);
        System.out.println("This program will determine how much it would cost to park in " + NUM_SPOTS + " different "
                       + "\nparking spots for a given amount of time and which spot is closest to you. \n");
        try {
            do {
                // 1. b. i.
                System.out.print("Please enter a random seed value: ");
                seed = userInput.nextLong();

                // 1. b. ii.
                System.out.print("Please enter how much parking time you need in minutes: ");
                parkingTime = userInput.nextInt();

                // 2. a.
                Random rng = new Random(seed);
                carX = rng.nextInt(100);
                carY = rng.nextInt(100);
                // 2. b.
                System.out.printf("%nThe position of your vehicle is:    X: %2d  Y: %2d%n%n", carX, carY);

                // 3. a. i. 
                for (int i = 1; i <= NUM_SPOTS; i++) {
                    ParkingSpots[i] = new ParkingSpot(Streets[i-1], rng.nextInt(100), rng.nextInt(100));
                }

                // 3. a. ii.
                for (int i = 1; i <= NUM_SPOTS; i++) {
                    if (i == 3 || i == 4) 
                        ParkingSpots[i].setCostPerInterval(DEFINED_COST);
                    else 
                        ParkingSpots[i].setCostPerInterval(ParkingSpots[i].DEFAULT_COST);
                } 

                // 3. a. iii.
                for (int i = 1; i <= NUM_SPOTS; i++) {
                    longestStreetName = Math.max(ParkingSpots[i].getStreet().length(), longestStreetName);
                }

                /* 
                for (int i = 1; i <= NUM_SPOTS; i++) {
                    System.out.printf("Spot %1d is on %-" + longestStreetName + "s at X: %2d, Y: %2d%n", i, ParkingSpots[i].getStreet(), ParkingSpots[i].getLocationX(), ParkingSpots[i].getLocationY());
                } System.out.println();
                 */

                // 4. a, b, & c
                for (int i = 1; i <= NUM_SPOTS; i++) {
                    System.out.printf(java.util.Locale.US,"Spot %1d: %80s%n\tDistance:   %2d%n\tTotal Cost:   $%,.2f%n", i, fmtToString(i), (Math.abs(ParkingSpots[i].getLocationX() - carX) + Math.abs(ParkingSpots[i].getLocationY() - carY)), ParkingSpots[i].getCostPerInterval() * Math.ceil((double)parkingTime / 10));
                } System.out.println();

                // 5. a.
                for (int i = 1; i <= NUM_SPOTS; i++) {
                    closestSpotDistance = Math.min(Math.abs(ParkingSpots[i].getLocationX() - carX) + Math.abs(ParkingSpots[i].getLocationY() - carY), closestSpotDistance);
                }

                // 5. b.
                for (int i = 1; i <= NUM_SPOTS; i++) {
                    if (closestSpotDistance == (Math.abs(ParkingSpots[i].getLocationX() - carX) + Math.abs(ParkingSpots[i].getLocationY() - carY)))
                        System.out.printf("Distance to closest spot: %2d%nClosest spot: %80s%n%n", closestSpotDistance, fmtToString(i));
                }

                System.out.print("Would you like to find parking spots with another seed value? [Y/N]: ");
                repeat = userInput.next();
                closestSpotDistance = 1000; // reset closestSpotDistance so it can be calculated properly next time if the function is repeated
            } while (repeat.equalsIgnoreCase("y"));

            System.out.println("\nThank you for using ParkingFinder!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            System.exit(1);
        } finally {
            userInput.close();
        }
    }

    private static String fmtToString(int parkingSpot) {
        String fmtSpotInfo = String.format("%s",ParkingSpots[parkingSpot]);
        fmtSpotInfo = fmtSpotInfo.replace("available", "isAvailable");
        // regex analyzes the string for a digit, period, and a digit but NO digit after them. If it's found the pattern is returned along with a trailing zero
        fmtSpotInfo = fmtSpotInfo.replaceAll("(\\d\\.\\d(?!\\d))", "$10"); /* \\d is a digit, \\. is a period cuz a period by itself matches any character 
                                                                                                (?1 <SOMETHING>) is a negative look ahead "i.e. is this thing NOT next" */
        // if the regex can find a digit, period, digit, and digit-add a dollar sign before the matching pattern
        fmtSpotInfo = fmtSpotInfo.replaceAll("(\\d\\.\\d\\d)", "\\$$1"); // \\$ is dollar sign bc dollar sign calls a matching section: $1, $2, $3... hence the $1 after \\$
        return fmtSpotInfo;
    }
}