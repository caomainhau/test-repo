// Interface: GeometricObject
public interface GeometricObject {
    double getPerimeter();
    double getArea();
}

// Class: Circle
public class Circle implements GeometricObject {
    // Protected variable
    protected double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementation of GeometricObject interface
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Additional method
    public String toString() {
        return "Circle[radius=" + radius + "]";
    }
}
