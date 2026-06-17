
package vu.shapesystem;


public class InvalidShapeException extends RuntimeException {
    
    public InvalidShapeException(String message) {
        super(message);
    }
    
    public InvalidShapeException(String message, Throwable cause) {
        super(message, cause);
    }
}
    

