package scf.session8;

/**
 * It represents a python(an animal type) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
public class Python extends Reptile {

    /**
     * It is used to initialize a python.
     * @param name name of the python.
     * @param age age of the python in years.
     * @param weight weight of the python in kilograms.
     */
    public Python(String name, double age, double weight) {
        super(name, age, weight);
    }

    /**
     * It returns the string representation of sound produced by a python.
     */
    public String getSound() {
        return "hiss";
    }
}
