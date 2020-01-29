package scf.session9;

import java.util.List;

/**
 * It represents a triangle with some position in a 2D plane. Position is
 * represented by field named origin. Triangle is always oriented in a way
 * such that one of its sides is parallel to x axis. Origin is the leftmost
 * point on the side which is parallel to x axis. Triangle is also seen as
 * ABC where A, B and C are corner Points of triangle with AB side being 
 * parallel to x axis.
 * @author Shivam Kumar Meena
 * created on 24th January, 2020.
 */
class Triangle extends Shape {
    /**
     * It represents the length of the side which is parallel to the x axis. 
     */
    private int baseSide; // side AB
    
    /**
     * It represents the length of the side originating from left end of the
     * base side.
     */
    private int sideOriginatingFromLeftOfBaseSide; // side AC
    
    /**
     * It represents the length of the side originating from the right end of
     * the base side.
     */
    private int sideOriginatingFromRightOfBaseSide; // side BC
    
    /**
     * It stores the area of the triangle, so it is not calculated again and
     * again.
     */
    private double area;
    
    /**
     * origin vertex
     */
    private Point A;
    
    /**
     * right bottom vertex
     */
    private Point B;
    
    /**
     * top most vertex.
     */
    private Point C;

    /**
     * It is used to initialize a triangle. A triagle expects a list of
     * parameters with 3 side lengths. First length will be for the side 
     * which will be parallel to the x axis, second length is the side which
     * will originate from left side of fist side and third length is the side
     * which will originate from right side of first side.
     * @param origin origin of the triangle. It is the bottom left point on
     * the triangle.
     * @param parameters 3 side lengths as defined in class definition.
     */
    Triangle(Point origin, List<Integer> parameters) {
        if (parameters.size() < 3) {
            throw new IllegalArgumentException();
        }
        
        this.origin = origin;
        this.baseSide = parameters.get(0);
        this.sideOriginatingFromLeftOfBaseSide = parameters.get(1);
        this.sideOriginatingFromRightOfBaseSide = parameters.get(2);
        area = -1;
        
        if (!isValidTriangle(baseSide, sideOriginatingFromLeftOfBaseSide,
                                        sideOriginatingFromRightOfBaseSide)) {
            throw new IllegalArgumentException(); 
        }
    }

    @Override
    public double getArea() {

        if (area == -1) {
            setArea();
        }
        return area;
    }
    
    /**
     * This methods is used to set area field of triangle.
     */
    private void setArea() {
        this.area = calculateArea(baseSide, sideOriginatingFromLeftOfBaseSide,
                                        sideOriginatingFromRightOfBaseSide); 
    }
    
    /**
     * It calculates and return area of a triangle whose three side lengths
     * are known.
     * @param side1 first side length.
     * @param side2 second side length.
     * @param side3 this side length.
     * @return area of the triangle formed by these lengths.
     */
    private double calculateArea(double side1, double side2, double side3) {
        double semiperimeter = (side1 + side2 + side3) / 2;
        // heron's formula
        // area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        double area = Math.sqrt(semiperimeter * (semiperimeter - side1)
                * (semiperimeter - side2) * (semiperimeter - side3));
        return area;
    }

    @Override
    public double getPerimeter() {
        return baseSide + sideOriginatingFromLeftOfBaseSide
                                        + sideOriginatingFromRightOfBaseSide;
    }

    @Override
    public Point getOrigin() {
        
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        if (A == null || B == null || C == null) {
            setCornerPoints();
        }
        
        double verySmallDifference = 0.1;
        // suppose triangle is ABC and point is P
        Point P = point;
        double AB = baseSide;
        double AC = sideOriginatingFromLeftOfBaseSide;
        double BC = sideOriginatingFromRightOfBaseSide;
        
        double PA = calculateDistance(P, A);
        double PB = calculateDistance(P, B);
        double PC = calculateDistance(P, C);
        
        double areaPAB = calculateArea(PA, PB, AB);
        double areaPBC = calculateArea(PB, PC, BC);
        double areaPAC = calculateArea(PA, PC, AC);
        double areaABC = getArea();
        
        if (Math.abs(areaPAB + areaPBC + areaPAC - areaABC) 
                                        < verySmallDifference) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * It is used to set the corner points of this triangle.
     */
    private void setCornerPoints() {
        A = new Point(origin.xCoordinate, origin.yCoordinate);
        B = new Point(A.xCoordinate + baseSide, A.yCoordinate);
        double area = getArea();
        double height = (2 * area) / baseSide;
        double xOfBaseOfPerpendicularFromC =
                Math.sqrt(Math.pow(sideOriginatingFromLeftOfBaseSide, 2)
                          - Math.pow(height, 2)) + A.xCoordinate;
        C = new Point(xOfBaseOfPerpendicularFromC, A.yCoordinate + height);
    }
    
    /**
     * It calculates and return distance between two input points.
     * @param A first point.
     * @param B second point.
     * @return distance between input points.
     */
    private double calculateDistance(Point A, Point B) {
        return Math.sqrt(Math.pow(A.xCoordinate - B.xCoordinate, 2)
                         + Math.pow(A.yCoordinate - B.yCoordinate, 2));
    }
    
    /**
     * It returns true if these sides form a triangle and false otherwise.
     * @param side1 side1
     * @param side2 side2
     * @param side3 side3
     * @return true if these sides form a triangle and false otherwise.
     */
    private boolean isValidTriangle(int side1, int side2, int side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            return false;
        }
        if (side1 > side2 + side3 || side2 > side1 + side3
                                        || side3 > side1 + side2) {
            return false;
        }
        
        return true;
    }
}