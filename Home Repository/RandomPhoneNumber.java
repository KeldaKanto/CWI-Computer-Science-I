/*
Write an application that creates and prints a random phone
number of the form (###)-###-####
the output. Do not let the first three digits contain an 8 or 9
(but don’t be more restrictive than that), and make sure that the
second set of three digits is not greater than 742. Hint: Think
through the easiest way to construct the phone number. Each
digit does not have to be determined separately.
*/

import java.util.Random;

public class RandomPhoneNumber {
    public static void main(String[] args) {
        Random rng = new Random();
        int areaCode, exchangeCode, lineCode;
        
        areaCode = (rng.nextInt(7) + 1) * 100 + (rng.nextInt(8) * 10) + rng.nextInt(8); 
        exchangeCode = rng.nextInt(743);
        lineCode = rng.nextInt(10000);

        System.out.printf("(%03d)-%04d-%04d", areaCode, exchangeCode, lineCode);
    }
}