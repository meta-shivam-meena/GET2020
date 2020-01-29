package scf.session9;

/**
 * It represents a point in a 2D plane.
 * @author Shivam Kumar Meena
 * created on 24th January, 2020.
 */
public class Point {
    /**
     * It represents x coordinate of this point in 2D plane.
     */
    double xCoordinate;
    
    /**
     * It represents y coordinate of this point in 2D plane.
     */
    double yCoordinate;
    
    /**
     * It initializes the point with given input coordinates.
     * @param xCoordinate x coordinate of the point in 2D plane.
     * @param yCoordinate y coordinate of the point in 2D plane.
     */
    public Point(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}
