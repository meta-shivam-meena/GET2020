package scf.session8;

/**
 * It represents an owl(an animal type) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
public class Owl extends Bird {
    
    /**
     * It is used to initialize an owl.
     * @param name name of the owl.
     * @param age age of the owl in years.
     * @param weight weight of the owl in kilograms.
     */
    public Owl(String name, double age, double weight) {
        super(name, age, weight);
    }

    /**
     * it returns the string representation of the sound produced by an owl.
     */
    public String getSound() {
        return "hoot";
    }
}
