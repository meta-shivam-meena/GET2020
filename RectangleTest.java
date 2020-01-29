package scf.session9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RectangleTest {
    Shape rectangle;
    double verySmallDifference = 0.1;

    public RectangleTest() {
        Point origin = new Point(4, 4);
        List<Integer> list = new ArrayList<Integer>();
        list.add(6);
        list.add(3);
        rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, origin, list);
    }
    
    @Test
    public void testGetArea() {
        double expectedOutput = 18;
        double actualOutput = rectangle.getArea();
        assertTrue(Math.abs(expectedOutput - actualOutput) < verySmallDifference);
    }

    @Test
    public void testGetPerimeter() {
        double expectedOutput = 18;
        double actualOutput = rectangle.getPerimeter();
        assertTrue(Math.abs(expectedOutput - actualOutput) < verySmallDifference);;
    }

    @Test
    public void testIsPointEnclosed() {
        Point point = new Point(5, 6);
        boolean expectedOutput = true;
        boolean actualOutput = rectangle.isPointEnclosed(point);
        assertEquals(expectedOutput, actualOutput);
        point = new Point(2, 6);
        expectedOutput = false;
        actualOutput = rectangle.isPointEnclosed(point);
        assertEquals(expectedOutput, actualOutput);
    }

}
