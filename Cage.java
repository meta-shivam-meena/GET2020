package scf.session8;

import java.util.HashMap;
import java.util.Map;

/**
 * It represents a cage in the zoo management system. A cage will be stored
 * in a zone. Each cage has a animal type associated with it and has a limit
 * on number of animals it can store.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
class Cage {
    /**
     * Type of animal supported by this cage.
     */
    private final String animalType;
    
    /**
     * Maximum number of animals this cage can hold.
     */
    private final int animalCapacity;
    
    /**
     * Animals present in this cage along with their id.
     */
    private Map<Long, Animal> animals;

    /**
     * It is used to initialize a cage.
     * @param animalType type of animal this cage will support.
     * @param animalCapacity maximum number of animals this cage can hold.
     */
    Cage(String animalType, int animalCapacity) {
        this.animalType = animalType;
        this.animalCapacity = animalCapacity;
        animals = new HashMap<Long, Animal>();
    }
    
    /**
     * It returns the type of animal supported by this cage.
     * @return type of animal this cage can store.
     */
    String getAnimalType() {
        return animalType;
    }
    
    /**
     * It returns the maximum number of animals this cage can hold.
     * @return maximum number of animals this cage can hold.
     */
    int getAnimalCapacity() {
        return animalCapacity;
    }
    
    /**
     * It is used to add an animal to this cage. An animal can be added only
     * if type of animal is supported by this cage and cage is not yet full.
     * @param id id of animal to be added to this cage.
     * @param animal animal to be added to this cage.
     * @return true if animal is added successfully to this cage as per
     * conditions defined in the method definition.
     */
    boolean addAnimal(Long id, Animal animal) {
        String animalType = animal.getClass().getSimpleName();
        
        if (this.animalType.equals(animalType)
                && animals.size() < animalCapacity) {
            animals.put(id, animal);
            return true;
        }
        
        return false;
    }
    
    /**
     * It tells whether animal with given id is present in this cage or not.
     * @param id id of the animal to be searched.
     * @return true if this animal is present in this cage and false otherwise.
     */
    boolean containsAnimal(Long id) {
        return animals.containsKey(id);
    }
    
    /**
     * It is used to remove an animal with given id from this cage. A animal
     * is removed successfully if it is present in this cage.
     * @param id id of the animal to be removed.
     * @return true if animal is present in this cage and is removed. It
     * returns false if animal was not present in this cage and thus can't be
     * removed.
     */
    boolean removeAnimal(Long id) {
        if (containsAnimal(id)) {
            animals.remove(id);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * It returns the number of animals present in this cage.
     * @return
     */
    public int size() {
        return animals.size();
    }
    
    /**
     * Description of the the state of the cage.
     */
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append("\n--------------------\n");
        description.append("CAGE\n");
        description.append("Animal Type: " + animalType + "\n");
        description.append("Animal Capacity: " + animalCapacity + "\n");
        description.append("Animals: ");
        for (Animal animal: animals.values()) {
            description.append(animal.name + ", ");
        }
        description.append("\n--------------------\n");
        
        return description.toString();
    }
    
}
