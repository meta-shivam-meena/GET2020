package scf.session6;

/**
 * Poly represents a polynomial with integer coeffiecients.
 * It also supports some related operations.
 * @author Shivam Kumar Meena
 * created on 21st January, 2020
 */
public final class Poly {
    private final int[][] poly;
    
    /**
     * It initializes the poly with input array
     * First column of array represents coefficients and
     * second column represents corresponding exponent for variable.
     * @param input array to initialize the poly.
     * @throws AssertionError
     */
    public Poly(int[][] input) throws AssertionError {
        int[][] inputCopy = new int[input.length][2];
        
        if (input.length == 0) {
            poly = new int[0][0];
            return;
        }
        
        for (int i = 0; i < input.length; i++) {
            if (input[i].length != 2) {
                throw new AssertionError();
            }
            
            if (input[i][1] < 0) {
                throw new AssertionError();
            }
            
            inputCopy[i][0] = input[i][0];
            inputCopy[i][1] = input[i][1];
        }
        
        poly = initializePoly(inputCopy);
    }
    
    /**
     * It evaluates the poly for given input.
     * @param x value for which we need to evaluate the poly.
     * @return poly evaluated for given input.
     */
    public double evaluate(float x) {
        double result = 0;
        double polyTermValue;
        
        for (int i = 0; i < poly.length; i++) {
            polyTermValue = poly[i][0] * Math.pow(x, poly[i][1]);
            result += polyTermValue;
        }
        
        return result;
    }
    
    /**
     * It returns the degree of the poly.
     * @return degree of the poly.
     */
    public int degree() {
        if (poly.length == 0) {
            return 0;
        } else {
            return poly[poly.length - 1][1];
        }
    }
    
    /**
     * It adds the two input polys and return the result.
     * @param poly1 first poly
     * @param poly2 second poly
     * @return sum of given input polys.
     */
    public Poly addPoly(Poly poly1, Poly poly2) {
        int[][] result = new int[poly1.poly.length + poly2.poly.length][2];
        int indexResult = 0;
        
        for (int i = 0; i < poly1.poly.length; i++) {
            result[indexResult][0] = poly1.poly[i][0];
            result[indexResult][1] = poly1.poly[i][1];
            indexResult++;
        }
        
        for (int i = 0; i < poly2.poly.length; i++) {
            result[indexResult][0] = poly2.poly[i][0];
            result[indexResult][1] = poly2.poly[i][1];
            indexResult++;
        }
        
        return new Poly(result);
    }
    
    /**
     * It multiplies the two input polys and return the result.
     * @param poly1 first poly
     * @param poly2 second poly
     * @return product of given two input polys.
     */
    public Poly multiplyPoly(Poly poly1, Poly poly2) {
        int[][] result = new int[poly1.poly.length * poly2.poly.length][2];
        int indexResult = 0;
        
        for (int i = 0; i < poly1.poly.length; i++) {
            for (int j = 0; j < poly2.poly.length; j++) {
                result[indexResult][0] = poly1.poly[i][0] * poly2.poly[j][0];
                result[indexResult][1] = poly1.poly[i][1] + poly2.poly[j][1];
                indexResult++;
            }
        }
        
        return new Poly(result);
    }
    
    /**
     * It checks for the equality of input poly with invoked poly object.
     * @param polynomial poly to be checked for equality
     * @return true if polynomial is same as invoked object poly and
     * false otherwise.
     */
    public boolean equals(Poly polynomial) {
        if (poly.length != polynomial.poly.length) {
            return false;
        }
        
        for (int i = 0; i < poly.length; i++) {
            if (poly[i][0] != polynomial.poly[i][0]
                    || poly[i][1] != polynomial.poly[i][1]) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * It helps in construction of poly. It removes zero coefficient
     * members. It also combines coeffiecients with same exponent and store
     * exponent in sorted order.
     * @param input
     * @return
     */
    private int[][] initializePoly(int[][] input) {
        int countDifferentExponents;
        int[][] result;
        int resultIndex;
        int[] temporaryArray;
        
        if (input.length == 0) {
            return input;
        }
        
        // sorting input according to exponent part in ascending order.
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j][1] > input[j + 1][1]) {
                    temporaryArray = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temporaryArray;
                }
            }
        }
        
        
        // counting total number of different exponents in input.
        countDifferentExponents = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i][0] != 0 && input[i][1] != input[i - 1][1]) {
                countDifferentExponents++;
            }
        }
        
        // assigning input elements to result.
        result = new int[countDifferentExponents][2];
        result[0][0] = input[0][0]; // assigning coeffiecient of first element
        result[0][1] = input[0][1]; // assigning exponent of first element
        resultIndex = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i][0] == 0) {
                continue;
            }
            if (input[i][1] == input[i - 1][1]) {
                result[resultIndex][0] += input[i][0];
            } else {
                resultIndex++;
                result[resultIndex][0] = input[i][0];
                result[resultIndex][1] = input[i][1];
            }
        }
        
        return result;
    }
}
