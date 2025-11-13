//*******************************************************************
// PP 7.1       Java Foundations
// 
// Design and implement an application that reads an arbitrary
// number of integers that are in the range 0 to 50 inclusive and
// counts how many occurrences of each are entered. After all input
// has been processed, print all of the values (with the number of
// occurrences) that were entered one or more times.
//******************************************************************

import java.util.Random;

public class ArbitraryIntegerCount {
    public static void main(String[] args) {
        final int VALUE = 0, NUM_DUPES = 1;
        int numInts; 

        Random rng = new Random();
        numInts = rng.nextInt(80) + 1;

        int[][] nums = new int[numInts][2];

        // assesses values
        for (int current = 0; current < nums.length; current++) {
            nums[current][0] = rng.nextInt(51);
            for (int test = 0; test < current; test++) {
                if (nums[test][VALUE] == nums[current][VALUE]) {
                    nums[current][NUM_DUPES]++;
                }
            }
        }

        // debug
        for (int values = 0; values < nums.length; values++) {
            System.out.printf("|  %2d : %d  ", nums[values][VALUE], nums[values][NUM_DUPES]);
            if ((values + 1) % 10 == 0) {
                System.out.println("|");
            }
        } System.out.printf("|%n%n");
        
        // print
        for (int values = 0; values < nums.length; values++) {
            if (nums[values][1] == 0){
                System.out.printf("Value %2d appeared %d time%n", nums[values][VALUE], nums[values][NUM_DUPES] + 1);
            } else if (nums[values][1] > 0) {
                System.out.printf("Value %2d appeared %d times%n", nums[values][VALUE], nums[values][NUM_DUPES] + 1);
            }
        }
    }
}