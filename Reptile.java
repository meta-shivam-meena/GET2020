package scf.session8;

/**
 * It represents a reptile(an animal category) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
abstract public class Reptile extends Animal {

    /**
     * It is used to initialize a reptile.
     * @param name name of the reptile.
     * @param age age of the reptile in years.
     * @param weight weight of the reptile in kilograms.
     */
    public Reptile(String name, double age, double weight) {
        super(name, age, weight);
    }

}
