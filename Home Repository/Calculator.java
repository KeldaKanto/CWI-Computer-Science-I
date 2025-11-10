public class Calculator {
    public static void main(String[] args) {
        double total = 0;
        for (int k = 1; k <= 4; k++) {
            total = (2 * Math.pow(k,2)) + 8;
        }
        System.out.println("The total is " + total);
    }
}
