import edu.cwi.parking.ParkingSpot;
import java.util.Scanner;
import java.util.Random;
import java.text.NumberFormat;

public class ParkingFinderDaelyn {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int time;
        long seed;

        System.out.println("Enter your random seed:");
        seed = scan.nextLong();
        Random generator = new Random(seed);

        System.out.println("Enter the necessary parking time (minutes):");
        time = scan.nextInt();

        int carX;
        int carY;
        
        carX = generator.nextInt(100);
        carY = generator.nextInt(100);

        System.out.println("The position of your vehicle is:\tX: " + carX + " Y: " + carY);

        ParkingSpot spotOne = new ParkingSpot("Ghost Dr.", generator.nextInt(100), generator.nextInt(100));
        ParkingSpot spotTwo = new ParkingSpot("Vampire Rd.", generator.nextInt(100), generator.nextInt(100));
        ParkingSpot spotThree = new ParkingSpot("Black Cat St.", generator.nextInt(100), generator.nextInt(100));
        ParkingSpot spotFour = new ParkingSpot("Pumpkin Dr.", generator.nextInt(100), generator.nextInt(100));

        final double DEFAULT_COST = 0.3;
        spotOne.setCostPerInterval(spotOne.DEFAULT_COST);
        spotTwo.setCostPerInterval(spotTwo.DEFAULT_COST);
        spotThree.setCostPerInterval(DEFAULT_COST);
        spotFour.setCostPerInterval(DEFAULT_COST);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Spot 1: " + spotOne + "\n\tDistance to spot one is: " + (Math.abs(carX - spotOne.getLocationX()) + Math.abs(carY - spotOne.getLocationY())) + "\n\tTotal Cost for spot one is: " + (currency.format(spotOne.getCostPerInterval() * Math.ceil((double)time / 10))));
        System.out.println("Spot 2: " + spotTwo + "\n\tDistance to spot two is: " + (Math.abs(carX - spotTwo.getLocationX()) + Math.abs(carY - spotTwo.getLocationY())) + "\n\tTotal Cost for spot two is: " + (currency.format(spotTwo.getCostPerInterval() * Math.ceil((double)time / 10))));
        System.out.println("Spot 3: " + spotThree + "\n\tDistance to spot three is: " + (Math.abs(carX - spotThree.getLocationX()) + Math.abs(carY - spotThree.getLocationY())) + "\n\tTotal Cost for spot three is: " + (currency.format(spotThree.getCostPerInterval() * Math.ceil((double)time / 10))));
        System.out.println("Spot 4: " + spotFour + "\n\tDistance to spot four is: " + (Math.abs(carX - spotFour.getLocationX()) + Math.abs(carY - spotFour.getLocationY())) + "\n\tTotal Cost for spot four is: " + (currency.format(spotFour.getCostPerInterval() * Math.ceil((double)time / 10))));

        int closest = Math.min(Math.abs(carX - spotFour.getLocationX()) + Math.abs(carY - spotFour.getLocationY()), Math.min(Math.abs(carX - spotThree.getLocationX()) + Math.abs(carY - spotThree.getLocationY()), Math.min(Math.abs(carX - spotOne.getLocationX()) + Math.abs(carY - spotOne.getLocationY()), Math.abs(carX - spotTwo.getLocationX()) + Math.abs(carY - spotTwo.getLocationY()))));

        if ((Math.abs(carX - spotOne.getLocationX()) + Math.abs(carY - spotOne.getLocationY())) == closest) {
            System.out.println("The distance to the closest spot is: " + (Math.abs(carX - spotOne.getLocationX()) + Math.abs(carY - spotOne.getLocationY())) + "\nThe closest spot is: " + spotOne);
        } else if ((Math.abs(carX - spotTwo.getLocationX()) + Math.abs(carY - spotTwo.getLocationY())) == closest) {
            System.out.println("The distance to the closest spot is: " + (Math.abs(carX - spotTwo.getLocationX()) + Math.abs(carY - spotTwo.getLocationY())) + "\nThe closest spot is: " + spotTwo);
        } else if ((Math.abs(carX - spotThree.getLocationX()) + Math.abs(carY - spotThree.getLocationY())) == closest) {
            System.out.println("The distance to the closest spot is: " + (Math.abs(carX - spotThree.getLocationX()) + Math.abs(carY - spotThree.getLocationY())) + "\nThe closest spot is: " + spotThree);
        } else if ((Math.abs(carX - spotFour.getLocationX()) + Math.abs(carY - spotFour.getLocationY())) == closest) {
            System.out.println("The distance to the closest spot is: " + (Math.abs(carX - spotFour.getLocationX()) + Math.abs(carY - spotFour.getLocationY())) + "\nThe closest spot is: " + spotFour);
        }

        scan.close();
    }
}