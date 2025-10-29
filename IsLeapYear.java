//************************************************************************************** 
//
// PP 4.1
// Design and implement an application that reads an integer value
// representing a year from the user. The purpose of the program is
// to determine whether the year is a leap year (and therefore has 29
// days in February) in the Gregorian calendar. A year is a leap year if
// it is divisible by 4, unless it is also divisible by 100 but not 400. For
// example, the year 2003 is not a leap year, but 2004 is. The year
// 1900 is not a leap year because it is divisible by 100, but the year
// 2000 is a leap year because even though it is divisible by 100, it is
// also divisible by 400. Produce an error message for any input value
// less than 1582 (the year the Gregorian calendar was adopted).
//
//**************************************************************************************
//
// PP 4.2
// Modify the solution to Programming Project 4.1 so that the user
// can evaluate multiple years. Allow the user to terminate the pro-
// gram using an appropriate sentinel value. Validate each input
// value to ensure that it is greater than or equal to 1582.
//
//**************************************************************************************

import java.util.Scanner;
import java.util.InputMismatchException;

public class IsLeapYear {
    public static void main(String[] args) {
        final int DIV_FOUR = 4, NOT_DIV_HUNDRED = 100, DIV_FOUR_HUNDRED = 400, REMAINDER = 0, GREG_ADOPT = 1582;
        int inputYear;
        boolean isLeapYear = false;
        String again;
        Scanner userInput = new Scanner(System.in);
        System.out.println("This program will test if the entered year is a leap year.");
        
        do {
            try {
                System.out.print("Please enter the year you would like to test: ");
                inputYear = userInput.nextInt();
                if (inputYear < GREG_ADOPT) {
                    System.out.println("Invalid input. Please enter a year "
                    + "after the Gregorian Calendar was introduced (1582).");
                } else {
                
                isLeapYear = (inputYear % DIV_FOUR == REMAINDER && inputYear % NOT_DIV_HUNDRED 
                != REMAINDER || inputYear % DIV_FOUR_HUNDRED == REMAINDER) ? true : false;

                if (!isLeapYear)
                    System.out.println(inputYear + " is a leap year!");
                else
                    System.out.println(inputYear + " is not a leap year.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please input a number.");
            }
            userInput.nextLine();
            System.out.print("Would you like to test another year? [Y/N] ");
            again = userInput.nextLine();
            System.out.println();
        } while (again.equalsIgnoreCase("y"));
        userInput.close();
    }
}