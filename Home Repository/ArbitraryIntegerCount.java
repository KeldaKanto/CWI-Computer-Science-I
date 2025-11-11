//*******************************************************************
// PP 7.1
// Design and implement an application that reads an arbitrary
// number of integers that are in the range 0 to 50 inclusive and
// counts how many occurrences of each are entered. After all input
// has been processed, print all of the values (with the number of
// occurrences) that were entered one or more times.
//******************************************************************

import java.util.Random;

public class ArbitraryIntegerCount {
    public static void main(String[] args) {
        int numInts; 

        Random rng = new Random();
        numInts = rng.nextInt(21) + 1;

        int[][] nums = new int[numInts][2];

        for (int values = 0; values < nums.length; values++) {
            nums[values][0] = rng.nextInt(51) + 1;
            for (int dupes = 0; dupes < nums[values].length; dupes++) {

            }
        }
        
        for (int values = 0; values < nums.length; values++) {
            if (nums[values][0] == )
        }
    }
}