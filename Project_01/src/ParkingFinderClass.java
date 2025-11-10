import edu.cwi.parking.ParkingSpot;
import java.util.Random;

public class ParkingFinderClass {
    private static final double DEFINED_COST = 0.3;
    private static int closestSpotDistance;
    private final int NUM_SPOTS = 4;
    private ParkingSpot[] ParkingSpots = new ParkingSpot[NUM_SPOTS + 1]; // add one so spot names are correct when printed with toString
    private int carX, carY;

    public ParkingFinderClass(long seed) {
        // 2. a.
        Random rng = new Random(seed);
        carX = rng.nextInt(100);
        carY = rng.nextInt(100);

        String[] Streets = {"Privet Drive", "Pennsylvania Avenue", "Wallaby Way", "Negro Arroyo Lane"};
        for (int i = 1; i <= NUM_SPOTS; i++) {
            ParkingSpots[i] = new ParkingSpot(Streets[i-1], rng.nextInt(100), rng.nextInt(100));
        }
        setClosestSpotDistance();
        // 3. a. ii.
        setCostPerInterval();
        // 5. a.
        findClosestSpotDistance();
    }

    public int getNumSpots() {
        return NUM_SPOTS;
    }

    public int getCarX() {
        return carX;
    }

    public int getCarY() {
        return carY;
    }
    
    public int getSpotDistance(int parkingSpot) {
        return (Math.abs(ParkingSpots[parkingSpot].getLocationX() - carX) + Math.abs(ParkingSpots[parkingSpot].getLocationY() - carY));
    }

    public double getParkingCost(int parkingSpot, int parkingTime) {
        return ParkingSpots[parkingSpot].getCostPerInterval() * Math.ceil((double)parkingTime / 10);
    }

    public int getClosestSpotDistance() {
        return closestSpotDistance;
    }

    private void setClosestSpotDistance() {
        closestSpotDistance = 1000;
    }

    private void setCostPerInterval() {
        // 3. a. ii.
        for (int i = 1; i <= NUM_SPOTS; i++) {
        if (i == 3 || i == 4) 
            ParkingSpots[i].setCostPerInterval(DEFINED_COST);
        else 
            ParkingSpots[i].setCostPerInterval(ParkingSpots[i].DEFAULT_COST);
        }
    }

    private void findClosestSpotDistance() {
        // 5. a.
        for (int i = 1; i <= NUM_SPOTS; i++) {
            closestSpotDistance = Math.min(getSpotDistance(i), closestSpotDistance);
        }
    }

    public String fmtToString(int parkingSpot) {
        String fmtSpotInfo = String.format("%s",ParkingSpots[parkingSpot]);
        fmtSpotInfo = fmtSpotInfo.replace("available", "isAvailable");
        fmtSpotInfo = fmtSpotInfo.replaceAll("(\\d\\.\\d(?!\\d))", "$10");
        fmtSpotInfo = fmtSpotInfo.replaceAll("(\\d\\.\\d\\d)", "\\$$1");
        return fmtSpotInfo;
    }
}

