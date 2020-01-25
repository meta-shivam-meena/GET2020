package scf.session7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * SparseMatrix represents a sparse matrix with representation of row, column
 * and value of non zero elements in 2D array.
 * @author Shivam Kumar Meena
 * created on 22nd January, 2020
 */
public final class SparseMatrix {
    /**
     * It stores the non-zero elements of a matrix along with their position.
     */
    private int[][] nonZeroElements;
    
    /**
     * It represents whether array is symmetric or not.
     * It is true if matrix is symmetric and false otherwise.
     */
    private boolean symmetric;
    
    /**
     * It represents the total rows of the original matrix.
     */
    private int totalRows;
    
    /**
     * It represents the total columns of the original matrix.
     */
    private int totalColumns;
    
    /**
     * private constructor used by methods to internally create new
     * SparseMatrix object.
     */
    private SparseMatrix() {}
    
    /**
     * Constructor to initialize sparse matrix.
     * @param input normal matrix representation.
     * @throws AssertionError when input is invalid for a matrix.
     */
    public SparseMatrix(int[][] input) throws IllegalArgumentException {
        int totalColumns;
        int countNonZeroElements;
        int nonZeroElementsIndex;
        
        if (input.length == 0) {
            this.nonZeroElements = new int[0][0];
            this.totalRows = 0;
            this.totalColumns = 0;
            return;
        }
        
        /*
         * counting non-zero elements.
         */
        totalColumns = input[0].length;
        countNonZeroElements = 0;
        for (int i = 0; i < input.length; i++) {
            
            if (input[i].length != totalColumns) {
                throw new IllegalArgumentException("Given matrix is not"
                                                + "rectangular");
            }
            
            for (int j = 0; j < input[i].length; j++) {        
                if (input[i][j] != 0) {
                    countNonZeroElements++;
                }
            }
        }
        
        nonZeroElements = new int[countNonZeroElements][3];
        this.totalRows = input.length;
        this.totalColumns = totalColumns;
        
        nonZeroElementsIndex = 0;
        // storing non-zero elements
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] != 0) {
                    nonZeroElements[nonZeroElementsIndex][0] = i;
                    nonZeroElements[nonZeroElementsIndex][1] = j;
                    nonZeroElements[nonZeroElementsIndex][2] = input[i][j];
                    nonZeroElementsIndex++;
                }
            }
        }
        
        setSymmetric();
    }
    
    /**
     * It returns the transpose of this SparseMatrix.
     * @return transpose of this SparseMatrix.
     */
    public SparseMatrix getTranspose() {
        SparseMatrix transpose = new SparseMatrix();
        transpose.nonZeroElements = new int[this.nonZeroElements.length][3];
        transpose.symmetric = symmetric;
        transpose.totalRows = this.totalColumns;
        transpose.totalColumns = this.totalRows;
        int[] temporaryArray;
        int minIndex;
        
        // storing non-zero values of this sparse matrix at corresponding
        // position in transpose sparse matrix, i.e. value at (row, column)
        // goes at (column, row).
        for (int i = 0; i < nonZeroElements.length; i++) {
            transpose.nonZeroElements[i][0] = nonZeroElements[i][1];
            transpose.nonZeroElements[i][1] = nonZeroElements[i][0];
            transpose.nonZeroElements[i][2] = nonZeroElements[i][2];
        }
        
        // sorting elements according to their position
        for (int i = 0; i < transpose.nonZeroElements.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < transpose.nonZeroElements.length; j++) {
                if (transpose.nonZeroElements[j][0]
                               < transpose.nonZeroElements[minIndex][0]
                    || (transpose.nonZeroElements[j][0]
                               == transpose.nonZeroElements[minIndex][0])
                        && transpose.nonZeroElements[j][1]
                               < transpose.nonZeroElements[minIndex][1]) {
                    minIndex = j;
                }
            }
            temporaryArray = transpose.nonZeroElements[i];
            transpose.nonZeroElements[i] = transpose.nonZeroElements[minIndex];
            transpose.nonZeroElements[minIndex] = temporaryArray;
        }
        
        return transpose;
    }
    
    /**
     * It returnns true if this matrix is symmetric and false otherwise.
     * @return true if this matrix is symmetric and false otherwise.
     */
    public boolean isSymmetric() {
        return symmetric;
    }
    
    /**
     * It is used to set the field symmetric.
     */
    private void setSymmetric() {
        
        if (totalRows != totalColumns) {
            symmetric = false;
        } else {
            
            outer: for (int i = 0; i < nonZeroElements.length; i++) {
                
                if (nonZeroElements[i][0] > nonZeroElements[i][1]) {
                    
                    for (int j = 0; j < i; j++) {
                        if (nonZeroElements[i][0] == nonZeroElements[j][0]
                            && nonZeroElements[i][1] == nonZeroElements[j][1]
                            && nonZeroElements[i][2] == nonZeroElements[j][2]) {
                            // symmetric element found
                            // continue checking symmetricity for next element.
                            continue outer;
                        }
                    }
                
                } else if (nonZeroElements[i][0] < nonZeroElements[i][1]) {
                    
                    for (int j = i + 1; j < nonZeroElements.length; j++) {
                        if (nonZeroElements[i][0] == nonZeroElements[j][0]
                            && nonZeroElements[i][1] == nonZeroElements[j][1]
                            && nonZeroElements[i][2] == nonZeroElements[j][2]) {
                            // symmetric element found
                            // continue checking symmetricity for next element.
                            continue outer;
                        }
                    }
                    
                } else {
                    continue outer;
                }
                
                // symmetric element not found.
                symmetric = false;
                break outer;
            }
            
            // symmetricity of all elements checked.
            symmetric = true;
        }
    }
    
    /**
     * It add two input sparse matrices and return resultant sparse matrix.
     * @param sparseMatrix1 first SparseMatrix
     * @param sparseMatrix2 second SparseMatrix
     * @return sum of input Sparse matrices.
     * @throws AssertionError if dimension of input sparse matrices are
     * different.
     */
    public SparseMatrix addSparseMatrix(SparseMatrix sparseMatrix1,
                                    SparseMatrix sparseMatrix2) 
                                    throws IllegalArgumentException {
        
        SparseMatrix result;
        Map<Integer, Map<Integer, Integer>> temporaryMap;
        
        if (sparseMatrix1.totalRows != sparseMatrix2.totalRows
                || sparseMatrix1.totalColumns != sparseMatrix2.totalColumns) {
            throw new IllegalArgumentException("Dimensions of input matrices"
                                            + " are not same");
        }
        
        // adding value of elements of first matrix in map at proper location.
        temporaryMap = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 0; i < sparseMatrix1.nonZeroElements.length; i++) {
            addInMap(sparseMatrix1.nonZeroElements[i][0],
                       sparseMatrix1.nonZeroElements[i][1],
                       sparseMatrix1.nonZeroElements[i][2],
                       temporaryMap);
        }
        
        // adding value of elements of second matrix in map at proper location.
        for (int i = 0; i < sparseMatrix2.nonZeroElements.length; i++) {
            addInMap(sparseMatrix2.nonZeroElements[i][0],
                       sparseMatrix2.nonZeroElements[i][1],
                       sparseMatrix2.nonZeroElements[i][2],
                       temporaryMap);
        }
        
        result = new SparseMatrix();
        result.totalRows = sparseMatrix1.totalRows;
        result.totalColumns = sparseMatrix1.totalColumns;
        result.nonZeroElements = getNonZeroEntries(temporaryMap);
        result.setSymmetric();
        
        return result;
    }
    
    
    
    
    /**
     * It multiplies two sparse matrices if multiplication is possible.
     * @param sparseMatrix1 first sparse matrix
     * @param sparseMatrix2 second sparse matrix
     * @return product of two sparse matrices
     * @throws AssertionError if columns of first sparse matrix is not same
     * as rows of second sparse matrix. 
     */
    public SparseMatrix multiplySparseMatrix(SparseMatrix sparseMatrix1,
                                    SparseMatrix sparseMatrix2)
                                    throws IllegalArgumentException {
        
        SparseMatrix result;
        int value;
        Map<Integer, Map<Integer, Integer>> temporaryMap;
        
        if (sparseMatrix1.totalColumns != sparseMatrix2.totalRows) {
            throw new IllegalArgumentException("Invalid dimensions. "
                                            + "Total columns of first matrix"
                                            + " should be equal to total rows"
                                            + " of second matrix");
        }
        
        // Element of first matrix can be multiplied with element of second
        // matrix only if column of first element is same as row of second
        // element and if they can be multiplied, their product is added to
        // value at location (row of first matrix, column of second matrix)
        temporaryMap = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 0; i < sparseMatrix1.nonZeroElements.length; i++) {
            for (int j = 0; j < sparseMatrix2.nonZeroElements.length; j++) {
                if (sparseMatrix1.nonZeroElements[i][1]
                           == sparseMatrix2.nonZeroElements[j][0]) {
                    value = sparseMatrix1.nonZeroElements[i][2]
                                   * sparseMatrix2.nonZeroElements[j][2];
                    addInMap(sparseMatrix1.nonZeroElements[i][0],
                             sparseMatrix2.nonZeroElements[j][1],
                             value, temporaryMap);
                }
            }
        }
        
        result = new SparseMatrix();
        result.totalRows = sparseMatrix1.totalRows;
        result.totalColumns = sparseMatrix2.totalColumns;
        result.nonZeroElements = getNonZeroEntries(temporaryMap);
        result.setSymmetric();
        
        return result;
    }
    
    /**
     * It checks for the equality of input sparse matrix with this sparse matrix
     * @param sparseMatrix second sparse matrix, first is this.
     * @return true if input sparse matrix is same as this and false
     * otherwise.
     */
    public boolean equals(SparseMatrix sparseMatrix) {
        if (sparseMatrix.totalRows != this.totalRows
                   || sparseMatrix.totalColumns != this.totalColumns) {
            return false;
        }
        
        for (int i = 0; i < nonZeroElements.length; i++) {
            if (nonZeroElements[i][0] != sparseMatrix.nonZeroElements[i][0]
                    || nonZeroElements[i][1] != sparseMatrix.nonZeroElements[i][1]
                    || nonZeroElements[i][2] != sparseMatrix.nonZeroElements[i][2]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * It displays the content of sparse matrix.
     */
    public void displaySparseMatrix() {
        System.out.println("Total Rows: " + totalRows);
        System.out.println("Total Columns: " + totalColumns);
        System.out.println("Total non-zero elements: " + nonZeroElements.length);
        for (int i = 0; i < nonZeroElements.length; i++) {
            System.out.println(nonZeroElements[i][0] + " "
                               + nonZeroElements[i][1] + " "
                               + nonZeroElements[i][2]);
        }
        System.out.println();
    }

    /**
     * This methods is used to add an entry of sparse matrix in a temporary
     * map for computation. On 24th January, 2020, this methods is used by
     * addSparseMatrix() and multiplySparseMatrix(). 
     * @param row row of element
     * @param column column of element
     * @param value value to be added at location(row, column)
     * @param map map in which entry is added.
     */
    private void addInMap(int row, int column, int value,
                                    Map<Integer, Map<Integer, Integer>> map) {
        Map<Integer, Integer> internalMap;
        
        if (map.containsKey(row)) {
            internalMap = map.get(row);
            if (internalMap.containsKey(column)) {
                internalMap.put(column, internalMap.get(column) + value);
            } else {
                internalMap.put(column, value);
            }
            
        } else {
            internalMap = new HashMap<Integer, Integer>();
            internalMap.put(column, value);
            map.put(row, internalMap);
        }
    }
    
    /**
     * This methods is used to extract non zero entries in map to a 2D array
     * which represents entries of a sparse matrix.
     * @param map map from which non-zero entries are extracted.
     * @return 2D array of non-zero entries, sorted according to (row, column)
     * of an entry.
     */
    private int[][] getNonZeroEntries(Map<Integer, Map<Integer, Integer>> map) {
        
        int totalNonZeroElements;
        int[][] result;
        int resultIndex;
        Integer[] rowKeys;
        Integer[] columnKeys;
        Map<Integer, Integer> internalMap;
        
        // removing zero entries and counting non-zero entries.
        totalNonZeroElements = 0;
        rowKeys = new Integer[map.size()];
        map.keySet().toArray(rowKeys);
        for (int i = 0; i < rowKeys.length; i++) {
            internalMap = map.get(rowKeys[i]);
            columnKeys = new Integer[internalMap.size()];
            internalMap.keySet().toArray(columnKeys);
            
            for (int j = 0; j < columnKeys.length; j++) {
                if (internalMap.get(columnKeys[j]) == 0) {
                    internalMap.remove(columnKeys[j]);
                } else {
                    totalNonZeroElements++;
                }
            }
        }
        
        // adding non-zero entries to result array
        resultIndex = 0;
        result = new int[totalNonZeroElements][3];
        rowKeys = new Integer[map.size()];
        map.keySet().toArray(rowKeys);
        Arrays.sort(rowKeys);
        for (int i = 0; i < rowKeys.length; i++) {
            internalMap = map.get(rowKeys[i]);
            internalMap = map.get(rowKeys[i]);
            columnKeys = new Integer[internalMap.size()];
            internalMap.keySet().toArray(columnKeys);
            Arrays.sort(columnKeys);
            
            for (int j = 0; j < columnKeys.length; j++) {
                result[resultIndex][0] = rowKeys[i];
                result[resultIndex][1] = columnKeys[j];
                result[resultIndex][2] = internalMap.get(columnKeys[j]);
                resultIndex++;
            }
        }
        
        return result;
    }
    
}
