package scf.session8;

/**
 * It represents a zebra(an animal type) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
public class Zebra extends Mammal {

    /**
     * It is used to initialize a zebra.
     * @param name name of the zebra.
     * @param age age of the zebra in years.
     * @param weight weight of the zebra in kilograms.
     */
    public Zebra(String name, double age, double weight) {
        super(name, age, weight);
    }

    /**
     * It returns the string representation of the sound produced by a zebra.
     */
    public String getSound() {
        return "whinny";
    }
}
