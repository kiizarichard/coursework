package vu.shapesystem;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width,
                     double height,
                     String color,
                     boolean filled)
                     throws InvalidShapeException {

        super(color, filled);

        if (width <= 0 || height <= 0) {

            throw new InvalidShapeException(
                    "Invalid dimensions.");
        }

        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {

        return width * height;
    }

    @Override
    public double getPerimeter() {

        return 2 * (width + height);
    }

    @Override
    public void resize(double factor)
            throws InvalidShapeException {

        if (factor <= 0) {

            throw new InvalidShapeException(
                    "Invalid resize factor.");
        }

        width *= factor;
        height *= factor;
    }

    @Override
    public String toString() {

        return "Rectangle width="
                + width
                + " height="
                + height;
    }
}