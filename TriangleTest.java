package scf.session9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TriangleTest {
    Shape triangle;
    double verySmallDifference = 0.1;

    public TriangleTest() {
        Point origin = new Point(6, 6);
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        list.add(5);
        triangle = ShapeFactory.createShape(ShapeType.TRIANGLE, origin, list);
    }

    @Test
    public void testGetArea() {
        double expectedOutput = 6;
        double actualOutput = triangle.getArea();
        assertTrue(Math.abs(expectedOutput - actualOutput) < verySmallDifference);
    }

    @Test
    public void testGetPerimeter() {
        double expectedOutput = 12;
        double actualOutput = triangle.getPerimeter();
        assertTrue(Math.abs(expectedOutput - actualOutput) < verySmallDifference);
    }

    @Test
    public void testIsPointEnclosed() {
        Point point = new Point(6.1, 6.1);
        boolean expectedOutput = true;
        boolean actualOutput = triangle.isPointEnclosed(point);
        assertEquals(expectedOutput, actualOutput);
        point = new Point(6.1, 5.9);
        expectedOutput = false;
        actualOutput = triangle.isPointEnclosed(point);
        assertEquals(expectedOutput, actualOutput);
    }

}
