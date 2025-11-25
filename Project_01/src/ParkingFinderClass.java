import edu.cwi.parking.ParkingSpot;
import java.util.Random;

public class ParkingFinderClass {
    private static final double DEFINED_COST = 0.3;
    private static int closestSpotDistance;
    private final int NUM_SPOTS = 4;
    private final ParkingSpot[] parkingSpots = new ParkingSpot[NUM_SPOTS + 1]; // add one so spot names are 1, 2, 3, 4,
    private int carX, carY;                                                    // when printed with toString

    public ParkingFinderClass(long seed) {
        // 2. a.
        Random rng = new Random(seed);
        carX = rng.nextInt(100);
        carY = rng.nextInt(100);

        String[] streets = {"Privet Drive", "Pennsylvania Avenue", "Wallaby Way", "Negro Arroyo Lane"};
        for (int i = 1; i <= NUM_SPOTS; i++) {
            parkingSpots[i] = new ParkingSpot(streets[i-1], rng.nextInt(100), rng.nextInt(100));
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
        return (Math.abs(parkingSpots[parkingSpot].getLocationX() - carX)
              + Math.abs(parkingSpots[parkingSpot].getLocationY() - carY));
    }

    public double getParkingCost(int parkingSpot, int parkingTime) {
        return parkingSpots[parkingSpot].getCostPerInterval() * Math.ceil((double)parkingTime / 10);
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
            parkingSpots[i].setCostPerInterval(DEFINED_COST);
        else 
            parkingSpots[i].setCostPerInterval(parkingSpots[i].DEFAULT_COST);
        }
    }

    private void findClosestSpotDistance() {
        // 5. a.
        for (int i = 1; i <= NUM_SPOTS; i++) {
            closestSpotDistance = Math.min(getSpotDistance(i), closestSpotDistance);
        }
    }

    public String fmtToString(int parkingSpot) {
        String fmtSpotInfo = String.format("%s",parkingSpots[parkingSpot]);
        fmtSpotInfo = fmtSpotInfo.replace("available", "isAvailable");
        fmtSpotInfo = fmtSpotInfo.replaceAll("(\\d\\.\\d(?!\\d))", "$10");
        fmtSpotInfo = fmtSpotInfo.replaceAll("(\\d\\.\\d\\d)", "\\$$1");
        return fmtSpotInfo;
    }
}

