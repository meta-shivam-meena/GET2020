package scf.session9;

import java.util.List;

/**
 * It is a factory class used to generate objects of Shape subtypes.
 * @author Shivam Kumar Meena
 * created on 24th January, 2020.
 */
public class ShapeFactory {

    /**
     * It creates an object of shapeType passed as argument.
     * @param shapeType type of shape to be created.
     * @param origin origin of the shape to be created. Definition of origin
     * depends on shape type and is defined in shape definitions.
     * @param shapeParameters parameter to be used by shapes. Appropriate list
     * of parameters is defined in specific shape definitions.
     * @return object of shape type
     * @throws IllegalArgumentException if provided shape type doesn't exist.
     */
    public static Shape createShape(ShapeType shapeType, Point origin,
            List<Integer> shapeParameters) throws IllegalArgumentException {
        
        Shape shape;
        
        switch (shapeType) {
        case SQUARE:
            shape = new Square(origin, shapeParameters);
            break;
        case RECTANGLE:
            shape = new Rectangle(origin, shapeParameters);
            break;
        case CIRCLE:
            shape = new Circle(origin, shapeParameters);
            break;
        case TRIANGLE:
            shape = new Triangle(origin, shapeParameters);
            break;
        case REGULAR_POLYGON:
            shape = new RegularPolygon(origin, shapeParameters);
            break;
        default:
            throw new IllegalArgumentException("Invalid Shape Type");
        }
        
        return shape;
    }
}
