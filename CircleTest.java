package scf.session9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CircleTest {
    Shape circle;
    double verySmallDifference = 0.1;

    public CircleTest() {
        Point origin = new Point(3, 4);
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        circle = ShapeFactory.createShape(ShapeType.CIRCLE, origin, list);
    }
    
    @Test
    public void testGetArea() {
        double expectedOutput = 78.5;
        double actualOutput = circle.getArea();
        assertTrue(Math.abs(expectedOutput - actualOutput) < verySmallDifference);
    }

    @Test
    public void testGetPerimeter() {
        double expectedOutput = 31.4;
        double actualOutput = circle.getPerimeter();
        assertTrue(Math.abs(expectedOutput - actualOutput) < verySmallDifference);
    }

    @Test
    public void testIsPointEnclosed() {
        Point point = new Point(3.3, 4.4);
        boolean expectedOutput = true;
        boolean actualOutput = circle.isPointEnclosed(point);
        assertEquals(expectedOutput, actualOutput);
        point = new Point(21, 21);
        expectedOutput = false;
        actualOutput = circle.isPointEnclosed(point);
        assertEquals(expectedOutput, actualOutput);
    }

}
