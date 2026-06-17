package vu.shapesystem;
public class ShapeDemo {
    
   
    public static void printAreas(Shape[] shapes) {
        System.out.println("=== PRINTING AREAS ===");
        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("Shape %d: Area = %.2f%n", i + 1, shapes[i].getArea());
        }
        System.out.println();
    }
    
    /**
     * Returns the shape with the largest area
     */
    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            return null;
        }
        
        Shape largestShape = shapes[0];
        double maxArea = shapes[0].getArea();
        
        for (int i = 1; i < shapes.length; i++) {
            double currentArea = shapes[i].getArea();
            if (currentArea > maxArea) {
                maxArea = currentArea;
                largestShape = shapes[i];
            }
        }
        
        return largestShape;
    }
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("SHAPE HIERARCHY DEMO");
        System.out.println("========================================\n");
        
        // Create valid shapes
        System.out.println("=== CREATING SHAPES ===");
        
        
        // Find largest shape
        Circle circle = new Circle(5.0, "red", true);

Rectangle rect = new Rectangle(4.0, 6.0, "blue", false);

Triangle triangle = new Triangle(3.0, 4.0, 5.0, "green", true);
        Shape[] shapes = {circle, rect, triangle};
        System.out.println("=== FINDING LARGEST SHAPE ===");
        Shape largestShape = largest(shapes);
        System.out.println("Largest shape: " + largestShape);
        System.out.println();
        
        // Demonstrate exception handling
        System.out.println("=== EXCEPTION HANDLING DEMONSTRATION ===");
        
        System.out.println("1. Attempting to create a triangle with invalid sides (1, 1, 3):");
        try {
            Triangle invalidTriangle =
        new Triangle(
                1.0,
                1.0,
                3.0,
                "yellow",
                true);
      
            System.out.println("This line should not be printed");
        } catch (InvalidShapeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\n2. Attempting to create a circle with negative radius:");
        try {
        try {

    Circle invalidCircle =
            new Circle(
                    -5.0,
                    "red",
                    true);

} catch (InvalidShapeException e) {

    System.out.println(e.getMessage());
}    
            System.out.println("This line should not be printed");
        } catch (InvalidShapeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\n3. Attempting to resize with negative factor:");
       
            try {

   try {

    Circle c = new Circle(3.0, "red", true);

    c.resize(-2.0);

} catch (InvalidShapeException e) {

    System.out.println(e.getMessage());
}
            System.out.println("This line should not be printed");
        } catch (InvalidShapeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println();
        
        // Demonstrate polymorphism with an array
        System.out.println("=== POLYMORPHISM DEMONSTRATION ===");
        Shape[] mixedShapes = {
            new Circle(7.0, "purple", false),
            new Rectangle(3.0, 8.0, "orange", true),
            new Triangle(5.0, 5.0, 6.0, "yellow", false),
            new Circle(2.5, "pink", true)
        };
        
        System.out.println("Mixed shapes array:");
        for (int i = 0; i < mixedShapes.length; i++) {
            System.out.printf("  Shape %d: %s%n", i + 1, mixedShapes[i].getClass().getSimpleName());
            System.out.printf("    Area: %.2f, Perimeter: %.2f%n", 
                            mixedShapes[i].getArea(), mixedShapes[i].getPerimeter());
        }
        
        System.out.println("\nAreas using printAreas method:");
        printAreas(mixedShapes);
        
        System.out.println("Largest shape in mixed array: " + largest(mixedShapes));
        
        System.out.println("\n========================================");
        System.out.println("DEMO COMPLETE");
        System.out.println("========================================");
    }
}