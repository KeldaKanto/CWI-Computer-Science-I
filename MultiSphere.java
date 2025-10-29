//************************************************************************************
// PP 5.4
// Design and implement a class called Sphere that contains in-
// stance data that represent the sphere’s diameter. Define the
// Sphere constructor to accept and initialize the diameter, and
// include getter and setter methods for the diameter. Include meth-
// ods that calculate and return the volume and surface area of the
// sphere (see Programming Project 3.5 for the formulas). Include
// a toString method that returns a one-line description of the
// sphere. Create a driver class called MultiSphere, whose main
// method instantiates and updates several Sphere objects.
//************************************************************************************

import java.util.Scanner;
import java.util.InputMismatchException;

public class MultiSphere {
    public static void main(String[] args) {
        final int NUM_SPHERES = 4;
        Sphere[] spheres = new Sphere[NUM_SPHERES + 1];
        String repeat;
        Scanner userInput = new Scanner(System.in);
        
        System.out.printf("%nThis program will calculate the volume "
                        + "%nand surface area of 4 sphere objects.%n");

        try {
            do {
                for (int i = 1; i <= NUM_SPHERES; i++) {
                    System.out.print("Please enter the diameter of sphere " + NUM_SPHERES + ": ");
                    spheres[i] = new Sphere(userInput.nextDouble());
                    System.out.println("You entered: " + spheres[i].getDiameter());
                    System.out.printf(spheres[i].toString(), i, spheres[i].getVolume(), spheres[i].getSurfaceArea());
                }

                System.out.print("Would you like to enter another set of spheres? [Y/N]: ");
                repeat = userInput.next();
            } while (repeat.equalsIgnoreCase("y"));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            System.exit(1);
        } finally {
            userInput.close();
        }
    }
}