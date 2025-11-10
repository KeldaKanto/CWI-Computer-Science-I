import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Please input several numbers in a line: ");
        while (!scanInput.hasNext("exit")) {
            Scanner scanLine = new Scanner(scanInput.nextLine());
            int sum = 0;
            while (scanLine.hasNextInt()) {
                sum += scanLine.nextInt();
            }
            System.out.println("The sum of these numbers is " + sum);
            scanLine.close();
        }
        scanInput.close();
    }
}