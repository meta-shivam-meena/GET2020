package scf.session8;

/**
 * It represents a mammal(an animal category) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
abstract class Mammal extends Animal {

    /**
     * It is used to initialize a mammal.
     * @param name name of the mammal.
     * @param age age of the mammal in years.
     * @param weight weight of the mammal in kilograms.
     */
    Mammal(String name, double age, double weight) {
        super(name, age, weight);
    }

}
