import java.util.Scanner;

public class RandomWalkDriver {
    public static Scanner scanInput = new Scanner(System.in);
    public static final String ASCII_RED = "\u001B[31m"; // these are ASCII color escape codes
    public static final String ASCII_RESET = "\u001B[0m"; // (they change the color of the terminal output)

    static void main(String[] args) {
        long seed;
        int gridSize;

        RandomWalk walk;

        System.out.print("This program will create a random path " +
                         "from the start to end of a graph. \n");

        System.out.print("Please enter a random seed (0 for no seed): ");
        seed = getUserInput(0);

        System.out.print("Please enter the size of your grid: ");
        gridSize = getUserInput(1);

        scanInput.close();

        if (seed == 0) {
            walk = new RandomWalk(gridSize);
            System.out.printf("New RandomWalk created with no seed value%n");
        } else {
            walk = new RandomWalk(gridSize, seed);
            System.out.printf("New RandomWalk created using seed value '%s'%n", seed);
        }

        walk.createWalk();
        System.out.printf("%n%s%n", walk);
    }

    private static int getUserInput(int lowerBound) {
        String anyInput;
        int intInput = 0;
        boolean hasValidInput = false;

        while (!hasValidInput) {
            if (!scanInput.hasNextInt()) {
                anyInput = scanInput.nextLine();
                System.out.printf(ASCII_RED + "'%s' is not an integer." + ASCII_RESET, anyInput);
                System.out.print("Please enter an integer: ");
            } else {
                intInput = Integer.parseInt(scanInput.nextLine());
                if (intInput < lowerBound) {
                    System.out.printf(ASCII_RED + "'%s' is not a valid integer." + ASCII_RESET, intInput);
                    System.out.printf("Please enter an integer greater than or equal to %d: ", lowerBound);
                } else {
                    hasValidInput = true;
                }
            }
        } System.out.printf("Input '%d' accepted.%n", intInput);
        return intInput;
    }
}