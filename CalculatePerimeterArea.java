/*
PP 2.10
Write an application that prompts for and reads an integer repre-
senting the length of a square’s side and then prints the square’s
perimeter and area.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatePerimeterArea {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        final int SIDES_OF_A_SQUARE = 4, AREA_CALCULATOR = 2;
        int squareSide, perimeter, area;

        try {
            System.out.print("Please enter a the length of a square's side: ");
            squareSide = userInput.nextInt();

            perimeter = squareSide * SIDES_OF_A_SQUARE;
            area = squareSide * AREA_CALCULATOR;

            System.out.println("The perimeter of this square is: " + perimeter);
            System.out.println("The area of this square is: " + area);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Try again.");
        } finally {
            userInput.close();
        }
    }
}