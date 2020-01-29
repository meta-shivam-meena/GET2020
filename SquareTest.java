package scf.session9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SquareTest {
    Shape square;
    double verySmallDifference = 0.1;

    public SquareTest() {
        Point origin = new Point(4, 4);
        List<Integer> list = new ArrayList<Integer>();
        list.add(6);
        square = ShapeFactory.createShape(ShapeType.SQUARE, origin, list);
    }
    
    @Test
    public void testGetArea() {
        double expectedOutput = 36;
        double actualOutput = square.getArea();
        assertTrue(Math.abs(expectedOutput - actualOutput) < verySmallDifference);
    }

    @Test
    public void testGetPerimeter() {
        double expectedOutput = 24;
        double actualOutput = square.getPerimeter();
        assertTrue(Math.abs(expectedOutput - actualOutput) < verySmallDifference);
    }

    @Test
    public void testIsPointEnclosed() {
        Point point = new Point(5, 6);
        boolean expectedOutput = true;
        boolean actualOutput = square.isPointEnclosed(point);
        assertEquals(expectedOutput, actualOutput);
        point = new Point(2, 6);
        expectedOutput = false;
        actualOutput = square.isPointEnclosed(point);
        assertEquals(expectedOutput, actualOutput);
    }

}
