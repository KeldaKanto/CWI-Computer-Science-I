import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import edu.cwi.randomwalk.RandomWalkInterface;

public class RandomWalk implements RandomWalkInterface {
    int size; 
    boolean done = false;

    ArrayList<Point> path = new ArrayList<>();
    Point start, end, current;

    Random rng;

    public RandomWalk(int gridSize) {
        start = new Point(0, gridSize - 1);
        end = new Point(gridSize - 1, 0);
        current = new Point(start);

        path.add(start); // make sure to add the start to the path record
        rng = new Random();
    }

    public RandomWalk(int gridSize, long seed) {
        start = new Point(0, gridSize - 1);
        end = new Point(gridSize - 1, 0);
        current = new Point(start);

        path.add(start); // make sure to add the start to the path record
        rng = new Random(seed);
    }

    public void step() {
        if (current.equals(end)) {
            done = true;
        } else {
            if (current.x == end.x) { // if current point is at the edge, only move along it
                current.translate(0, -1);
            } else if (current.y == end.y) {
                current.translate(1, 0);
            } else { // move up or to the side at random
                if (rng.nextInt(2) == 0) {
                    current.translate(1, 0);
                } else {
                    current.translate(0, -1);
                }
            } path.add(new Point(current)); // record this location as a new point
        }
    }

    public void createWalk() {
        while (!isDone()) {
            step();
        }
    }

    public boolean isDone() {
        return done;
    }

    public int getGridSize() {
        return size;
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
        return path;
    }

    @Override
    public String toString() {
        StringBuilder printString = new StringBuilder();
        for ( Point points : path ) {
            printString.append("[").append(points.x).append(",").append(points.y).append("] ");
        } return printString.toString();
    }
}
