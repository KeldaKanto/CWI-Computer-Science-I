public class Sphere {
    private double diameter, radius;

    public Sphere(double diameter) {
        this.diameter = diameter;
        radius = diameter / 2.0;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius,3);
    }

    public double getSurfaceArea() {
        return 4.0 * Math.PI * Math.pow(radius,2);
    }

    @Override
    public String toString() {
        return "Sphere - \nDiameter: " + getDiameter() + "\nVolume: " + getVolume() + "\nSurface Area: " + getSurfaceArea();
    }
}