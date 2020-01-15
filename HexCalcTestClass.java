/*
 * This class is only intended to be used as test
 * class for HexCalc.
 */

package scf.assignment1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HexCalcTestClass {
    
    private static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        /*System.out.println(HexCalc.hexToDecimal("ad0"));
        System.out.println(HexCalc.decimalToHex(1609));
        System.out.println(HexCalc.addHex("9b","10c"));
        System.out.println(HexCalc.subtractHex("10c","9b"));
        System.out.println(HexCalc.multiplyHex("9b","10c"));
        System.out.println(HexCalc.divideHex("10cc","9b"));
        System.out.println(HexCalc.areEqual("ad","ad"));
        System.out.println(HexCalc.areEqual("ad","ae"));
        System.out.println(HexCalc.areEqual("bd","ad"));
        System.out.println(HexCalc.isGreater("ad","ac"));
        System.out.println(HexCalc.isGreater("ac","ac"));
        System.out.println(HexCalc.isGreater("ab","ac"));
        System.out.println(HexCalc.isSmaller("ad","ae"));
        System.out.println(HexCalc.isSmaller("af","ae"));
        System.out.println(HexCalc.isSmaller("ac","ac"));
        */
        int choice = 0;
        do {
            System.out.println("Operations");
            System.out.println("1. Decimal to Hexadecimal");
            System.out.println("2. Hexadecimal to Decimal");
            System.out.println("3. Addition of Hexadecimals");
            System.out.println("4. Subtraction of Hexadecimals");
            System.out.println("5. Multiplication of Hexadecimals");
            System.out.println("6. Division of Hexadecimals");
            System.out.println("7. Equality Test of Hexadecimals");
            System.out.println("8. Greater Than Test of Hexadecimals");
            System.out.println("9. Smaller Than Test of Hexadecimals");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            
            switch(choice) {
            case 1:
                decimalToHex();
                break;
            case 2:
                hexToDecimal();
                break;
            case 3:
                addHex();
                break;
            case 4:
                subtractHex();
                break;
            case 5:
                multiplyHex();
                break;
            case 6:
                divideHex();
                break;
            case 7:
                areEqual();
                break;
            case 8:
                isGreater();
                break;
            case 9:
                isSmaller();
                break;
            case 0:
                break;
            default:
                System.out.println("\nInvalid Choice. Try Again.");
            }
        } while (choice != 0);
        in.close();
    }
    
    public static String getHexInput() {
        
        String hexValue;
        int startIndex;
        
        outer: while (true) {
            System.out.print("Enter hex value: ");
            hexValue = in.next();
            if (hexValue.length() == 0) { // invalidating empty string.
                continue outer;
            }
            
            // Checking for valid characters in input string.
            for (int i = 0; i < hexValue.length(); i++) {
                char digit = hexValue.charAt(i);
                if (!((digit >= '0' && digit <= '9')
                        || (digit >= 'a' && digit <= 'f')
                        || (digit >= 'A' && digit <= 'F'))) {
                    System.out.println("Invalid Input. Try Again.");
                    continue outer;
                }
            }
            
            // with removing leading 0s, finding start of actual hex number.
            startIndex = 0;
            while (startIndex < hexValue.length()) {
                if (hexValue.charAt(startIndex) != '0') {
                    break;
                }
                startIndex++;
            }
            
            // taking substring representing actual hex number.
            hexValue = hexValue.substring(startIndex);
            
            // special case when string is of type "000..."
            // then actual input should be 0.
            if (hexValue.length() == 0) {
                return "0";
            }
            
            return hexValue;
        }
    }
    
    public static void hexToDecimal() {
        String hexValue = getHexInput();
        int decimalValue = HexCalc.hexToDecimal(hexValue);
        System.out.println("Equivalent Decimal Value: " + decimalValue);
    }
    
    public static void decimalToHex() {
        System.out.print("Enter decimal value: ");
        int decimalValue = 0;
        try {
            decimalValue = in.nextInt();
            String hexValue = HexCalc.decimalToHex(decimalValue);
            System.out.println("Equivalent Hexadecimal Value: " + hexValue);
        } catch (InputMismatchException e) {
            System.out.println("Invalid Decimal");
            in.next();
        }
    }
    
    public static void addHex() {
        System.out.println("First operand, ");
        String hexValue1 = getHexInput();
        System.out.println("Second operand, ");
        String hexValue2 = getHexInput();
        String sum = HexCalc.addHex(hexValue1, hexValue2);
        System.out.println("Sum: " + sum);
    }
    
    public static void subtractHex() {
        System.out.println("First operand, ");
        String hexValue1 = getHexInput();
        System.out.println("Second operand, ");
        String hexValue2 = getHexInput();
        String difference = HexCalc.subtractHex(hexValue1, hexValue2);
        System.out.println("Difference: " + difference);
    }
    
    public static void multiplyHex() {
        System.out.println("First operand, ");
        String hexValue1 = getHexInput();
        System.out.println("Second operand, ");
        String hexValue2 = getHexInput();
        String product = HexCalc.multiplyHex(hexValue1, hexValue2);
        System.out.println("Product: " + product);
    }
    
    public static void divideHex() {
        System.out.println("First operand, ");
        String hexValue1 = getHexInput();
        System.out.println("Second operand, ");
        String hexValue2 = getHexInput();
        String quotient = HexCalc.divideHex(hexValue1, hexValue2);
        System.out.println("Quotient: " + quotient);
    }
    
    public static void areEqual() {
        System.out.println("equal");
        System.out.println("First operand, ");
        String hexValue1 = getHexInput();
        System.out.println("Second operand, ");
        String hexValue2 = getHexInput();
        boolean result = HexCalc.areEqual(hexValue1, hexValue2);
        System.out.println("Are both equal: " + result);
    }
    
    public static void isGreater() {
        System.out.println("First operand, ");
        String hexValue1 = getHexInput();
        System.out.println("Second operand, ");
        String hexValue2 = getHexInput();
        boolean result = HexCalc.isGreater(hexValue1, hexValue2);
        System.out.println("Is first greater: " + result);
    }
    
    public static void isSmaller() {
        System.out.println("First operand, ");
        String hexValue1 = getHexInput();
        System.out.println("Second operand, ");
        String hexValue2 = getHexInput();
        boolean result = HexCalc.isSmaller(hexValue1, hexValue2);
        System.out.println("Is first smaller: " + result);
    }
}
