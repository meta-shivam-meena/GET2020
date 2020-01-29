package scf.session9;

import java.time.LocalTime;

/**
 * It represents a shape to be used by screen class.
 * @author Shivam Kumar Meena
 * created on 24th January, 2020.
 */
abstract public class Shape {
    /**
     * It represents the origin of the shape. Origin of a shape is defined
     * in subclasses of Shape.
     */
    Point origin;
    
    /**
     * Time at which this shape is added to a screen.
     */
    LocalTime time;

    /**
     * It calculates and return area of the shape.
     * @return area of the shape.
     */
    public abstract double getArea();
    
    /**
     * It calculates and return perimeter of the shape.
     * @return perimeter of the shape.
     */
    public abstract double getPerimeter();
    
    /**
     * It return the origin of this shape.
     * @return origin of this shape.
     */
    public abstract Point getOrigin();
    
    /**
     * It calculates whether provided point is enclosed in this shape or not.
     * @param point point for which enclosed test is to be applied.
     * @return true if provided point is enclosed in this shape and false
     * otherwise.
     */
    public abstract boolean isPointEnclosed(Point point);
}
