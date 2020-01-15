/*
 * Inventory class just acts as a database for inventory.
 * It simply stores the Items ids along with their corresponding objects.
 * Items in Inventory represents items available for addition into cart.
 */

package scf.assignment0;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Inventory class acts as database of available items in inventory.
 * @author Shivam Kumar Meena
 * create on 13th January, 2020
 */
public class Inventory {
    
    /**
     * It stores the available items and their corresponding Item objects.
     */
    private static Map<Integer, Item> itemIdAndObject = new
                                    HashMap<Integer, Item>();

    /**
     * It facilitates addition of new items to the inventory.
     * @param item
     */
    public static void addItem(Item item) {
        int id = item.getId();
        itemIdAndObject.put(id, item);
    }
    
    /**
     * It tells whether item with given id is present in inventory or not.
     * @param id
     * @return
     */
    public static boolean containsItem(int id) {
        return itemIdAndObject.containsKey(id);
    }
    
    /**
     * It is used to get Item object for given id.
     * @param id
     * @return
     */
    public static Item getItem(int id) {
        return itemIdAndObject.get(id);
    }
    
    /**
     * It is used to remove item from the inventory.
     * @param id
     */
    public static void removeItem(int id) {
        itemIdAndObject.remove(id);
    }
    
    /**
     * It displays the current state of the Inventory.
     */
    public static void displayInventory() {
        Iterator<Map.Entry<Integer, Item>> iterator =
                                        itemIdAndObject.entrySet().iterator();
        System.out.println(String.format("%20s %-20s %20s",
                                         "", "Inventory", ""));
        System.out.println();
        System.out.println(String.format("%-20s %-20s %-20s",
                                         "Item Id", "Item Name", "Item Price"));
        while(iterator.hasNext()) {
            try {
                Map.Entry<Integer, Item> entry = iterator.next();
                int id = entry.getKey();
                String name = entry.getValue().getName();
                String price = "Rs. " + entry.getValue().getPrice();
                System.out.println(String.format("%-20s %-20s %-20s", id, name, price));
            } catch (NullPointerException e) {
                System.out.println("Item not found.");
            }
        }
    }
}
