package scf.session8;

/**
 * It represents a lion(an animal type) in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
public class Lion extends  Mammal {
    
    /**
     * It is used to initialize a lion.
     * @param name name of the lion.
     * @param age age of the lion in years.
     * @param weight weight of the lion in kilograms.
     */
    public Lion(String name, double age, double weight) {
        super(name, age, weight);
    }

    /**
     * It returns the string representation of the sound produced by a lion.
     */
    public String getSound() {
        return "roars";
    }
}
