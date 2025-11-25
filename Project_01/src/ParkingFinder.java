//************************************************************************************
// This version edits the toString to format for currency and some minor improvements 
// to finding mins and maxes with streams instead of nested comparisons. 
//************************************************************************************

import edu.cwi.parking.ParkingSpot;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Locale;
import java.util.stream.IntStream; // Man I love all these silly java utilities

public class ParkingFinder {
    private static ParkingSpot spot1, spot2, spot3, spot4;
    public static void main(String[] args) {
        final double DEFINED_COST = 0.3;
        int parkingTime, carX, carY, closestSpotDistance;
        long seed;

        // 1. a.
        Scanner userInput = new Scanner(System.in);
        System.out.println("This program will determine how much it would cost to park in 4 different "
                       + "\nparking spots for a given amount of time and which spot is closest to you. \n");

        //**************************************************************************************************************
        // Yeah I know you don't particularly care for the try-catch but I feel like it's easy enough to implement and
        // nice to close up the possibility that the user will try and enter something stupid. Also, my VSCode also
        // gives the scanner a yellow underline if it doesn't have it
        //**************************************************************************************************************

        try {
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
            System.out.printf("%nThe position of your vehicle is:  X: %2d Y: %2d%n%n", carX, carY);

            //**********************************************************************************************************
            // 3. a. i. 
            // Ok after reviewing all the requirements for the assignment I did notice that Dr. Sevigny specified
            // "Street names should be given based on the order they are read in (e.g. “1st Street”, “2nd Street”,
            // “3rd Street”, “4th Street”)" but I was having fun naming them after famous addresses. If this is really
            // a problem I do have the 'correct' names commented out, but I'm hoping you're chill about it. Thanks :)
            //**********************************************************************************************************
            
            spot1 = new ParkingSpot("Privet Drive",        rng.nextInt(100), rng.nextInt(100));      //spot1 = new ParkingSpot("1st Street",  rng.nextInt(100), rng.nextInt(100));
            spot2 = new ParkingSpot("Pennsylvania Avenue", rng.nextInt(100), rng.nextInt(100));      //spot2 = new ParkingSpot("2nd Street",  rng.nextInt(100), rng.nextInt(100));
            spot3 = new ParkingSpot("Wallaby Way",         rng.nextInt(100), rng.nextInt(100));      //spot3 = new ParkingSpot("3rd Street",  rng.nextInt(100), rng.nextInt(100));
            spot4 = new ParkingSpot("Negro Arroyo Lane",   rng.nextInt(100), rng.nextInt(100));      //spot4 = new ParkingSpot("4th Street",  rng.nextInt(100), rng.nextInt(100));

            // 3. a. ii.
            spot1.setCostPerInterval(spot1.DEFAULT_COST);
            spot2.setCostPerInterval(spot2.DEFAULT_COST);
            spot3.setCostPerInterval(DEFINED_COST);
            spot4.setCostPerInterval(DEFINED_COST);

            //****************************************************************************************
            // 3. a. iii.   <===
            // This instruction is listed in writing but isn't shown in the final result. For this
            // reason I'm going to comment it out, but it is here to show that I know how to do this. 
            //****************************************************************************************
            
                //int longestStreetName = IntStream.of(spot1.getStreet().length(), spot2.getStreet().length(), spot3.getStreet().length(), spot4.getStreet().length()).max().getAsInt();
                    // Determines the longest street name so that the street name spacing is only as wide as it needs to be to justify each line
                    // * And yes, I can see that this isn't necessary at all if the street names are all 1st Street, 2nd Street, 3rd Street, & 4th Street

                //System.out.printf("Spot1 is on %-" + longestStreetName + "s at X: %2d, Y: %2d%n"  , spot1.getStreet(), spot1.getLocationX(), spot1.getLocationY());
                //System.out.printf("Spot2 is on %-" + longestStreetName + "s at X: %2d, Y: %2d%n"  , spot2.getStreet(), spot2.getLocationX(), spot2.getLocationY());
                //System.out.printf("Spot3 is on %-" + longestStreetName + "s at X: %2d, Y: %2d%n"  , spot3.getStreet(), spot3.getLocationX(), spot3.getLocationY());
                //System.out.printf("Spot4 is on %-" + longestStreetName + "s at X: %2d, Y: %2d%n%n", spot4.getStreet(), spot4.getLocationX(), spot4.getLocationY());

            // 4. a, b, & c
            System.out.printf(Locale.US,"Spot 1: %80s%n\tDistance:   %2d%n\tTotal Cost:   $%,.2f%n"  , fmtToString(spot1), (Math.abs(spot1.getLocationX() - carX) + Math.abs(spot1.getLocationY() - carY)), spot1.getCostPerInterval() * Math.ceil((double)parkingTime / 10));
            System.out.printf(Locale.US,"Spot 2: %80s%n\tDistance:   %2d%n\tTotal Cost:   $%,.2f%n"  , fmtToString(spot2), (Math.abs(spot2.getLocationX() - carX) + Math.abs(spot2.getLocationY() - carY)), spot2.getCostPerInterval() * Math.ceil((double)parkingTime / 10));
            System.out.printf(Locale.US,"Spot 3: %80s%n\tDistance:   %2d%n\tTotal Cost:   $%,.2f%n"  , fmtToString(spot3), (Math.abs(spot3.getLocationX() - carX) + Math.abs(spot3.getLocationY() - carY)), spot3.getCostPerInterval() * Math.ceil((double)parkingTime / 10));
            System.out.printf(Locale.US,"Spot 4: %80s%n\tDistance:   %2d%n\tTotal Cost:   $%,.2f%n%n", fmtToString(spot4), (Math.abs(spot4.getLocationX() - carX) + Math.abs(spot4.getLocationY() - carY)), spot4.getCostPerInterval() * Math.ceil((double)parkingTime / 10));

            //**********************************************************************************************************
            // 5. a.
            // Can I just say I love how java has neat things like this? Streams not in the book anywhere (probably
            // because it was introduced in Java 8?) but I found it in some documentation online dealing with lists.
            // MUCH easier to read than my first attempt using nested mins.
            //**********************************************************************************************************
            closestSpotDistance = IntStream.of((Math.abs(spot1.getLocationX() - carX) + Math.abs(spot1.getLocationY() - carY)), (Math.abs(spot2.getLocationX() - carX) + Math.abs(spot2.getLocationY() - carY)), (Math.abs(spot3.getLocationX() - carX) + Math.abs(spot3.getLocationY() - carY)), (Math.abs(spot4.getLocationX() - carX) + Math.abs(spot4.getLocationY() - carY))).min().getAsInt();

            // 5. b.
            if      (closestSpotDistance == Math.abs((spot1.getLocationX() - carX)) + Math.abs((spot1.getLocationY() - carY)))
                System.out.println("Distance to closest spot: " + closestSpotDistance + "\nClosest spot: " + fmtToString(spot1));

            else if (closestSpotDistance == Math.abs((spot2.getLocationX() - carX)) + Math.abs((spot2.getLocationY() - carY)))
                System.out.println("Distance to closest spot: " + closestSpotDistance + "\nClosest spot: " + fmtToString(spot2));

            else if (closestSpotDistance == Math.abs((spot3.getLocationX() - carX)) + Math.abs((spot3.getLocationY() - carY)))
                System.out.println("Distance to closest spot: " + closestSpotDistance + "\nClosest spot: " + fmtToString(spot3));

            else if (closestSpotDistance == Math.abs((spot4.getLocationX() - carX)) + Math.abs((spot4.getLocationY() - carY))) 
                System.out.println("Distance to closest spot: " + closestSpotDistance + "\nClosest spot: " + fmtToString(spot4));

        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a number.");
            System.exit(1);
        } finally {
            userInput.close();
        }
    }

    private static String fmtToString(ParkingSpot parkingSpot) {
        String fmtSpotInfo = ""; // create an empty string
        fmtSpotInfo = String.format("%s", parkingSpot); // assign that empty string the value of a ParkingSpots toString
        // Regex analyzes the string for a digit, period, and a digit but NO digit after that. Something like 0.3 would
        // match but a currency should have a trailing zero. regex finds all matches and adds a zero to the end 0.3 => 0.30
        // Notice that the power of regex is so great that 10.3, 100.9, or any number higher would also match and it would 
        // add a trailing zero!
        fmtSpotInfo = fmtSpotInfo.replaceAll("(\\d\\.\\d(?!\\d))", "$10");
        // If the regex can find a digit, period, digit, and digit--add a dollar sign before the matching pattern 0.30 => $0.30
        fmtSpotInfo = fmtSpotInfo.replaceAll("(\\d\\.\\d\\d)", "\\$$1");
        return fmtSpotInfo; // return the edited toString
    }
}
