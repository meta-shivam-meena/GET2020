/*
 * It is a utility class for hexadecimal calculations.
 * It assumes that hexadecimal strings have only valid characters
 * 0-9, a-f, A-F and have spaces or leading 0s
 * and are not empty.
 */

package scf.assignment1;

/**
 * It is utility class for hexadecimal calculations.
 * It assumes that hexadecimal strings have only valid characters
 * 0-9, a-f, A-F and have spaces or leading 0s
 * and are not empty.
 * @author Shivam Kumar Meena
 * created on 10th January, 2020
 */
public class HexCalc {
    
    /**
     * It assumes that string have only valid characters
     * 0-9, a-f, A-F and there are no spaces or leading 0s.
     * It denotes the radix or base value of hexadecimal number system.
     */
    private static final int RADIX = 16;
    
    /**
     * It represents sequence of hexadecimal digits stored in ascending order.
     * A character in string is hexadecimal representation of the 
     * decimal i, where i represents the position of the character in
     * string, first character has position 0.
     */
    private static final String HEX_DIGITS = "0123456789ABCDEF";
    
    /**
     * It converts a hexadecimal string into equivalent decimal value.
     * @param hexValue
     * @return
     */
    public static int hexToDecimal(String hexValue) {
        hexValue = hexValue.toUpperCase();
        int decimalValue = 0;
        for (int i = 0; i < hexValue.length(); i++) {
            char hexDigit = hexValue.charAt(i);
            int decimalDigit = HEX_DIGITS.indexOf(hexDigit);
            decimalValue = (RADIX * decimalValue) + decimalDigit;
        }
        return decimalValue;
    }
    
    /**
     * It converts a decimal value into equivalent hexadecimal string.
     * @param decimalValue
     * @return
     */
    public static String decimalToHex(int decimalValue) {
        StringBuilder hexValueReversed = new StringBuilder("");
        while (decimalValue > 0) {
            int remainder = decimalValue % 16;
            char hexDigit = HEX_DIGITS.charAt(remainder);
            hexValueReversed.append(hexDigit);
            decimalValue /= RADIX;
        }
        return hexValueReversed.reverse().toString();
    }
    
    /**
     * It performs the addition operation on two hexadecimal strings.
     * It returns hexadecimal sum string
     * representing oeprand1 + operand2.
     * @param hexValue1
     * @param hexValue2
     * @return
     */
    public static String addHex(String hexValue1, String hexValue2) {
        int decimalValue1 = hexToDecimal(hexValue1);
        int decimalValue2 = hexToDecimal(hexValue2);
        int sum = decimalValue1 + decimalValue2;
        return decimalToHex(sum);
    }
    
    /**
     * It performs the subtraction operation on two hexadecimal strings.
     * It returns hexadecimal difference string
     * representing operand1 - operand2.
     * @param hexValue1
     * @param hexValue2
     * @return
     */
    public static String subtractHex(String hexValue1, String hexValue2) {
        int decimalValue1 = hexToDecimal(hexValue1);
        int decimalValue2 = hexToDecimal(hexValue2);
        int difference = decimalValue1 - decimalValue2;
        return decimalToHex(difference);
    }
    
    /**
     * It performs the multiplication operation on two hexadecimal strings.
     * It returns hexadecimal product string
     * representing operand1 * operand2.
     * @param hexValue1
     * @param hexValue2
     * @return
     */
    public static String multiplyHex(String hexValue1, String hexValue2) {
        int decimalValue1 = hexToDecimal(hexValue1);
        int decimalValue2 = hexToDecimal(hexValue2);
        int product = decimalValue1 * decimalValue2;
        return decimalToHex(product);
    }
    
    /**
     * It performs the division operation on two hexadecimal strings.
     * It returns hexadecimal quotient string 
     * representing of operand1 / operand2.
     * @param hexValue1
     * @param hexValue2
     * @return
     */
    public static String divideHex(String hexValue1, String hexValue2) {
        int decimalValue1 = hexToDecimal(hexValue1);
        int decimalValue2 = hexToDecimal(hexValue2);
        int quotient = decimalValue1 / decimalValue2;
        return decimalToHex(quotient);
    }
    
    /**
     * It checks for the equality of two hexadecimal strings.
     * @param hexValue1
     * @param hexValue2
     * @return
     */
    public static boolean areEqual(String hexValue1, String hexValue2) {
        hexValue1 = hexValue1.toUpperCase();
        hexValue2 = hexValue2.toUpperCase();
        if (hexValue1.length() != hexValue2.length()) {
            return false;
        }
        for (int i = 0; i < hexValue1.length(); i++) {
            if (hexValue1.charAt(i) != hexValue2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * It checks whether first hexadecimal string is greater than
     * second hexadecimal string or not.
     * @param hexValue1
     * @param hexValue2
     * @return
     */
    public static boolean isGreater(String hexValue1, String hexValue2) {
        hexValue1 = hexValue1.toUpperCase();
        hexValue2 = hexValue2.toUpperCase();
        if (hexValue1.length() > hexValue2.length()) {
            return true;
        } else if (hexValue1.length() < hexValue2.length()) {
            return false;
        }
        int i;
        for (i = 0; i < hexValue1.length() - 1; i++) {
            if (hexValue1.charAt(i) < hexValue2.charAt(i)) {
                return false;
            }
        }
        if (hexValue1.charAt(i) <= hexValue2.charAt(i)) {
            return false;
        }
        return true;
    }
    
    /**
     * It checks whether first hexadecimal string is smaller than
     * second hexadecimal string or not.
     * @param hexValue1
     * @param hexValue2
     * @return
     */
    public static boolean isSmaller(String hexValue1, String hexValue2) {
        hexValue1 = hexValue1.toUpperCase();
        hexValue2 = hexValue2.toUpperCase();
        if (hexValue1.length() < hexValue2.length()) {
            return true;
        } else if (hexValue1.length() > hexValue2.length()) {
            return false;
        }
        int i;
        for (i = 0; i < hexValue1.length() - 1; i++) {
            if (hexValue1.charAt(i) > hexValue2.charAt(i)) {
                return false;
            }
        }
        if (hexValue1.charAt(i) >= hexValue2.charAt(i)) {
            return false;
        }
        return true;
    }
}
