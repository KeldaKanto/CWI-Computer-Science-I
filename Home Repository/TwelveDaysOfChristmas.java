//************************************************************************************** 
// 4.14
// Design and implement an application that prints the verses of the
// song “The Twelve Days of Christmas,” in which each verse adds
// one line. The first two verses of the song are: 
//
// On the 1st day of Christmas my true love gave to me
// A partridge in a pear tree.
//
// On the 2nd day of Christmas my true love gave to me
// Two turtle doves, and
// A partridge in a pear tree.
//
// Use a switch statement in a loop to control which lines get
// printed. Hint: Order the cases carefully and avoid the break
// statement. Use a separate switch statement to put the appropri-
// ate suffix on the day number (1st, 2nd, 3rd, etc.).
//************************************************************************************** 

public class TwelveDaysOfChristmas {
    public static void main(String[] args) {
        
        for (int day = 1; day <= 12; day++) {
            switch (day) {
                case 1:
                    System.out.println("On the " + day + "st day of Christmas my true love gave to me");
                    break;
                case 2:
                    System.out.println("On the " + day + "nd day of Christmas my true love gave to me");
                    break;
                case 3:
                    System.out.println("On the " + day + "rd day of Christmas my true love gave to me");
                    break;
                default:
                    System.out.println("On the " + day + "th day of Christmas my true love gave to me");
                    break;
            }

            switch (day) {
                case 12: 
                    System.out.println("Twelve drummers drumming");
                case 11:
                    System.out.println("Eleven pipers pipping");
                case 10:
                    System.out.println("Ten lords a leaping");
                case 9:
                    System.out.println("Nine ladies dancing");
                case 8:
                    System.out.println("Eight maids a milking");
                case 7:
                    System.out.println("Seven swans a swimming");
                case 6:
                    System.out.println("Six geese a laying");
                case 5:
                    System.out.println("Five golden rings");
                case 4:
                    System.out.println("Four calling birds");
                case 3:
                    System.out.println("Three French hens");
                case 2:
                    System.out.println("Two turtle doves, and");
                case 1:
                    System.out.println("A partriage in a pear tree.");
            }

            System.out.println();
        }

    }
}