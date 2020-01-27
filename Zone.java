package scf.session8;

import java.util.ArrayList;
import java.util.List;

/**
 * Zone class represents a zone in a zoo. It has animal category supported by
 * it which defines types of animal cages which can be added to it. Each cage
 * supports animals of single type. There is upper limit on number of cages.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020.
 */
class Zone {
    /**
     * It represents the name of the zone.
     */
    private String zoneName;
    
    /**
     * It represents the category of animals which are supported by this zone.
     */
    private final String animalCategory;
    
    /**
     * It represents the maximum number of cages this zone can hold.
     */
    private final int cageCapacity;
    
    /**
     * It represents whether this zone has park or not. It is true if there is
     * a park in this zone.
     */
    private boolean hasPark;
    
    /**
     * It represents whether this zone has a canteen or not. It is true if there
     * is a canteen in this zone.
     */
    private boolean hasCanteen;
    
    /**
     * It stores the cages available in this zone.
     */
    private List<Cage> cages;
    
    /**
     * It is used to initialize a zone.
     * @param zoneName name of the zone.
     * @param animalCategory category of animals supported by this zone.
     * @param cageCapacity maximum number of cages this zone can hold.
     * @param hasPark true if this zone has park and false otherwise.
     * @param hasCanteen true if this zone has canteen and false otherwise.
     */
    Zone (String zoneName, String animalCategory, int cageCapacity,
            boolean hasPark, boolean hasCanteen) {
        this.zoneName = zoneName;
        this.animalCategory = animalCategory;
        this.cageCapacity = cageCapacity;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
        cages = new ArrayList<Cage>();
    }
    
    /**
     * It returns the name of the zone.
     * @return
     */
    String getZoneName() {
        return zoneName;
    }
    
    /**
     * It returns true if this zone has a park and false otherwise.
     * @return true if this zone has a park and false otherwise.
     */
    boolean hasPark() {
        return hasPark;
    }
    
    /**
     * It is used to add or remove park from this zone.
     * @param hasPark true to add park and false to remove park.
     */
    void setPark(boolean hasPark) {
        this.hasPark = hasPark;
    }
    
    /**
     * It returns true if this zone has a canteen and false otherwise.
     * @return true if this zone has a canteen and false otherwise.
     */
    boolean hasCanteen() {
        return hasCanteen;
    }
    
    /**
     * It is used to add or remove canteen from this zone.
     * @param hasCanteen true to add canteen and false to remove canteen.
     */
    void setCanteen(boolean hasCanteen) {
        this.hasCanteen = hasCanteen;
    }
    
    /**
     * It is used to add animal to this zone. Animal can be added only if
     * animal type belongs to animal category associated with this zone and
     * cage of input animal type is present and is not full.
     * @param id id of animal to be added to this zone.
     * @param animal animal to be added to this zone.
     * @return true if animal is added and false otherwise. Addition of an
     * animal depends on the conditions described in method definition.
     */
    boolean addAnimal(Long id, Animal animal) {
        String animalType = animal.getClass().getSimpleName();
        String animalCategory =
                animal.getClass().getSuperclass().getSimpleName();
        
        if (this.animalCategory.equals(animalCategory)) {
            Cage cage = getCage(animalType);
            if (cage != null) {
                return cage.addAnimal(id, animal);
            }
        }
        
        return false;
    }

    /**
     * It returns the cage which can add an animal of given animal type to it.
     * @param animalType animal type for which cage is needed.
     * @return a cage which can add an animal of given animal type
     */
    private Cage getCage(String animalType) {
        for (Cage cage: cages) {
            if (animalType.equals(cage.getAnimalType())
                    && cage.size() < cage.getAnimalCapacity()) {
                return cage;
            }
        }
        
        return null;
    }
    
    /**
     * It returns true if this zone contain the animal with given id.
     * @param id id of animal to be searched.
     * @return true if animal with given id is present in this zone and
     * false otherwise.
     */
    boolean containsAnimal(Long id) {
        for (Cage cage: cages) {
            if (cage.containsAnimal(id)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * It is used to remove an animal from this zone. It returns true if the
     * animal is removed successfully. Animal is removed only if it is present
     * in this zone.
     * @param id id of animal to be removed.
     * @return true if animal was present in this zone and is removed. It
     * returns false if animal was not present in this zone and thus can't be
     * removed.
     */
    boolean removeAnimal(Long id) {
        for (Cage cage: cages) {
            if (cage.removeAnimal(id)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * It is used to add a cage of given animal type to this zone. Cage of
     * given animal type can be added only if animal type is of animal
     * category supported by this zone and maximum number of cages has not
     * yet been reached.
     * @param animalType type of animal which the cage can hold.
     * @param animalCapacity maximum number of animals new cage can hold.
     * @return true if cage is added to this zone as per conditions defined
     * int he method definition.
     * @throws ClassNotFoundException if animal type is invalid.
     */
    boolean addCage(String animalType, int animalCapacity)
                                    throws ClassNotFoundException {
        
        String animalTypeClassPath = "scf.session8." + animalType;
        Class animalTypeClass = Class.forName(animalTypeClassPath);
        String animalCategory = 
                animalTypeClass.getSuperclass().getSimpleName();
        
        if (this.animalCategory.equals(animalCategory)
                && cages.size() < cageCapacity) {
            cages.add(new Cage(animalType, animalCapacity));
            return true;
        }
        
        return false;
    }
    
    /**
     * It returns the description of the state of the zone.
     */
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append("\n\n++++++++++++++++++++\n\n");
        description.append("ZONE\n");
        description.append("Zone name: " + zoneName + "\n");
        description.append("Animal Category: " + animalCategory + "\n");
        description.append("Cage capacity: " + cageCapacity + "\n");
        for (Cage cage: cages) {
            description.append(cage);
        }
        description.append("\n\n++++++++++++++++++++\n\n");
        
        return description.toString();
    }
}
