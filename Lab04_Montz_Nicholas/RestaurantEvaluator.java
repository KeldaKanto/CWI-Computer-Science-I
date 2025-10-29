import java.util.Scanner;

public class RestaurantEvaluator {
    public static void main(String[] args) {
        boolean fish = false, pizza = false, vegan = false, canWeGo;
        String canHaz;

        Scanner scanFoodOptions = new Scanner(System.in);
        System.out.println("This program evaluates a restaurant's food "
        + "options to see if it meets my friends dietary needs.");

        System.out.print("Please enter whether the restaurant serves fish or not [Y/N]: ");
        canHaz = scanFoodOptions.nextLine();
        if (canHaz.equalsIgnoreCase("y"))
            fish = true;
        else if (canHaz.equalsIgnoreCase("n"))
            fish = false;
        else {
            System.out.println("Invalid input. Please enter a Y or a N.");
            System.exit(1);
        }

        System.out.print("Please enter whether the restaurant serves pizza or not [Y/N]: ");
        canHaz = scanFoodOptions.nextLine();
        if (canHaz.equalsIgnoreCase("y"))
            pizza = true;
        else if (canHaz.equalsIgnoreCase("n"))
            pizza = false;
        else {
            System.out.println("Invalid input. Please enter a Y or a N.");
            System.exit(1);
        }

        System.out.print("Please enter whether the restaurant serves vegan or not [Y/N]: ");
        canHaz = scanFoodOptions.nextLine();
        if (canHaz.equalsIgnoreCase("y"))
            vegan = true;
        else if (canHaz.equalsIgnoreCase("n"))
            vegan = false;
        else {
            System.out.println("Invalid input. Please enter a Y or a N.");
            System.exit(1);
        }

        canWeGo = ((fish == true || pizza == true) && vegan == true);

        if (canWeGo == true)
            System.out.println("Let's go!");
        else
            System.out.println("Sorry, we'll have to think of somewhere else.");

        scanFoodOptions.close();
    }
}