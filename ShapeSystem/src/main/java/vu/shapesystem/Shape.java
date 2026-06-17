
package vu.shapesystem;

    
public abstract class Shape {
    protected String color;
    protected boolean filled;
    
    public Shape() {
        this.color = "white";
        this.filled = false;
    }
    
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void resize(double factor);
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isFilled() {
        return filled;
    }
    
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    @Override
    public String toString() {
        return String.format("Shape{color='%s', filled=%s, area=%.2f, perimeter=%.2f}", 
                           color, filled, getArea(), getPerimeter());
    }
}
    

