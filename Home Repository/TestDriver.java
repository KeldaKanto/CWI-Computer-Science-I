import java.util.Scanner;

public class TestDriver {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String again;

        TestClass test = new TestClass();
        do {
            again = test.testRepeat(userInput);
        } while (again.equalsIgnoreCase("y"));

        userInput.close();
    }
}
