/*
 * This class represents an item in inventory
 */

package scf.assignment0;

/**
 * This class represents an item.
 * @author Shivam Kumar Meena
 * create on 9th January, 2020.
 */
public class Item {

    /**
     * It uniquely identifies the item.
     */
    private int id;
    
    /**
     * It represents name of the item.
     */
    private String name;

    /**
     * It represents price of the item.
     */
    private double price;

    /**
     * It provides description of the item.
     */
    private String description;

    /**
     * Constructor to create an item with name and price of item.
     * Assumes price is non-negative.
     * @param id
     * @param name
     * @param price 
     */
    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        description = "No description found";
    }

    /**
     * Constructor to create an item with name, price and description of item.
     * @param id
     * @param name
     * @param price
     * @param description
     */
    public Item(int id, String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
    /**
     * It returns the id of the item.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * It returns the name of the item.
     * @return name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * It return the price of the item.
     * 
     * @return price of the item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * It return the description of the item.
     */
    public String toString() {
        return name + " - " + description;
    }
    
    /**
     * It is used to update price of the item.
     * @param price
     */
    public void updatePrice(double price) {
        this.price = price;
    }
}
