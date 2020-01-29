package scf.session9;

import java.util.List;

/**
 * It represents a regular polygon with one of the sides parallel to x axis.
 * 
 * @author Shivam Kumar Meena
 * created on 24th January, 2020.
 */
class RegularPolygon extends Shape {
    /**
     * It represents the total number of sides in this regular polygon.
     */
    private int totalSides;
    
    /**
     * It represents the length of the side of regular polygon.
     */
    private int sideLength;
    
    /**
     * It represents the corners of the polygon.
     */
    private Point[] points;
    
    /**
     * It represents the center point of the polygon.
     */
    private Point center;
    
    /**
     * It represents the inradius of the polygon or the length of perpendicular
     * from center to one of the sides.
     */
    private double apothem;
    
    /**
     * It represents the circumradius of the polygon.
     */
    private double radius;

    /**
     * It is used to initialize the regular polygon. Origin is the leftmost
     * point on the side which is parallel to the x axis. Parameters has
     * 2 parameters, first one is number of sides in regular polygon and second
     * parameter is the length of the side of the regular polygon.
     * @param origin origin of the regular polygon as defined in method
     * definition.
     * @param parameters 2 integers, first one represents the number of sides
     * in polygon and second one represents the length of the side of the
     * polygon.
     */
    RegularPolygon(Point origin, List<Integer> parameters)
                                    throws IllegalArgumentException {
        if (parameters.size() < 2) {
            throw new IllegalArgumentException();
        }
        
        this.origin = origin;
        this.totalSides = parameters.get(0);
        this.sideLength = parameters.get(1);
        
        if (totalSides < 0 || sideLength < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {
        if (points == null) {
            setApothemRadiusCenterAndPoint();
        }
        
        return totalSides * (0.5 * sideLength * apothem);
    }
    
    @Override
    public double getPerimeter() {
        return totalSides * sideLength;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }
    
    @Override
    public boolean isPointEnclosed(Point point) {
        double area = 0;
        double verySmallDifference = 0.1;
        
        if (points == null) {
            setApothemRadiusCenterAndPoint();
        }
        
        for (int i = 0; i < points.length - 1; i++) {
            area += calculateAreaOfTriangle(point, points[i], points[i + 1]); 
        }
        
        area += calculateAreaOfTriangle(point, points[points.length - 1],
                                        points[0]);
        
        if (Math.abs(area - this.getArea()) < verySmallDifference) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * It is used to set apothem, radius, center and points fields.
     */
    private void setApothemRadiusCenterAndPoint() {
        double internalAngle = (2 * Math.PI) / totalSides;
        apothem = ((double) sideLength) / (2 * Math.tan(internalAngle / 2));
        radius = ((double) sideLength) / (2 * Math.sin(internalAngle / 2));
        center = new Point(origin.xCoordinate + sideLength / 2.0,
                           origin.yCoordinate + apothem);
        points = new Point[totalSides];
        double angle = Math.PI + internalAngle / 2.0;
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(center.xCoordinate
                                  + radius * Math.sin(angle),
                                  center.yCoordinate
                                  + radius * Math.cos(angle));
            angle += internalAngle;
        }
    }
    
    /**
     * It is used to calculate area of a triangle whose corner points are 
     * provided.
     * @param A first vertex.
     * @param B second vertex.
     * @param C third vertex.
     * @return area of the triangle represented by these points.
     */
    private double calculateAreaOfTriangle(Point A, Point B, Point C) {
        double AB = calculateDistance(A, B);
        double BC = calculateDistance(B, C);
        double AC = calculateDistance(A, C);
        return calculateAreaOfTriangle(AB, BC, AC);
    }
    
    /**
     * It calculates and returns the distance between input points.
     * @param A first point.
     * @param B second point.
     * @return distance between these points.
     */
    private double calculateDistance(Point A, Point B) {
        return Math.sqrt(Math.pow(A.xCoordinate - B.xCoordinate, 2)
                         + Math.pow(A.yCoordinate - B.yCoordinate, 2));
    }
    
    /**
     * It calculates and return area of a triangle whose three sides are
     * provided.
     * @param side1 side1 length.
     * @param side2 side2 length.
     * @param side3 side3 length.
     * @return
     */
    private double calculateAreaOfTriangle(double side1, double side2,double side3) {
        double semiperimeter = (side1 + side2 + side3) / 2;
        // heron's formula
        // area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        double area = Math.sqrt(semiperimeter * (semiperimeter - side1)
                * (semiperimeter - side2) * (semiperimeter - side3));
        return area;
    }

}
