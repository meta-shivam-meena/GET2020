package scf.session8;

/**
 * It represents a bird(an animal category) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
abstract public class Bird extends Animal {

    /**
     * It is used to initialize a bird.
     * @param name name of the bird.
     * @param age age of the bird in years.
     * @param weight weight of the bird in kilograms.
     */
    public Bird(String name, double age, double weight) {
        super(name, age, weight);
    }
}
