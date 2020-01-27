package scf.session8;

/**
 * It represents a crocodile(an animal type) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
public class Crocodile extends Reptile {
    
    /**
     * It is used to initialize a crocodile.
     * @param name name of the crocodile.
     * @param age age of the crocodile in years.
     * @param weight weight of the crocodile in kilograms.
     */
    public Crocodile(String name, double age, double weight) {
        super(name, age, weight);
    }

    /**
     * It returns the string representation of the sound produced by a crocodile.
     */
    public String getSound() {
        return "growl";
    }
}
