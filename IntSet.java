package scf.session6;

import java.util.Arrays;

/**
 * IntSet class represents a set of integers between 1 and 1000.
 * This also contains some methods related to sets.
 * @author Shivam Kumar Meena
 * created on 21st January, 2020
 */
public final class IntSet {
    /**
     * array to store set elements in sorted manner and without duplicates.
     */
    private final int[] set;
    
    /**
     * Constructor which initializes the set with input array elements.
     * @param integers input for initialization of set
     * @throws AssertionError when input array is empty or contains
     * invalid integers.
     */
    public IntSet(int[] integers) throws AssertionError {
        // copying array to avoid changing input array
        int[] integersCopy = new int[integers.length];
        System.arraycopy(integers, 0, integersCopy, 0, integers.length);

        set = getSortedArrayWithoutDuplicates(integersCopy);
    }
    
    /**
     * It returns true if key is present in the set and false otherwise.
     * @param key integer to be searched.
     * @return returns true is key is present in set, and false otherwise.
     */
    public boolean isMember(int key) {
        return binarySearchForExistenceOfElement(0, set.length - 1, key);
    }
    
    /**
     * It returns the size of the set.
     * @return number of elements in set.
     */
    public int size() {
        return set.length;
    }
    
    /**
     * It tests whether input set is subset of this set.
     * @param subSet input set.
     * @return true if input set is subset of this set and false otherwise.
     */
    public boolean isSubSet(IntSet subSet) {
        
        for (int i = 0; i < subSet.set.length; i++) {
            // if any member of subSet is not present in this set
            // then input set is not a subset of this set.
            if (!isMember(subSet.set[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * It returns the complement of this set. Universal set is assumed
     * to be set of integers from 1 to 1000.
     * @return complement of this set.
     */
    public IntSet getComplement() {
        int[] result = new int[1000 - set.length];
        int resultIndex = 0;
        
        for (int i = 1; i <= 1000; i++) {
            if (!isMember(i)) {
                result[resultIndex] = i;
                resultIndex++;
            }
        }
        
        return new IntSet(result);
    }
    
    /**
     * It calculates and return union of given two input sets.
     * @param set1 first input set
     * @param set2 second input set
     * @return union of input sets
     */
    public IntSet union(IntSet set1, IntSet set2) {
        int[] result = new int[set1.set.length + set2.set.length];
        int resultIndex = 0;
        
        // adding all elements of set1 to result
        for (int i = 0; i < set1.set.length; i++) {
            result[resultIndex] = set1.set[i];
            resultIndex++;
        }
        
        // adding all elements of set2 to result
        for (int i = 0; i < set2.set.length; i++) {
            result[resultIndex] = set2.set[i];
            resultIndex++;
        }
        
        return new IntSet(result);
    }
    
    /**
     * It is a helper method for constructor and does what the name says.
     * @param integers copy of input to the constructor
     * @return what name says
     * @throws AssertionError when input is invalid, i.e. any element of
     * array is less than 1 or greater than 1000.
     */
    private int[] getSortedArrayWithoutDuplicates(int[] integers) 
                                    throws AssertionError {
        int size;
        int[] result;
        int resultIndex;
        
        if (integers.length == 0 || integers.length == 1) {
            return integers;
        }
        
        Arrays.sort(integers);
        
        if (integers[0] < 1 || integers[0] > 1000) {
            throw new AssertionError();
        }        
        size = 1;
        for (int i = 1; i < integers.length; i++) {
            if (integers[i] < 1 || integers[i] > 1000) {
                throw new AssertionError();
            }
            if (integers[i] != integers[i - 1]) {
                size++;
            }
        }
        
        result = new int[size];
        result[0] = integers[0];
        resultIndex = 1;
        for (int i = 1; i < integers.length; i++) {
            if (integers[i] != integers[i - 1]) {
                result[resultIndex] = integers[i];
                resultIndex++;
            }
        }
        
        return result;
    }
    
    // binary search implementation for isMember() method. 
    private boolean binarySearchForExistenceOfElement(int left,
                                    int right, int key) {
        int mid;
        
        if (left > right) {
            return false;
        }
        
        mid = (left + right) / 2;
        if (key == set[mid]) {
            return true;
        }
        
        if (key < set[mid]) {
            return binarySearchForExistenceOfElement(0, mid - 1, key);
        }
        
        return binarySearchForExistenceOfElement(mid + 1, right, key);
    }
}
