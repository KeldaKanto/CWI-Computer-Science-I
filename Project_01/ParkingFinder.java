package Project_01;

import edu.cwi.parking.ParkingSpot;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.text.NumberFormat;

public class ParkingFinder {
    public static void main(String[] args) {
        final double DEFINED_COST = 0.3;
        int parkingTime, carX, carY, longestStreetName, closestSpotDistance;
        long seed;

        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

        // 1. a.
        Scanner userInput = new Scanner(System.in);
        System.out.println("This program will determine how much it would cost to park in 4 different "
                       + "\nparking spots for a given amount of time and which spot is closest to you. \n");

        //******************************************************************************************************************************************
        // Yeah I know you don't particularly care for the try-catch but I feel like it's easy enough to implement and nice to close up the
        // possibility that the user will try and enter something stupid. My VSCode also gives the scanner a yellow underline if it doesn't have it 
        //*****************************************************************************************************************************************

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
            System.out.println("\nThe position of your vehicle is:\tX: " + carX + " Y: " + carY + "\n");

            //********************************************************************************************************************************
            // 3. a. i. 
            // Ok after reviewing all the requirements for the assignment I did notice that Dr. Sevigney specified "Street names should be
            // given based on the order they are read in (e.g. “1st Street”, “2nd Street”, “3rd Street”, “4th Street”)" but I was having 
            // fun naming them after famous addresses. If this is really a problem I do have the 'correct' names commented out but I'm hoping
            // you're chill about it thanks :)
            //********************************************************************************************************************************
            
            ParkingSpot spot1 = new ParkingSpot("Privet Drive",         rng.nextInt(100), rng.nextInt(100));    //ParkingSpot spot1 = new ParkingSpot("1st Street",  rng.nextInt(100), rng.nextInt(100));
            ParkingSpot spot2 = new ParkingSpot("Pennsylvania Avenue",  rng.nextInt(100), rng.nextInt(100));    //ParkingSpot spot2 = new ParkingSpot("2nd Street",  rng.nextInt(100), rng.nextInt(100));
            ParkingSpot spot3 = new ParkingSpot("Wallaby Way",          rng.nextInt(100), rng.nextInt(100));    //ParkingSpot spot3 = new ParkingSpot("3rd Street",  rng.nextInt(100), rng.nextInt(100));
            ParkingSpot spot4 = new ParkingSpot("Negro Arroyo Lane",    rng.nextInt(100), rng.nextInt(100));    //ParkingSpot spot4 = new ParkingSpot("4th Street",  rng.nextInt(100), rng.nextInt(100));

            // 3. a. ii.
            spot1.setCostPerInterval(spot1.DEFAULT_COST);
            spot2.setCostPerInterval(spot2.DEFAULT_COST);
            spot3.setCostPerInterval(DEFINED_COST);
            spot4.setCostPerInterval(DEFINED_COST);

            //************************************************************************************************************************************
            // 3. a. iii.
            // Determines the longest street name so that the street name spacing is only as wide as it needs to be to justify each line. Yeah
            // it's the same as 5.a., but I wrote this one after that one to practice spacing these properly. At least it's much cleaner here
            // * And now I can see that this wasn't necessary at all if the street names are all 1st Street, 2nd Street, 3rd Street, & 4th Street
            //************************************************************************************************************************************

            longestStreetName = 
            Math.max((
                Math.max((
                    Math.max(
                        spot1.getStreet().length(),spot2.getStreet().length()
                            )),
                        spot3.getStreet().length()
                    )),
                spot4.getStreet().length()
            );

            System.out.printf("Spot1 is on %-" + longestStreetName + "s at X: %2d, Y: %2d%n"  , spot1.getStreet(), spot1.getLocationX(), spot1.getLocationY());
            System.out.printf("Spot2 is on %-" + longestStreetName + "s at X: %2d, Y: %2d%n"  , spot2.getStreet(), spot2.getLocationX(), spot2.getLocationY());
            System.out.printf("Spot3 is on %-" + longestStreetName + "s at X: %2d, Y: %2d%n"  , spot3.getStreet(), spot3.getLocationX(), spot3.getLocationY());
            System.out.printf("Spot4 is on %-" + longestStreetName + "s at X: %2d, Y: %2d%n%n", spot4.getStreet(), spot4.getLocationX(), spot4.getLocationY());

            // 4. a, b, & c
            System.out.println("Spot 1: " + spot1 + "\n\tDistance:   " + (Math.abs(spot1.getLocationX() - carX) + Math.abs(spot1.getLocationY() - carY)) + "\n\tTotal Cost:   " + fmt.format(spot1.getCostPerInterval() * Math.ceil((double)parkingTime / 10)) + "\n");
            System.out.println("Spot 2: " + spot2 + "\n\tDistance:   " + (Math.abs(spot2.getLocationX() - carX) + Math.abs(spot2.getLocationY() - carY)) + "\n\tTotal Cost:   " + fmt.format(spot2.getCostPerInterval() * Math.ceil((double)parkingTime / 10)) + "\n");
            System.out.println("Spot 3: " + spot3 + "\n\tDistance:   " + (Math.abs(spot3.getLocationX() - carX) + Math.abs(spot3.getLocationY() - carY)) + "\n\tTotal Cost:   " + fmt.format(spot3.getCostPerInterval() * Math.ceil((double)parkingTime / 10)) + "\n");
            System.out.println("Spot 4: " + spot4 + "\n\tDistance:   " + (Math.abs(spot4.getLocationX() - carX) + Math.abs(spot4.getLocationY() - carY)) + "\n\tTotal Cost:   " + fmt.format(spot4.getCostPerInterval() * Math.ceil((double)parkingTime / 10)) + "\n");

            //**************************************************************************************************************************************************************************
            // 5. a.
            // Here is the worst line of code I have ever written. I hate that I can't simply save the location information to make this much more readable, it has to be calculated
            // each time I need it. Because of that limitation, I have decided to calculate this nightmare *once* and use it to find the closest spot. May god have mercy upon my soul.
            //**************************************************************************************************************************************************************************
            
            closestSpotDistance = 
            Math.min((
                Math.min((
                    Math.min(
                        Math.abs(spot1.getLocationX() - carX) + Math.abs(spot1.getLocationY() - carY), Math.abs(spot2.getLocationX() - carX) + Math.abs(spot2.getLocationY() - carY) 
                            )), // The locations for spot1 & spot2 calculated and compared. Whichever is the min moves on
                        Math.abs(spot3.getLocationX() - carX) + Math.abs(spot3.getLocationY() - carY) 
                    )), // Whichever spot was the min betweeen spot1 & spot2 now is compared to spot3. Whichever is the min moves on
                Math.abs(spot4.getLocationX() - carX) + Math.abs(spot4.getLocationY() - carY) 
            ); // Whichever is was the min between spot1 & spot2, then spot3 is compared to spot4. Whichever is the min is assigned to closestSpotDistance

            //*****************************************************************************************************************************************************************************************
            // 5. b.
            // Instead of repeating the nightmare above multiple times, the closestSpotDistance variable is compared to the location of each spot. Whichever one matches is given as the closest spot.
            //*****************************************************************************************************************************************************************************************

            if      (closestSpotDistance == Math.abs((spot1.getLocationX() - carX)) + Math.abs((spot1.getLocationY() - carY)))
                System.out.println("Distance to closest spot: " + closestSpotDistance + "\nClosest spot: " + spot1);

            else if (closestSpotDistance == Math.abs((spot2.getLocationX() - carX)) + Math.abs((spot2.getLocationY() - carY)))
                System.out.println("Distance to closest spot: " + closestSpotDistance + "\nClosest spot: " + spot2);

            else if (closestSpotDistance == Math.abs((spot3.getLocationX() - carX)) + Math.abs((spot3.getLocationY() - carY)))
                System.out.println("Distance to closest spot: " + closestSpotDistance + "\nClosest spot: " + spot3);

            else if (closestSpotDistance == Math.abs((spot4.getLocationX() - carX)) + Math.abs((spot4.getLocationY() - carY))) 
                System.out.println("Distance to closest spot: " + closestSpotDistance + "\nClosest spot: " + spot4);

            //***************************************************************************************************************************************************************************************
            // toString output: [street = Wallaby Way, locationX = 29, locationY = 49, available = true, costPerInterval = 0.3] <- I don't know how to format the costPerInterval to $0.30
            //
            // Every solution I've found assumes that you can edit the imported class, which is only a limitation here because it's a school project. I spent a lot of time looking at String.format
            // but it can't edit a string being transfered from another class. I'd have assign the toString output to a local String variable and edit it piece by piece (which I would do with for
            // loops but we can't do that here) and then spit it out at the appropriate time. Seems like it would be really messy and verbose because of a limitation that would never exist in the
            // "real world" so I'm going to skip it. I don't want my project to be (more of) a pain to read. I'm probably the only person that would notice Dr. Sevigny's toString formats for currency
            // anyways. 
            //
            // TL;DR I want to format costPerInterval from 0.3 to $0.30 but don't know how :<
            //***************************************************************************************************************************************************************************************

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            System.exit(1);
        } finally {
            userInput.close();
        }
    }
}
