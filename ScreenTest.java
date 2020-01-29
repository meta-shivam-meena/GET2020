package scf.session9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ScreenTest {
    Screen screen;
    Shape circle;
    Shape square;
    Shape rectangle;
    Shape triangle;
    Shape regularPolygon;
    
    public ScreenTest() {
        Point origin = new Point(3, 4);
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        circle = ShapeFactory.createShape(ShapeType.CIRCLE, origin, list);
        origin = new Point(4, 4);
        list = new ArrayList<Integer>();
        list.add(6);
        square = ShapeFactory.createShape(ShapeType.SQUARE, origin, list);
        origin = new Point(5, 5);
        list = new ArrayList<Integer>();
        list.add(6);
        list.add(3);
        rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, origin, list);
        origin = new Point(6, 6);
        list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        list.add(5);
        triangle = ShapeFactory.createShape(ShapeType.TRIANGLE, origin, list);
        origin = new Point(7, 7);
        list = new ArrayList<Integer>();
        list.add(6);
        list.add(1);
        regularPolygon = ShapeFactory.createShape(ShapeType.REGULAR_POLYGON,
                                        origin, list);
        
        screen = new Screen(1000, 1000);
        screen.addShape(triangle);
        screen.addShape(regularPolygon);
        screen.addShape(circle);
        screen.addShape(square);
        screen.addShape(rectangle);
    }

    @Test
    public void testGetShapesSortedByArea() {
        List<Shape> expectedOutput = new ArrayList<Shape>();
        expectedOutput.add(regularPolygon);
        expectedOutput.add(triangle);
        expectedOutput.add(rectangle);
        expectedOutput.add(square);
        expectedOutput.add(circle);
        List<Shape> actualOutput = screen.getShapesSortedByArea();
        
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetShapesSortedByPerimeter() {
        List<Shape> expectedOutput = new ArrayList<Shape>();
        expectedOutput.add(regularPolygon);
        expectedOutput.add(triangle);
        expectedOutput.add(rectangle);
        expectedOutput.add(square);
        expectedOutput.add(circle);
        List<Shape> actualOutput = screen.getShapesSortedByPerimeter();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetShapesSortedByLocalTime() {
        List<Shape> expectedOutput = new ArrayList<Shape>();
        expectedOutput.add(triangle);
        expectedOutput.add(regularPolygon);
        expectedOutput.add(circle);
        expectedOutput.add(square);
        expectedOutput.add(rectangle);
        List<Shape> actualOutput = screen.getShapesSortedByLocalTime();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetShapesSortedByOriginDistance() {
        List<Shape> expectedOutput = new ArrayList<Shape>();
        expectedOutput.add(circle);
        expectedOutput.add(square);
        expectedOutput.add(rectangle);
        expectedOutput.add(triangle);
        expectedOutput.add(regularPolygon);
        List<Shape> actualOutput = screen.getShapesSortedByOriginDistance();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGetEnclosingShapes() {
        Point point = new Point(5, 5);
        List<Shape> expectedOutput = new ArrayList<Shape>();
        expectedOutput.add(circle);
        expectedOutput.add(square);
        List<Shape> actualOutput = screen.getEnclosingShapes(point);
        assertEquals(expectedOutput, actualOutput);
    }

}
