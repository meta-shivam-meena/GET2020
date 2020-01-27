package scf.session8;

/**
 * It represents an elephant(an animal type) in zoo management system. 
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
public class Elephant extends Mammal {
    
    /**
     * It is used to initialize an elephant.
     * @param name name of the elephant.
     * @param age age of the elephant in years.
     * @param weight weight of the elephant in kilograms.
     */
    public Elephant(String name, double age, double weight) {
        super(name, age, weight);
    }

    /**
     * It return the string representation of the sound produced by an elephant.
     */
    public String getSound() {
        return "trumpet";
    }
}
