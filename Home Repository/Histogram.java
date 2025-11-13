//***********************************************************************
// PP 7.3       Java Foundations
//
// Design and implement an application that creates a histogram
// that allows you to visually inspect the frequency distribution of
// a set of values. The program should read in an arbitrary number
// of integers that are in the range 1 to 100 inclusive; then it should
// produce a chart similar to the following one that indicates how
// many input values fell in the range 1 to 10, 11 to 20, and so on.
// Print one asterisk for each value entered.
//
//  1 - 10  | *****
// 11 - 20  | **
// 21 - 30  | *******************
// 31 - 40  |
// 41 - 50  | ***
// 51 - 60  | ********
// 61 - 70  | **
// 71 - 80  | *****
// 81 - 90  | *******
// 91 – 100 | *********
//***********************************************************************

import java.util.Random;

public class Histogram {
    public static void main(String[] args) {
        final int SECTIONS = 10;
        int numInts, range, numStars;

        Random rng = new Random();
        numInts = rng.nextInt(100) + 1;

        int[] nums = new int[numInts];
        int[] rangeCount = new int[SECTIONS];

        // assign values
        for (int current = 0; current < nums.length; current++) {
            nums[current] = rng.nextInt(100) + 1;
        }

        // assess values
        for (int section = 1; section <= 10; section++) { // assses each section of 10 integers
            range = section * 10; // assign a range value to each section
            for (int current = 0; current < nums.length; current++) { // check all values for if they are within the current section
                if (nums[current] >= (range - 9) && nums[current] < range) {  
                    rangeCount[section - 1]++; // record which range they are apart of
                }
            }
        }

        // debug
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("| %3d  ", nums[i]);
            if ((i + 1) % 10 == 0) {
                System.out.println("|");
            }
        } System.out.printf("|%n%n");

        // print histogram
        for (int section = 1; section <= 10; section++) {
            System.out.printf("%2d - %-3d | ", section * 10 - 9, section * 10);
            numStars = rangeCount[section - 1];
            for (int count = 1; count <= numStars; count++) {
                System.out.print("*");
            } System.out.println();
        }

    }
}