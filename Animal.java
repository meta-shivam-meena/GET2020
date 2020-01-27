package scf.session8;

/**
 * It represents an animal which can be used in zoo management system. An
 * animal should have unique name in zoo management system.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
abstract public class Animal {
    /**
     * Name of the animal
     */
    String name;
    
    /**
     * Age of the animal in years.
     */
    double age;
    
    /**
     * Weight of the animal in kilograms.
     */
    double weight;
    
    /**
     * It is used to initialize an animal.
     * @param name name of the animal
     * @param age age of the animal
     * @param weight weight of the animal
     */
    public Animal(String name, double age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    
    /**
     * It returns the string representation of the sound of this animal.
     * @return
     */
    abstract public String getSound();
}
