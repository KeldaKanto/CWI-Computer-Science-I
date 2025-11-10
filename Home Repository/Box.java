//*********************************************************************
// PP 5.6
// Design and implement a class called Box that contains instance
// data that represent the height, width, and depth of the box. Also
// include a boolean variable called full as instance data that rep-
// resent whether the box is full or not. Define the Box constructor
// to accept and initialize the height, width, and depth of the box.
// Each newly created Box is empty (the constructor should initialize
// full to false). Include getter and setter methods for all instance
// data. Include a toString method that returns a one-line descrip-
// tion of the box. Create a driver class called BoxTest, whose main
// method instantiates and updates several Box objects.
//*********************************************************************

public class Box {
    private double height, width, depth;
    private boolean full;

    public Box(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        full = false;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public boolean getFull() {
        return full;
    }

    public String toString() {
        return "A box has 4 instances: height, width, depth, and full. ";
    }
}
