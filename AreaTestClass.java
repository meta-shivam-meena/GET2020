/*
 * Test class for Area class.
 */

package scf.assignment2;

import java.util.Scanner;

public class AreaTestClass {
    
    private static Scanner in;
    
    public static void main(String[] args) {
        double width;
        double height;
        double radius;
        double area;
        in = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println();
            System.out.println("Calculate Area of ");
            System.out.println("1. Triangle");
            System.out.println("2. Rectangle");
            System.out.println("3. Square");
            System.out.println("4. Circle");
            System.out.println("0. Exit");
            System.out.println("Select an option");
            choice = readInt();
            System.out.println();
            switch (choice) {
            case 1:
                System.out.println("Enter width of triangle");
                width = readDouble();
                System.out.println("Enter height of triangle");
                height = readDouble();
                area = Area.getTriangleArea(width, height);
                System.out.println("The area of triangle with width "
                                   + width + " and height " + height
                                   + " is " + area + ".");
                break;
            case 2:
                System.out.println("Enter width of rectangle");
                width = readDouble();
                System.out.println("Enter height of rectangle");
                height = readDouble();
                area = Area.getRectangleArea(width, height);
                System.out.println("The area of rectangle with width "
                                   + width + " and height " + height
                                   + " is " + area + ".");
                break;
            case 3:
                System.out.println("Enter width of square");
                width = readDouble();
                area = Area.getSquareArea(width);
                System.out.println("The area of square with width "
                                   + width + " is " + area + ".");
                break;
            case 4:
                System.out.println("Enter radius of circle");
                radius = readDouble();
                area = Area.getCircleArea(radius);
                System.out.println("The area of circle with radius "
                                   + radius + " is " + area + ".");
            case 0:
                break;
            default:
                System.out.println("Invalid Choice. Try Again.");
                break;
            }
        } while (choice != 0);
        in.close();
    }
    
    public static int readInt() {
        int number = -1;
        do {
            System.out.print("Please enter a valid positive number: "); 
            if (in.hasNextInt()) {
                number = in.nextInt();
            } else {
                System.out.println("I need a valid positive int.");
                in.next();
            }
        } while (number < 0);
        return number;
    }
    
    public static double readDouble() {
        double number = -1;
        do {
            System.out.print("Please enter a valid positive double: "); 
            if (in.hasNextDouble()) {
                number = in.nextDouble();
            } else {
                System.out.println("I need a positive double.");
                in.next();
            }
        } while (number <= 0);
        return number;
    }
}
