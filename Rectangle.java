package scf.session9;

import java.util.List;

/**
 * It represents a rectangle with some position in a 2D plane. Position is 
 * represented by origin. Origin of a rectangle with sides parallel to
 * coordinate axes, is the bottom left corner point.
 * @author Shivam Kumar Meena
 * created on 24th January, 2020.
 */
class Rectangle extends Shape {
    /**
     * It represents width of the rectangle, i.e., length of the side parallel
     * to x axis.
     */
    int width;
    
    /**
     * It represents height of the rectangle, i.e., length of the side parallel
     * to y axis.
     */
    int height;

    /**
     * It initializes the rectangle. Origin represents the origin of the
     * rectangle as defined in the class definition and parameters will contain
     * two elements, first element is width and second element is height of
     * the rectangle.
     * @param origin position of rectangle in some 2D plane.
     * @param parameters a list with two elements, first is width and second
     * is height of the rectangle.
     */
    Rectangle(Point origin, List<Integer> parameters)
                                    throws IllegalArgumentException {
        if (parameters.size() < 2) {
            throw new IllegalArgumentException();
        }
        
        this.origin = origin;
        this.width = parameters.get(0);
        this.height = parameters.get(1);
        
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {
        
        return width * height;
    }

    @Override
    public double getPerimeter() {
        
        return 2 * (width + height);
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
                && point.yCoordinate < origin.yCoordinate + height) {
            
            return true;
        }
        
        return false;
    }

}
