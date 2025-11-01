import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import edu.cwi.randomwalk.RandomWalkInterface;

public class RandomWalk implements RandomWalkInterface {
    int size; 
    boolean done;

    ArrayList<Point> path = new ArrayList<>();
    Point start, end, current;

    Random rng;

    public RandomWalk(int gridSize) {
        start = new Point(0, gridSize - 1);
        end = new Point(gridSize -1, 0);

        rng = new Random();
    }

    public RandomWalk(int gridSize, long seed) {
        start = new Point(0, gridSize - 1);
        end = new Point(gridSize -1, 0);

        rng = new Random(seed);
    }

    public void step() {
        Point p1 = new Point(x, y);
        path.add(p1);


    }

    public void createWalk() {

    }

    public boolean isDone() {
        return done;
    }

    public int getGridSize() {

    }

    public Point getStartPoint() {
        return start;
    }

    public Point getEndPoint() {
        return end;
    }

    public Point getCurrentPoint() {
        return current;
    }

    public ArrayList<Point> getPath() {

    }

    @Override
    public String toString() {

    }
}
