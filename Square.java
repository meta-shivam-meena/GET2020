package scf.session9;

import java.util.List;

/**
 * It represents a square with position in a 2D plane. Position is represented
 * by origin. Square is oriented such that its sides are parallel to
 * coordinate axes. Origin is the bottom left point of the square.
 * @author Shivam Kumar Meena
 * create on 24th January, 2020.
 */
class Square extends Shape {
    /**
     * It represents the length of the side of the square.
     */
    int width;
    
    /**
     * It initializes the square with position as origin and parameters
     * contains single element representing the length of the side of the
     * square being created.
     * @param origin position of square on some 2D plane.
     * @param parameters It contains single element represeting the length of
     * the side of the square.
     */
    Square(Point origin, List<Integer> parameters)
                                    throws IllegalArgumentException {
        if (parameters.size() < 0) {
            throw new IllegalArgumentException();
        }
        
        this.origin = origin;
        this.width = parameters.get(0);
        
        if (width < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {
        
        return width * width;
    }

    @Override
    public double getPerimeter() {
        
        int numberOfSides = 4;
        return width * numberOfSides;
    }

    @Override
    public Point getOrigin() {
        
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        
        if (point.xCoordinate > origin.xCoordinate
                && point.xCoordinate < origin.xCoordinate + width
                && point.yCoordinate > origin.yCoordinate
                && point.yCoordinate < origin.yCoordinate + width) {
            
            return true;
        } else {
            return false;
        }
    }
    
}
