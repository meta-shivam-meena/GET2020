/*
 * Test class For StringOperations class
 */

package scf.assignment2;

import java.util.Scanner;

public class StringOperationsTestClass {
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice = 0;
        String string1;
        String string2;
        int areEqual;
        do {
            System.out.println();
            System.out.println("1. Check equality of two strings");
            System.out.println("2. Reverse a string");
            System.out.println("3. Toggle cases of letters in a string");
            System.out.println("4. Find largest word in a string");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = readInt();
            switch (choice) {
            case 1:
                in.nextLine();
                System.out.println("Enter string 1");
                string1 = in.nextLine();
                System.out.println("Enter string 2");
                string2 = in.nextLine();
                areEqual = StringOperations.areEqual(string1, string2);
                if (areEqual == 1) {
                    System.out.println("Given two strings are equal.");
                } else {
                    System.out.println("Given two strings are not equal.");
                }
                break;
            case 2:
                in.nextLine();
                System.out.println("Enter string to be reversed");
                string1 = in.nextLine();
                System.out.println("Above string reversed is");
                System.out.println(StringOperations.reverseString(string1));
                break;
            case 3:
                in.nextLine();
                System.out.println("Enter string whose letters' cases"
                                   + " need to be toggled.");
                string1 = in.nextLine();
                System.out.println("Above string after toggling cases"
                                   + " of letters is");
                System.out.println(StringOperations.toggleCases(string1));
                break;
            case 4:
                in.nextLine();
                System.out.println("Enter string from which largest"
                                   + " word is needed to be found.");
                string1 = in.nextLine();
                System.out.println("Largest word in above string is");
                System.out.println(StringOperations.getLargestWord(string1));
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid Choice. Try Again.");
                break;
            }
        } while (choice != 0);
    }
    
    public static int readInt() {
        int number = -1;
        while (true) {
            if (in.hasNextInt()) {
                number = in.nextInt();
                break;
            } else {
                System.out.print("Please enter a valid integer: ");
                in.next();
            }
        }
        return number;
    }
}
