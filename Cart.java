/*
 * Cart represents a shopping cart which can store Item objects
 * along with their respective quantity which can be updated
 * and can be used to generate bill.
 */

package scf.assignment0;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/*
 * Cart mimics the functionality of a shopping cart
 * with various other facilities.
 * @author Shivam Kumar Meena
 * create on 9th January, 2020.
 */
public class Cart {

    /**
     * HashMap data structure used for storing items in cart
     */
    private Map<Integer, Integer> cart;

    /**
     * Default Constructor which initializes the data structure for cart.
     */
    public Cart() {
        cart = new HashMap<Integer, Integer>();
    }

    /**
     * It is used add a single Item object to cart.
     * @param id
     */
    public void addItem(int id) {
        addItem(id, 1);
    }

    /**
     * It is used to multiple Item objects to cart.
     * It assumes quantity is positive.
     * @param id
     * @param quantity
     */
    public void addItem(int id, int quantity) {
        if (cart.containsKey(id)) {
            quantity += cart.get(id);
        }
        updateCart(id, quantity);
    }

    /**
     * It is used to update existing cart items.
     * It can also be used to add new items.
     * It assumes that quantity is positive.
     * @param id
     * @param quantity
     */
    public void updateCart(int id, int quantity) {
        if (Inventory.containsItem(id)) {
            cart.put(id, quantity);
        } else {
            System.out.println("Item not available.\n");
        }
    }

    /**
     * It is used remove an item form cart.
     * If item is present in cart, then it is removed from cart.
     * @param id
     */
    public void removeItem(int id) {
        cart.remove(id);
    }
    
    /**
     * It is used to display cart contents.
     */
    public void displayCart() {
        Iterator<Map.Entry<Integer, Integer>> iterator =
                                        cart.entrySet().iterator();
        System.out.println(String.format("%-10s %-20s %-10s", "Id", "Name", "Quantity"));
        while (iterator.hasNext()) {
            try {
                Map.Entry<Integer, Integer> entry = iterator.next();
                Item item = Inventory.getItem(entry.getKey());
                int id = item.getId();
                String name = item.getName();
                int quantity = entry.getValue();
                System.out.println(String.format("%-10s %-20s %-10s", id, name, quantity));
            } catch (NullPointerException e) {
                System.out.println("Item not found.");
            }
        }
        System.out.println();
    }

    /**
     * It is used to generate bill for the current items in cart.
     */
    public void generateBill() {
        int totalQuantity = 0;
        double billAmount = 0;
        System.out.println("\tComputer Generated Bill\n");
        System.out.println(String.format("%-10s %-20s %-20s %-20s", "Id", "Item",
                                         "Quantity", "Amount"));
        Iterator<Map.Entry<Integer, Integer>> iterator =
                                        cart.entrySet().iterator();
        while (iterator.hasNext()) {
            try {
                Map.Entry<Integer, Integer> entry = iterator.next();
                Item item = Inventory.getItem(entry.getKey());
                int id = item.getId();
                String name = item.getName();
                double price = item.getPrice();
                int quantity = entry.getValue();
                double amount = price * quantity;
                System.out.println(String.format("%-10s %-20s %-20s %-20s", id, name,
                                                quantity, amount));
                totalQuantity += quantity;
                billAmount += amount;
            } catch (NullPointerException e) {
                System.out.println("Item not found.");
            }
        }
        System.out.println();
        System.out.println(String.format("%-10s %-20s %-20s %-20s", "", "Grand Total",
                                        totalQuantity, billAmount));
    }
}
