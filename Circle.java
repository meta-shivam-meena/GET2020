package scf.session9;

import java.util.List;

/**
 * It represents a circle with some position in a 2D plane and 
 * supports various related operations. The position is represented by origin
 * of circle and the origin of a circle is a point on circle which intersect
 * with the line connecting origin of 2D plane and center of this circle.
 * @author Shivam Kumar Meena
 * created on 24th January, 2020.
 */
class Circle extends Shape {
    /**
     * radius of the circle
     */
    private int radius;
    
    private Point centerPoint;

    /**
     * It initializes the circle with given origin and parameters.
     * @param origin It represents the position of circle in a 2D plane. See
     * class definition for definition of origin of a circle.
     * @param parameters It contains single element which represents radius
     * of the circle.
     */
    Circle(Point origin, List<Integer> parameters)
                                    throws IllegalArgumentException {
        this.origin = origin;
        this.radius = parameters.get(0);
        this.centerPoint = null;
        
        if (radius < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {
        
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        
        return 2 * Math.PI * radius; // perimeter of circle = 2*PI*radius
    }

    @Override
    public Point getOrigin() {
        
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        
        if (centerPoint == null) {
            setCenterPoint();
        }
        
        double distanceOfPointFromCenter =
                Math.sqrt(Math.pow(centerPoint.xCoordinate - point.xCoordinate, 2)
                + Math.pow(centerPoint.yCoordinate - point.yCoordinate, 2));
        
        if (distanceOfPointFromCenter < radius) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * It is used to set coordinates of center point of the circle.
     */
    private void setCenterPoint() {
        // assuming origin as (x1, y1), center as (x, y) and radius as r
        double x1 = origin.xCoordinate;
        double y1 = origin.yCoordinate;
        double r = this.radius;
        double x1Squared = Math.pow(x1, 2);
        double y1Squared = Math.pow(y1, 2);
        // equation of line connecting origin of circle to origin of plane is
        // y = (y1/x1)*x or x1*y = y1*x ...eq(1)
        // equation of distance between origin and center being r is
        // (y - y1)^2 + (x - x1)^2 = r^2 ...eq(2)
        // putting value of y from eq(1) into eq(2)
        // equation to find x of center is
        // (x1^2 + y1^2)*x^2 - (2*x1*y1^2 + 2*x1^3)*x
        //  + (x1^2*y1^2 + x1^4 - r^2*x1^2) = 0 ...eq(3)
        // comparing terms of eq(3) with
        // coefficients of general quadratic equation a*x^2 + b*x + c = 0
        double a = x1Squared + y1Squared; 
        double b = -1 * ((2 * x1 * y1Squared) + (2 * Math.pow(x1, 3)));
        double c = (x1Squared * y1Squared) + Math.pow(x1, 4)
                                        - (Math.pow(r, 2) * x1Squared);
        // Discriminant(D) = b^2 - 4*a*c
        double D = Math.pow(b, 2) - 4 * a * c;
        // According to quadratic formula, and we need the solution with
        // greater x so we ignore x = (-b - D^0.5) / 2 * a
        // x = (-b + D^0.5) / 2 * a
        double x = (-1 * b + Math.pow(D, 0.5)) / (2 * a);
        double y = (y1 / x1) * x; // using eq(1)
        centerPoint = new Point(x, y);
    }
}
