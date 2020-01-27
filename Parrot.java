package scf.session8;

/**
 * It represents a parrot(an animal type) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
public class Parrot extends Bird {
    
    /**
     * It is used to initialize a parrot.
     * @param name name of the parrot.
     * @param age age of the parrot in years.
     * @param weight weight of the parrot in kilograms.
     */
    public Parrot(String name, double age, double weight) {
        super(name, age, weight);
    }

    /**
     * It returns the string representation of the sound produced by a parrot.
     */
    public String getSound() {
        return "screech";
    }
}
