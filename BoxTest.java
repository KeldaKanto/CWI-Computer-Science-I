//*********************************************************************
// PP 5.6
// Design and implement a class called Box that contains instance
// data that represent the height, width, and depth of the box. Also
// include a boolean variable called full as instance data that rep-
// resent whether the box is full or not. Define the Box constructor
// to accept and initialize the height, width, and depth of the box.
// Each newly created Box is empty (the constructor should initialize
// full to false). Include getter and setter methods for all instance
// data. Include a toString method that returns a one-line descrip-
// tion of the box. Create a driver class called BoxTest, whose main
// method instantiates and updates several Box objects.
//*********************************************************************

import java.util.Scanner;
import java.util.ArrayList;

public class BoxTest {
    private static Scanner scanInput = new Scanner(System.in);
    private static ArrayList<Box> Boxes = new ArrayList<Box>();
    private static double[] dimensions = new double[3];
    private static String repeat;
    public static void main(String[] args) {
        final int numBoxes = 3;
        String[] ordinals = {"st", "nd", "rd"}; 
        
        System.out.println("This program will hold the dimensions of 3 "
                         + "box objects and whether or not they are full.");
        for (int countBoxes = 0; countBoxes <= numBoxes; countBoxes++) {
            System.out.printf("Please enter the height, width, and depth of the %1d%2s box separated by spaces: ", countBoxes + 1, ordinals[countBoxes]);
            setValidatedInput();
            Boxes.add(new Box(dimensions[0], dimensions[1], dimensions[2]));
            repeat = addBox();
        }
        //do {

        //} while (repeat.equalsIgnoreCase("y"));
    }


    private static void setValidatedInput() {
        for (int numDimensions = 0; numDimensions <= 3; numDimensions++) {
            while (!scanInput.hasNextLine()) {
                Scanner scanLine = new Scanner(scanInput.nextLine());
                while (scanLine.hasNextDouble()) {
                    System.err.println("Invalid input. Please enter a number.");
                    repeat = "y";
                }
            dimensions[numDimensions] = Double.parseDouble(scanLine.next());
            }
        }
    }

    private static String addBox() {
            scanInput.nextLine();
            System.out.print("Would you like to enter another box? [Y/N]: ");
            repeat = scanInput.nextLine();
            System.out.println();
            return repeat;
    }

    //private static String updateBox() {
        //int whichBox;
        //scanInput.nextLine();
        //System.out.print("Would you like to update any boxes? [Y/N]: ");
        //if (scanInput.next().equalsIgnoreCase("y")) {
            //System.out.print("Which box would you like to update? : ");
            //while (!scanInput.hasNextInt()) {
                //System.out.println("That is not a valid box! Please try again");
            //}
            //whichBox = scanInput.nextInt();
            //switch (whichBox) {
                //case 1:
                    
                //case 2:

                //case 3:

            //}
        //}
    //}
}