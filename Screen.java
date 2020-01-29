package scf.session9;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * It represents a screen which can store shapes of various types. Varios
 * operations can be performed on these shapes.
 * @author Shivam Kumar Meena
 * created on 24th January, 2020.
 */
public class Screen {
    /**
     * It represents max x coordinate of screen.
     */
    double xMax;
    
    /**
     * It represents max y coordinate of screen.
     */
    double yMax;
    
    /**
     * It stores the shapes added to the screen.
     */
    List<Shape> shapes;
    
    /**
     * It is used to initialize a screen.
     * @param xMax max x coordinate of screen.
     * @param yMax max y coordinate of screen.
     */
    public Screen(double xMax, double yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
        shapes = new ArrayList<Shape>();
    }
    
    /**
     * It is used to add a shape to his screen. Shape if added only if it is
     * not already presnet on this screen.
     * @param shape shape to be added to this screen.
     * @return true if shape is added and false otherwise.
     */
    public boolean addShape(Shape shape) {
        if (!shapes.contains(shape)) {
            shape.time = LocalTime.now();
            shapes.add(shape);
            return true;
        }
        
        return false;
    }
    
    /**
     * It is used to remove a shape from the screen.
     * @param shape shape to be removed from this screen.
     * @return true is shape is present on this screen and is deleted. It 
     * return false if shape is not present on this screen and thus can't be
     * removed.
     */
    public boolean deleteShape(Shape shape) {
        if (shapes.contains(shape)) {
            shape.time = null;
            shapes.remove(shape);
            return true;
        }
        
        return false;
    }
    
    /**
     * It is used to remove multiple shapes from the screen by shape type.
     * @param shapeType shape type to be removed from the screen.
     */
    public void deleteShape(ShapeType shapeType) {
        Iterator<Shape> iterator = shapes.iterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            if (shape.getClass().getSimpleName().equals(shapeType.name())) {
                shape.time = null;
                iterator.remove();
            }
        }
    }
    
    /**
     * It returns the shapes on screen sorted by area in ascending order.
     * @return the shapes on screen sorted by area in ascending order.
     */
    public List<Shape> getShapesSortedByArea() {
        List<Shape> list = new ArrayList<Shape>();
        list.addAll(this.shapes);
        Collections.sort(list, new CompareShapesByArea());
        return list;
    }
    
    /**
     * It returns the shapes on screen sorted by perimeter in ascending order.
     * @return the shapes on screen sorted by perimeter in ascending order.
     */
    public List<Shape> getShapesSortedByPerimeter() {
        List<Shape> list = new ArrayList<Shape>();
        list.addAll(this.shapes);
        Collections.sort(list, new CompareShapesByPerimeter());
        return list;
    }  
    
    /**
     * It returns the shapes sorted by local time in ascending order.
     * @return the shapes sorted by local time in ascending order.
     */
    public List<Shape> getShapesSortedByLocalTime() {
        List<Shape> list = new ArrayList<Shape>();
        list.addAll(this.shapes);
        Collections.sort(list, new CompareShapesByLocalTime());
        return list;
    }
        
    /**
     * It returns the shapes sorted by origin distance in ascending order.
     * @return the shapes sorted by origin distance in ascending order.
     */
    public List<Shape> getShapesSortedByOriginDistance() {
        List<Shape> list = new ArrayList<Shape>();
        list.addAll(this.shapes);
        Collections.sort(list, new CompareShapesByOriginDistance());
        return list;
    } 
    
    /**
     * It returns the list of shapes which ecloses the input point.
     * @param point point for which enclosed test is to be found.
     * @return list of shapes which encloses the input point.
     */
    public List<Shape> getEnclosingShapes(Point point) {
        List<Shape> enclosingShapes = new ArrayList<Shape>();
        for (Shape shape: shapes) {
            if (shape.isPointEnclosed(point)) {
                enclosingShapes.add(shape);
            }
        }
        return enclosingShapes;
    }

    /**
     * Comparator for comparing two shapes by area
     * @author Shivam Kumar Meena
     * created on 24th January, 2020
     */
    private class CompareShapesByArea implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            return Double.compare(shape1.getArea(), shape2.getArea());
        }
    }
    
    /**
     * Comparator for comparing two shapes by perimeter
     * @author Shivam Kumar Meena
     * created on 24th January, 2020.
     */
    private class CompareShapesByPerimeter implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
        }
    }
    
    /**
     * Comparator for comparing two shapes by localtime
     * @author Shivam Kumar Meena
     * created on 24th January, 2020.
     */
    private class CompareShapesByLocalTime implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            return shape1.time.compareTo(shape2.time);
        }
    }
    
    /**
     * Comparator for comparing two shapes by origin distance.
     * @author Shivam Kumar Meena
     * created on 24th January, 2020.
     */
    private class CompareShapesByOriginDistance implements Comparator<Shape> {
        public int compare(Shape shape1, Shape shape2) {
            double distance1Squared = Math.pow(shape1.origin.xCoordinate, 2)
                                      + Math.pow(shape1.origin.yCoordinate, 2);
            double distance1 = Math.sqrt(distance1Squared);
            double distance2Squared = Math.pow(shape2.origin.xCoordinate, 2)
                                      + Math.pow(shape2.origin.yCoordinate, 2);
            double distance2 = Math.sqrt(distance2Squared);
            
            return Double.compare(distance1, distance2);
        }
    }
}
