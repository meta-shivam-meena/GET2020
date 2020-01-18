package scf.session4;

/**
 * ArrOperation class contains some methods related to logical operation
 * on array with positive integers.
 * @author Shivam Kumar Meena
 * created on 16th January, 2020
 */
public class ArrOperation {
    
    /**
     * It calculates the length of maximum mirror section in array.
     * A mirror section in an array is a group of contiguous elements
     * such that somewhere in the array, the same group appears in
     * reverse order.
     * @param numbers array of positive integers.
     * @return length of largest mirror section in numbers array.
     * @throws AssertionError if the numbers array is empty.
     */
    public static int maxMirror(int[] numbers) throws AssertionError {
        
        int[][] matrix;
        int maxMirrorLength;
        
        if (numbers.length == 0) {
            throw new AssertionError();
        }
        
        // using dynamic programming similar to lcs algorithm
        // to store length of common subarrays between numbers
        // and reverse of number.
        matrix = new int[numbers.length + 1][numbers.length + 1];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (numbers[i - 1] == numbers[numbers.length - j]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }
            }
        }
        
        // finding maximum length of max mirror in matrix array.
        maxMirrorLength = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxMirrorLength) {
                    maxMirrorLength = matrix[i][j];
                }
            }
        }
        
        return maxMirrorLength;
    }
    
    /**
     * It counts total number of clumps in an array of positive integers.
     * Clump in an array is a series of 2 or more adjacent
     * elements of the same value.
     * @param numbers array of positive integers.
     * @return total number of clumps in the numbers array.
     * @throws AssertionError if input array is empty.
     */
    public static int countClumps(int[] numbers) throws AssertionError {
        
        // clumpFound is false if we are looking for start of a clump
        // and is set true once a clump starts.
        boolean clumpFound;
        int totalClumps;
        
        if (numbers.length == 0) {
            throw new AssertionError();
        }
        
        clumpFound = false;
        totalClumps = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) { // in the clump
                if (!clumpFound) { // start of a clump
                    clumpFound = true;
                    totalClumps++;
                }
            } else { // to set end of a clump
                clumpFound = false;
            }
        }
        
        return totalClumps;
    }
    
    /**
     * It returns an array that contains exactly the same numbers
     * as the input array, but rearranged so that every x is immediately
     * followed by a y. It doesn't move x within array, but every other
     * number may move.
     * @param numbers array of positive integers.
     * @param x positive integer which can't be moved.
     * @param y positive integer which must immediately follows x in
     * output array 
     * @return array as specified in the method definition.
     * @throws AssertionError if numbers array is empty, or if there are
     * unequal number of x and y, or if two adjacent x values are present
     * in array, or if x and y are same, or if x occurs at the last
     * index of array. 
     */
    public static int[] fixXY(int[] numbers, int x, int y)
                                    throws AssertionError {
        
        int length;
        // isMoved[i] denotes if numbers[i] has been moved to result
        // array or not. true if moved, else false.
        boolean[] isMoved; 
        int[] result;
        // for iterating on numbers array.
        int indexNumbers;
        // for iterating on result array.
        int indexResult;
        
        if (!isValidInputForFixXY(numbers, x, y)) {
            throw new AssertionError();
        }
        
        length = numbers.length;
        isMoved = new boolean[length];
        result = new int[length];
        
        // copying all x from numbers to result array at same index.
        for (int i = 0; i < length; i++) {
            if (numbers[i] == x) {
                result[i] = x;
                isMoved[i] = true;
            }
        }
        
        // moving all y after x in result array from numbers array.
        indexNumbers = 0;
        indexResult = 0;
        while (indexResult < length - 1) {
            
            if (result[indexResult] == x) {
                
                while (indexNumbers < length && numbers[indexNumbers] != y) {
                    indexNumbers++;
                }
                
                result[indexResult + 1] = y;
                isMoved[indexNumbers] = true;
                indexNumbers++;
            }
            indexResult++;
        }
        
        // moving remaining elements from numbers to result array.
        indexNumbers = 0;
        indexResult = 0;
        while (indexResult < length) {
            
            if (result[indexResult] == x || result[indexResult] == y) {
                indexResult++;
                continue;
            }
            
            if (isMoved[indexNumbers]) {
                indexNumbers++;
                continue;
            }
            
            result[indexResult] = numbers[indexNumbers];
            indexResult++;
            indexNumbers++;
        }
        
        return result;
    }
    
    /**
     * It returns the index in array if there is a place to split the input
     * array such that the sum of the numbers on one side is equal to the
     * sum of the numbers on the other side of index, else return -1. Returned
     * index element is included in right side subarray.
     * @param numbers array of positive integers.
     * @return index in array as specified in method definition, or -1.
     * @throws AssertionError if numbers array is empty.
     */
    public static int splitArray(int[] numbers) throws AssertionError {
        
        int arraySum;
        int index;
        int runningSum;
        
        if (numbers.length == 0) {
            throw new AssertionError();
        }
        
        arraySum = 0;
        for (int i = 0; i < numbers.length; i++) {
            arraySum += numbers[i];
        }
        
        // if sum is odd, then there is no index, where left subarray
        // and half subarray have equal sum.
        if (arraySum % 2 != 0) {
            return -1;
        }
        
        // finding index where, sum of left array is equal to half of
        // sum of array elements.
        index = 0;
        runningSum = 0;
        while (runningSum != (arraySum / 2)) {
            runningSum += numbers[index];
            index++;
        }
        
        return index;
    }
    
    /*
     * Checks valid of input for fixXY method as specified in description
     * of fixXY method.
     */
    private static boolean isValidInputForFixXY(int[] numbers, int x, int y) {
        if (numbers.length == 0 || numbers[numbers.length - 1] == x) {
            return false;
        }
        
        if (x == y) {
            return false;
        }
        
        int countX = 0;
        int countY = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == x) {
                if (numbers[i + 1] == x) {
                    return false;
                }
                countX++;
            } else if (numbers[i] == y) {
                countY++;
            }
        }
        if (numbers[numbers.length - 1] == y) {
            countY++;
        }
        
        if (countX != countY) {
            return false;
        }
        
        return true;
    }
    
    // test method for above methods.
    public static void main(String[] args) {
        
        System.out.println();
        int[] arr0 = {8, 8, 9, 10, 9, 8, 8, 8};
        System.out.println(maxMirror(arr0));
        int[] arr1 = {1, 2, 3, 8, 9, 3, 2, 1};
        System.out.println(maxMirror(arr1));
        int[] arr2 = {7, 1, 4, 9, 7, 4, 1};
        System.out.println(maxMirror(arr2));
        int[] arr3 = {1, 2, 1, 4};
        System.out.println(maxMirror(arr3));
        int[] arr4 = {1, 4, 5, 3, 5, 4, 1};
        System.out.println(maxMirror(arr4));
        
        System.out.println();
        int[] arr5 = {1, 2, 2, 3, 4, 4};
        System.out.println(countClumps(arr5));
        int[] arr6 = {1, 1, 2, 1, 1};
        System.out.println(countClumps(arr6));
        int[] arr7 = {1, 1, 1, 1, 1};
        System.out.println(countClumps(arr7));
        int[] arr8 = {5, 4, 9, 4, 9, 5};
        
        System.out.println();
        arr8 = fixXY(arr8, 4, 5);
        for (int i = 0; i < arr8.length; i++) {
            System.out.print(arr8[i] + " ");
        }
        System.out.println();
        int[] arr9 = {1, 4, 5, 1};
        arr9 = fixXY(arr9, 4, 5);
        for (int i = 0; i < arr9.length; i++) {
            System.out.print(arr9[i] + " ");
        }
        System.out.println();
        int[] arr10 = {1, 4, 1, 5, 5, 4, 1};
        arr10 = fixXY(arr10, 4, 5);
        for (int i = 0; i < arr10.length; i++) {
            System.out.print(arr10[i] + " ");
        }
        System.out.println();
        
        System.out.println();
        int[] arr11 = {1, 1, 1, 2, 1};
        System.out.println(splitArray(arr11));
        int[] arr12 = {2, 1, 1, 2, 1};
        System.out.println(splitArray(arr12));
        int[] arr13 = {10, 10};
        System.out.println(splitArray(arr13));
    }
}
