package scf.session7;

/**
 * SparseMatrix represents a sparse matrix with representation of row, column
 * and value of non zero elements in 2D array.
 * @author Shivam Kumar Meena
 * created on 22nd January, 2020
 */
public final class SparseMatrix {
    /**
     * It stores dimension and number of non-zero elements in first row.
     * It also stores the non-zero elements along with their position.
     */
    private int[][] matrix;
    
    /**
     * It represents whether array is symmetric or not.
     */
    private boolean symmetric;
    
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
    public SparseMatrix(int[][] input) throws AssertionError {
        int totalColumns;
        int countNonZeroElements;
        int matrixIndex;
        
        if (input.length == 0) {
            matrix = new int[1][3];
            return;
        }
        
        /*
         * counting non-zero elements.
         */
        totalColumns = input[0].length;
        countNonZeroElements = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].length != totalColumns) {
                throw new AssertionError();
            }
            
            for (int j = 0; j < input[i].length; j++) {        
                if (input[i][j] != 0) {
                    countNonZeroElements++;
                }
            }
        }
        
        matrix = new int[countNonZeroElements + 1][3];
        matrix[0][0] = input.length; // storing total rows
        matrix[0][1] = totalColumns; // storing total columns
        matrix[0][2] = countNonZeroElements; // storing total non-zero elements.
        matrixIndex = 1;
        // storing non-zero elements
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] != 0) {
                    this.matrix[matrixIndex][0] = i;
                    this.matrix[matrixIndex][1] = j;
                    this.matrix[matrixIndex][2] = input[i][j];
                    matrixIndex++;
                }
            }
        }
        
        // setting whether given input matrix is symmetric or not.
        if (matrix[0][0] != matrix[0][1]) {
            symmetric = false;
        } else {
            outer: for (int i = 1; i < matrix.length; i++) {
                
                if (matrix[i][0] > matrix[i][1]) {
                    
                    for (int j = 1; j < i; j++) {
                        if (matrix[i][0] == matrix[j][0]
                                && matrix[i][1] == matrix[j][1]
                                && matrix[i][2] == matrix[j][2]) {
                            continue outer;
                        }
                    }
                    symmetric = false;
                    break outer;
                    
                } else if (matrix[i][0] < matrix[i][1]) {
                    
                    for (int j = i + 1; j < matrix.length; j++) {
                        if (matrix[i][0] == matrix[j][0]
                                && matrix[i][1] == matrix[j][1]
                                && matrix[i][2] == matrix[j][2]) {
                            continue outer;
                        }
                    }
                    symmetric = false;
                    break outer;
                    
                } else {
                    continue outer;
                }
            }
            symmetric = true;
        }
    }
    
    /**
     * It returns the transpose of this SparseMatrix.
     * @return transpose of this SparseMatrix.
     */
    public SparseMatrix getTranspose() {
        SparseMatrix transpose = new SparseMatrix();
        transpose.matrix = new int[matrix.length][3];
        transpose.symmetric = symmetric;
        int[] temporaryArray;
        int minIndex;
        
        // swapping rows and columns
        for (int i = 0; i < matrix.length; i++) {
            transpose.matrix[i][0] = matrix[i][1];
            transpose.matrix[i][1] = matrix[i][0];
            transpose.matrix[i][2] = matrix[i][2];
        }
        
        // sorting elements according to their position
        for (int i = 1; i < transpose.matrix.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < transpose.matrix.length; j++) {
                if (transpose.matrix[j][0] < transpose.matrix[minIndex][0]
                    || (transpose.matrix[j][0]
                               == transpose.matrix[minIndex][0])
                        && transpose.matrix[j][1]
                               < transpose.matrix[minIndex][1]) {
                    minIndex = j;
                }
            }
            temporaryArray = transpose.matrix[i];
            transpose.matrix[i] = transpose.matrix[minIndex];
            transpose.matrix[minIndex] = temporaryArray;
        }
        
        return transpose;
    }
    
    /**
     * It returns true is matrix is symmetric and false otherwise.
     * @return true if matrix is symmetric and false otherwise.
     */
    public boolean isSymmetric() {
        return symmetric;
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
                                    throws AssertionError {
        
        SparseMatrix result;
        int countCommonPositions;
        int countNonZeroElementsOfResult;
        int indexSparseMatrix1;
        int indexSparseMatrix2;
        int indexResult;
        
        if (sparseMatrix1.matrix[0][0] != sparseMatrix2.matrix[0][0]
                || sparseMatrix1.matrix[0][1] != sparseMatrix2.matrix[0][1]) {
            throw new AssertionError();
        }
        
        // counting common positions of non-zero elements
        countCommonPositions = 0;
        for (int i = 1; i < sparseMatrix1.matrix.length; i++) {
            if(isMember(sparseMatrix1.matrix[i][0],
                        sparseMatrix1.matrix[i][1],
                        sparseMatrix2)) {
                countCommonPositions++;
            }
        }
        
        result = new SparseMatrix();
        countNonZeroElementsOfResult = sparseMatrix1.matrix[0][2]
                                       + sparseMatrix2.matrix[0][2]
                                       - countCommonPositions;
        result.matrix = new int[countNonZeroElementsOfResult + 1][3];
        // setting rows of result sparse matrix
        result.matrix[0][0] = sparseMatrix1.matrix[0][0];
        // setting columns of result sparse matrix
        result.matrix[0][1] = sparseMatrix2.matrix[0][1];
        // setting total non-zero elements of result sparse matrix
        result.matrix[0][2] = countNonZeroElementsOfResult;
        indexSparseMatrix1 = 1;
        indexSparseMatrix2 = 1;
        indexResult = 1;
        // adding input matrices
        while (indexSparseMatrix1 < sparseMatrix1.matrix.length
                      && indexSparseMatrix2 < sparseMatrix2.matrix.length) {
            if (sparseMatrix1.matrix[indexSparseMatrix1][0]
                    < sparseMatrix2.matrix[indexSparseMatrix2][0]) {
                
                result.matrix[indexResult][0] =
                        sparseMatrix1.matrix[indexSparseMatrix1][0];
                result.matrix[indexResult][1] =
                        sparseMatrix1.matrix[indexSparseMatrix1][1];
                result.matrix[indexResult][2] =
                        sparseMatrix1.matrix[indexSparseMatrix1][2];
                indexSparseMatrix1++;
                
            } else if (sparseMatrix1.matrix[indexSparseMatrix1][0]
                              == sparseMatrix2.matrix[indexSparseMatrix2][0]) {
                
                if (sparseMatrix1.matrix[indexSparseMatrix1][1]
                        < sparseMatrix2.matrix[indexSparseMatrix2][1]) {
                    
                    result.matrix[indexResult][0] =
                            sparseMatrix1.matrix[indexSparseMatrix1][0];
                    result.matrix[indexResult][1] =
                            sparseMatrix1.matrix[indexSparseMatrix1][1];
                    result.matrix[indexResult][2] =
                            sparseMatrix1.matrix[indexSparseMatrix1][2];
                    indexSparseMatrix1++;
                    
                } else if (sparseMatrix1.matrix[indexSparseMatrix1][1]
                        == sparseMatrix2.matrix[indexSparseMatrix2][1]) {
                    
                    result.matrix[indexResult][0] =
                            sparseMatrix1.matrix[indexSparseMatrix1][0];
                    result.matrix[indexResult][1] =
                            sparseMatrix1.matrix[indexSparseMatrix1][1];
                    result.matrix[indexResult][2] = 
                            sparseMatrix1.matrix[indexSparseMatrix1][2]
                            + sparseMatrix2.matrix[indexSparseMatrix2][2];
                    indexSparseMatrix1++;
                    indexSparseMatrix2++;
                    
                    
                } else {
                    
                    result.matrix[indexResult][0] =
                            sparseMatrix2.matrix[indexSparseMatrix2][0];
                    result.matrix[indexResult][1] =
                            sparseMatrix2.matrix[indexSparseMatrix2][1];
                    result.matrix[indexResult][2] =
                            sparseMatrix2.matrix[indexSparseMatrix2][2];
                    indexSparseMatrix2++;
                    
                }
                
            } else {
                
                result.matrix[indexResult][0] =
                        sparseMatrix2.matrix[indexSparseMatrix2][0];
                result.matrix[indexResult][1] =
                        sparseMatrix2.matrix[indexSparseMatrix2][1];
                result.matrix[indexResult][2] =
                        sparseMatrix2.matrix[indexSparseMatrix2][2];
                indexSparseMatrix2++;
            }
            
            indexResult++;
        }
        
        // adding remaining elements of first sparse matrix
        while (indexSparseMatrix1 < sparseMatrix1.matrix.length) {
            result.matrix[indexResult][0] =
                    sparseMatrix1.matrix[indexSparseMatrix1][0];
            result.matrix[indexResult][1] =
                    sparseMatrix1.matrix[indexSparseMatrix1][1];
            result.matrix[indexResult][2] =
                    sparseMatrix1.matrix[indexSparseMatrix1][2];
            indexSparseMatrix1++;
            indexResult++;
        }
        
        // adding remaining elements of second sparse matrix
        while (indexSparseMatrix2 < sparseMatrix2.matrix.length) {
            result.matrix[indexResult][0] =
                    sparseMatrix2.matrix[indexSparseMatrix2][0];
            result.matrix[indexResult][1] =
                    sparseMatrix2.matrix[indexSparseMatrix2][1];
            result.matrix[indexResult][2] =
                    sparseMatrix2.matrix[indexSparseMatrix2][2];
            indexSparseMatrix2++;
            indexResult++;
        }
        
        return result;
    }
    
    /**
     * It is helper method to check whether given position is present
     * in input sparse matrix or not
     * @param row row of position
     * @param column column of position
     * @param sparseMatrix sparse matrix to search
     * @return true if given position is present in sparse matrix.
     */
    private boolean isMember(int row, int column,
                             SparseMatrix sparseMatrix) {
        for (int i = 1; i < sparseMatrix.matrix.length; i++) {
            if (sparseMatrix.matrix[i][0] == row
                       && sparseMatrix.matrix[i][1] == column) {
                return true;
            }
        }
        
        return false;
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
                                    throws AssertionError {
        if (sparseMatrix1.matrix[0][1] != sparseMatrix2.matrix[0][0]) {
            throw new AssertionError();
        }
        
        return null;
    }
    
    /**
     * It checks for the equality of input sparse matrix with this sparse matrix
     * @param sparseMatrix second sparse matrix, first is this.
     * @return true if input sparse matrix is same as this and false
     * otherwise.
     */
    public boolean equals(SparseMatrix sparseMatrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] != sparseMatrix.matrix[i][0]
                    || matrix[i][1] != sparseMatrix.matrix[i][1]
                    || matrix[i][2] != sparseMatrix.matrix[i][2]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * It displays the content of sparse matrix.
     */
    public void displaySparseMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][0] + " " + matrix[i][1] + " "
                               + matrix[i][2]);
        }
        System.out.println();
    }
}
