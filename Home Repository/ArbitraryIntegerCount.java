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
        int numInts, total = 0;

        Random rng = new Random();
        numInts = rng.nextInt(25) + 1;
        int[] arbitraryIntegers = new int[numInts];

        for (int i = 0; i < numInts; i++) {
            arbitraryIntegers[i] = rng.nextInt(51);
        }

        for (int j = 0; j < numInts; j++) {
            total = total + arbitraryIntegers[j];
        }

        System.out.printf("%d integers with a random value from 0 to 50 inclusive: %n", numInts);

        for (int k = 0; k < numInts; k++) {
            if (k % 5 == 0)
                System.out.println();
            System.out.printf("%2d  ", arbitraryIntegers[k]);
        }

        System.out.printf("%n%nSum to %d", total);
    }
}