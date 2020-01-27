package scf.session8;

import java.util.HashMap;
import java.util.Map;

/**
 * Zoo class represents a zoo which is divided into multiple zones with
 * each zone having multiple cages. A cage can store a limited number of
 * animal of same type. A zone can have cages of animals with same category
 * like zone with Mammal category will have cages for Lion, Zebra and Elephant.
 * @author Shivam Kumar Meena
 * created on 23rd January, 2020
 */
public class Zoo {
    /**
     * Name of zoo
     */
    private String zooName;
    
    /**
     * Id to be assigned to next animal which will be added to zoo.
     */
    private long nextAnimalId;
    
    /**
     * Maximum number of zones this zoo can have.
     */
    private int zoneCapacity;
    
    /**
     * Names of animals and their associated id.
     */
    Map<String, Long> animalIds;
    
    /**
     * It stores objects of Zone.
     */
    Map<String, Zone> zones;
    
    /**
     * Constructor to initialize a zoo.
     * @param zooName Name of the zoo.
     * @param zoneCapacity Maximum number of zones this zoo can have.
     */
    public Zoo(String zooName, int zoneCapacity) {
        this.zooName = zooName;
        this.zoneCapacity = zoneCapacity;
        nextAnimalId = 1;
        animalIds = new HashMap<String, Long>();
        zones = new HashMap<String, Zone>();
    }
    
    /**
     * It returns the name of the zoo.
     * @return name of the zoo.
     */
    public String getZooName() {
        return zooName;
    }
    
    /**
     * It is used to add a animal to zoo. An animal is added in appropriate
     * cage according to its animal type in some zone which supports the
     * cagegory of animals to which input animal belongs. If animal can be
     * added to zoo, then it will be added and methods will return true. In
     * case, a animal can't be added due lack of zone of same category as
     * this animal or lack of cage of animal type associated with input
     * animal or cages being full, then method will return false. For addition
     * of this animal, a new cage or zone will need to created to accomodate
     * this animal.
     * @param animal animal to be added to zoo.
     * @return true if animal is added to zoo, and false otherwise.
     */
    public boolean addAnimal(Animal animal) {
        if (!animalIds.containsKey(animal.name)) {
            long id = nextAnimalId;
            for (Zone zone: zones.values()) {
                if (zone.addAnimal(id, animal)) {
                    animalIds.put(animal.name, nextAnimalId);
                    nextAnimalId++;
                }
            }
        }
        
        return false;
    }
    
