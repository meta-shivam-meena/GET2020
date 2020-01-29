package scf.session9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RegularPolygonTest {
    Shape regularPolygon;
    double verySmallDifference = 0.1;

    public RegularPolygonTest() {
        Point origin = new Point(6, 6);
        List<Integer> list = new ArrayList<Integer>();
        list.add(6);
        list.add(1);
        regularPolygon = ShapeFactory.createShape(ShapeType.REGULAR_POLYGON,
                                        origin, list);
    }

    @Test
    public void testGetArea() {
        double expectedOutput = 2.598;
        double actualOutput = regularPolygon.getArea();
        assertTrue(Math.abs(expectedOutput - actualOutput) < verySmallDifference);
    }

    @Test
    public void testGetPerimeter() {
        double expectedOutput = 6;
        double actualOutput = regularPolygon.getPerimeter();
        assertTrue(Math.abs(expectedOutput - actualOutput) < verySmallDifference);
    }

    @Test
    public void testIsPointEnclosed() {
        Point point = new Point(6.5, 6.5);
        boolean expectedOutput = true;
        boolean actualOutput = regularPolygon.isPointEnclosed(point);
        assertEquals(expectedOutput, actualOutput);
        point = new Point(6.5, 5.8);
        expectedOutput = false;
        actualOutput = regularPolygon.isPointEnclosed(point);
        assertEquals(expectedOutput, actualOutput);
    }
}
