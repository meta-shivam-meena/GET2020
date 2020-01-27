package scf.session8;

/**
 * It represents a peacock(an animal type) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
public class Peacock extends Bird {

    /**
     * It is used to initialize a peacock.
     * @param name name of the peacock.
     * @param age age of the peacock in years.
     * @param weight weight of the peacock in kilograms.
     */
    public Peacock(String name, double age, double weight) {
        super(name, age, weight);
    }

    /**
     * It returns the string representation of the sound produced by a peacock.
     */
    public String getSound() {
        return "scream";
    }
}