    /**
     * It is used to remove an animal from the zoo.
     * @param animal animal to be removed from the zoo.
     * @return true if animal was present in zoo and gets removed. false
     * if animal was not present in the zoo.
     */
    public boolean removeAnimal(Animal animal) {
        long id;
        if (animalIds.containsKey(animal.name)) {
            id = animalIds.get(animal.name);
            for (Zone zone: zones.values()) {
                if (zone.removeAnimal(id)) {
                    animalIds.remove(animal.name);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * It is used add a zone in zoo. Adding of zone may fail if animal
     * category is invalid or a zone with same name already exits or maximum
     * number of zones are already present in the zoo.
     * @param zoneName Zone name to be assigned to the created zone.
     * @param animalCategory Category of animal which will be present
     * in this zone.
     * @param cageCapacity maximum number of cages this zone can hold.
     * @param hasPark true if this zone has park and false otherwise.
     * @param hasCanteen true if this zone has canteen and false otherwise.
     * @return true if zone is added successfully and false otherwise.
     */
    public boolean addZone(String zoneName, String animalCategory,
            int cageCapacity, boolean hasPark, boolean hasCanteen) {
        
        String animalCategoryClassPath = "scf.session8." + animalCategory;
        try {
            Class.forName(animalCategoryClassPath);
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid Animal Category");
            return false;
        }
        
        if (!zones.containsKey(zoneName) && zones.size() < zoneCapacity) {
            Zone zone = new Zone(zoneName, animalCategory, cageCapacity,
                                 hasPark, hasCanteen);
            zones.put(zoneName, zone);
            return true;
        }
        
        return false;
    }
    
    /**
     * It is used to add a cage to the zoo. Cage will be added to proper zone
     * which supports this animal type. In case, no proper zone exists or 
     * limit on number of cages is reached, or animal type is invalid, then
     * cage will not be added.
     * @param animalType type of animal this cage will hold.
     * @param animalCapacity maximum number of animals this cage can hold.
     * @return true if cage is added successfully and false otherwise. Addition
     * of cage fails because of reasons defined in methods definition.
     */
    public boolean addCage(String animalType, int animalCapacity) {
        try {
            for (Zone zone: zones.values()) {
                if (zone.addCage(animalType, animalCapacity)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid Animal Type");
            return false;
        }
        
        return false;
    }
    
    /**
     * It is used to add cage to a specified zone. Cage will be added only
     * if provided zone supports the type of animal provided and upper limit
     * on number of cages has been reached or zone name is invalid.
     * @param zoneName name of zone to which cage is to be added.
     * @param animalType type of animal this cage will hold.
     * @param animalCapacity maximum number of animals this cage can hold.
     * @return true if cage is added successfully and false otherwise.
     * Addition of cage fails as per described in the methods definition.
     */
    public boolean addCage(String zoneName, String animalType,
                                    int animalCapacity) {
        
        if (zones.containsKey(zoneName)) {
            Zone zone = zones.get(zoneName);
            try {
                if (zone.addCage(animalType, animalCapacity)) {
                    return true;
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Invalid Animal Type for this Zone");
            }
        }
        
        return false;
    }
    
    /**
     * Add or remove park from some zone. It returns true if park is added or
     * removed successfully. Addition or removal fails if zone name is invalid.
     * @param zoneName zone from/to which park is removed/added.
     * @param hasPark true to add park and false to remove.
     * @return true if operation is completed successfully as described in the
     * method definition.
     */
    public boolean setPark(String zoneName, boolean hasPark) {
        if (zones.containsKey(zoneName)) {
            Zone zone = zones.get(zoneName);
            zone.setPark(hasPark);
        }
        
        return false;
    }
    
    /**
     * Add or remove canteen from some zone. It returns true if canteen is
     * added or removed successfully. Addition or removeal fails if zone name
     * is invalid.
     * @param zoneName zone from/to which canteen is removed/added.
     * @param hasCanteen true to add canteen and false to remove.
     * @return true if operation is completed successfully as described in the
     * methods definition.
     */
    public boolean setCanteen(String zoneName, boolean hasCanteen) {
        if (zones.containsKey(zoneName)) {
            Zone zone = zones.get(zoneName);
            zone.setCanteen(hasCanteen);
        }
        
        return false;
    }
    
    /**
     * It provides description of the state of the zoo.
     */
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append("\n\n\n********************\n\n\n");
        description.append("ZOO MANAGEMENT SYSTEM\n");
        description.append("Zoo name: " + zooName + "\n");
        description.append("Zone capacity: " + zoneCapacity + "\n");
        description.append("Total animals: " + animalIds.size() + "\n");
        for (Zone zone: zones.values()) {
            description.append(zone);
        }
        description.append("\n\n\n********************\n\n\n");
        
        return description.toString();
    }
    
    /*
     * Driver method for zoo management system.
     */
    public static void main(String[] args) {
        Zoo zoo = new Zoo("My Zoo", 4);
        
        zoo.addZone("North", "Mammal", 10, true, true);
        zoo.addCage("Lion", 3);
        Animal lion1 = new Lion("Lion1", 2, 20);
        zoo.addAnimal(lion1);
        Animal lion2 = new Lion("Lion2", 5, 60);
        zoo.addAnimal(lion2);
        zoo.addCage("Zebra", 10);
        Animal zebra1 = new Zebra("Zebra1", 3, 30);
        zoo.addAnimal(zebra1);
        zoo.addCage("Elephant", 5);
        Animal elephant1 = new Elephant("elephant1", 10, 500);
        zoo.addAnimal(elephant1);
        
        zoo.addZone("South", "Mammal", 10, true, true);
        
        zoo.addZone("East", "Bird", 10, true, true);
        zoo.addCage("Owl", 20);
        Animal owl1 = new Owl("Owl1", 1, 5);
        zoo.addAnimal(owl1);
        
        zoo.addZone("West", "Reptile", 10, true, true);
        zoo.addCage("Python", 2);
        Animal python1 = new Python("python1", 3, 15);
        zoo.addAnimal(python1);
        
        System.out.println(zoo);
    }
}
