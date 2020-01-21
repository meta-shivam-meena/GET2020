package scf.session5;

/**
 * Utility class for finding lcm and hcf of positive integers.
 * @author Shivam Kumar Meena
 * create on 20th January, 2020
 */
public class LcmAndHcf {
    
    /**
     * It calculates and return lcm of two numbers.
     * @param x first number
     * @param y second number
     * @return lcm of given input numbers
     * @throws AssertionError when any input is non-positive
     */
    public static int lcm(int x, int y) throws AssertionError {
        if (x <= 0 || y <= 0) {
            throw new AssertionError();
        }
        if (y > x) {
            return lcmHelper(x, y, y);
        } else {
            return lcmHelper(y, x, x);
        }
    }
    
    /**
     * It calculates and returns hcf of two numbers
     * @param x first number
     * @param y second number
     * @return hcf of given input numbers
     * @throws AssertionError when any of input is non-positive
     */
    public static int hcf(int x, int y) throws AssertionError {
        if (x <= 0 || y <= 0) {
            throw new AssertionError();
        }
        return hcfHelper(x, y);
    }
    
    public static int hcfHelper(int x, int y) {
        if (x == 0) {
            return y;
        }
        return hcfHelper(y % x, x);
    }

    private static int lcmHelper(int x, int y, int multiple) {
        if (multiple % x == 0) {
            return multiple;
        }
        
        return lcmHelper(x, y, multiple + y);
    }
}
