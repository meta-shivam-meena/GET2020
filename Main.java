/*
 * Main class is just for testing the functionality of Cart class.
 * Input should be supplied in proper format.
 * No error handling is preset.
 */

package scf.assignment0;

import java.util.Scanner;

public class Main {
    
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Item apple = new Item(1, "Apple", 20);
        Item orange = new Item(2, "Orange", 10);
        Item penDrive = new Item(3, "Pen Drive", 500);
        Item mobile = new Item(4, "Mobile", 10000);

        Inventory.addItem(apple);
        Inventory.addItem(orange);
        Inventory.addItem(penDrive);
        Inventory.addItem(mobile);
        
        int choice = 0;
        do {
            System.out.println("1. Admin Home");
            System.out.println("2. User Home");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = in.nextInt();
            switch (choice) {
            case 1:
                adminHome();
                break;
            case 2:
                userHome();
                break;
            case 0:
                break;
            default:
                System.out.println("\nInvalid Choice. Try Again.\n");
            }
        } while (choice != 0);
        in.close();
    }
    
    public static void adminHome() {
        int choice = 0;
        do {
            System.out.println();
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Inventory");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = in.nextInt();
            switch(choice) {
            case 1:
                addItemToInventory();
                break;
            case 2:
                removeItemFromInventory();
                break;
            case 3:
                Inventory.displayInventory();
                break;
            case 0:
                break;
            default:
            }
        } while (choice != 0);
    }
    
    public static void addItemToInventory() {
        System.out.println();
        System.out.println("Enter item id: ");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Enter item name: ");
        String name = in.nextLine();
        System.out.println("Enter item price: ");
        double price = in.nextDouble();
        Inventory.addItem(new Item(id, name, price));
    }
    
    public static void removeItemFromInventory() {
        Inventory.displayInventory();
        System.out.println();
        System.out.print("Enter item id: ");
        int id = in.nextInt();
        Inventory.removeItem(id);
    }
    
    public static void userHome() {
        Cart cart = new Cart();
        int choice = 0;
        do {
            System.out.println("1. Add Item");
            System.out.println("2. Add Item with Quantity");
            System.out.println("3. Update Cart");
            System.out.println("4. Remove Item");
            System.out.println("5. Display Cart");
            System.out.println("6. Generate Bill");
            System.out.println("0. Exit");
            System.out.print("\n Enter your choice: ");
            choice = in.nextInt();
            switch (choice) {
            case 1:
                addItem(cart);
                break;
            case 2:
                addItemWithQuantity(cart);
                break;
            case 3:
                updateCart(cart);
                break;
            case 4:
                removeItem(cart);
                break;
            case 5:
                cart.displayCart();
                break;
            case 6:
                cart.generateBill();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid Choice. Try Again.\n");
            }
        } while (choice != 0);
    }
    
    public static void addItem(Cart cart) {
        Inventory.displayInventory();
        System.out.println();
        System.out.print("Select item id: ");
        int id = in.nextInt();
        cart.addItem(id);
    }
    
    public static void addItemWithQuantity(Cart cart) {
        Inventory.displayInventory();
        System.out.println();
        System.out.print("Select item id: ");
        int id = in.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = in.nextInt();
        cart.addItem(id, quantity);
    }
    
    public static void updateCart(Cart cart) {
        cart.displayCart();
        System.out.println();
        System.out.print("Select item id: ");
        int id = in.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = in.nextInt();
        cart.updateCart(id, quantity);
    }
    
    public static void removeItem(Cart cart) {
        cart.displayCart();
        System.out.println();
        System.out.print("Select item id: ");
        int id = in.nextInt();
        cart.removeItem(id);
    }
}
