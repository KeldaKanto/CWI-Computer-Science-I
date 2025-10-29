import java.util.Scanner;

public class TestClass {
    private static String again;

    public String testRepeat(Scanner userInput) {
        System.out.print("Evaluate another expression? [Y/N] ");
        again = userInput.nextLine();
        return again;
    }
}