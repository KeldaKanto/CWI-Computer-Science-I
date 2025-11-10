/*
PP 2.8
Write an application that determines the value of the coins in a jar
and prints the total in dollars and cents. Read integer values that
represent the number of quarters, dimes, nickels, and pennies.
*/

public class CoinCount {
    public static void main(String[] args) {
        //Declare values of coin denominations
        final double QUARTER_VALUE = 0.25, DIME_VALUE = 0.10, NICKLE_VALUE = 0.05, PENNY_VALUE = 0.01;
        int quarters, dimes, nickles, pennies;
        double total;

        //Assign the number of coins in this jar
        quarters = 42;
        dimes = 11;
        nickles = 21;
        pennies = 16;

        //Calculate the total coin value by multiplying number of coins by their value and adding them all together
        total = (quarters * QUARTER_VALUE) + (dimes * DIME_VALUE) + (nickles * NICKLE_VALUE) + (pennies * PENNY_VALUE);

        //Print the total value
        System.out.println("The value of the coins in this jar is $" + total);
    }
}