package scf.session8;

/**
 * It represents a turtle(an animal type) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
public class Turtle extends Reptile {

    /**
     * It is used to initialize a turtle.
     * @param name name of the turtle.
     * @param age age of the turtle in years.
     * @param weight weight of the turtle in kilograms.
     */
    public Turtle(String name, double age, double weight) {
        super(name, age, weight);
    }

    /**
     * It returns the string representation of sound produced by a turtle.
     */
    public String getSound() {
        return "hiss";
    }
}
