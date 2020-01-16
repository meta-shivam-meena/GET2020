package scf.assignment2;

/**
 * A utility class for calculating areas of various shapes.
 * @author Shivam Kumar Meena
 * created on 16th January, 2020
 */
public class Area {
    
    /**
     * It calculates and returns area of a triangle.
     * It assumes width and height are non-negative.
     * @param width width of the triangle.
     * @param height area of the triangle.
     * @return area of the triangle with specified width and height.
     */
    public static double getTriangleArea(double width, double height) 
            throws ArithmeticException {
        return 0.5 * width * height;
    }
    
    /**
     * It calculates and returns area of a rectangle.
     * It assumes width and height are non-negative.
     * @param width width of the rectangle.
     * @param height height of the rectangle.
     * @return area of the rectangle with specified width and height.
     */
    public static double getRectangleArea(double width, double height)
            throws ArithmeticException {
        return width * height;
    }
    
    /**
     * It calculates and returns area of a square.
     * It assumes width is non-negative.
     * @param width width of the square.
     * @return area of the square with specified width.
     */
    public static double getSquareArea(double width)
            throws ArithmeticException {
        return width * width;
    }
    
    /**
     * It calculates and returns area of a circle.
     * It assumes radius is non-negative.
     * @param radius radius of the circle.
     * @return area of the circle with specified radius.
     */
    public static double getCircleArea(double radius)
            throws ArithmeticException {
        return Math.PI * radius * radius;
    }
}
