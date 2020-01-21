package scf.session5;

/**
 * It contains method for finding solution to famous n queens problem
 * @author Shivam Kumar Meena
 * created on 20th January, 2020
 */
public class NQueensProblem {
    
    /**
     * It returns true if queens can be placed successfully according
     * to problem definition, and false otherwise.
     * It also changes board to reflect position of queens, 1 represents
     * presence of queen at at that position.
     * @param board chess board to play upon.
     * @param startRow starting row for finding solution using backtracking.
     * @param dimensionOfBoard dimension of chessboard.
     * @return true if queens n queens can be placed successfully according to
     * problem definition
     * @throws AssertionError if inputs are invalid
     */
    public static boolean nQueen(int[][] board, int startRow,
                int dimensionOfBoard) throws AssertionError {
        if (dimensionOfBoard <= 0 || board == null || startRow < 0
                || startRow >= board.length
                || board.length != dimensionOfBoard) {
            throw new AssertionError();
        }
        
        for (int i = 0; i < board.length; i++) {
            if (board[i].length != dimensionOfBoard) {
                throw new AssertionError();
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    throw new AssertionError();
                }
            }
        }
        
        return nQueenHelper(board, startRow, dimensionOfBoard);
    }
    
    private static boolean nQueenHelper(int[][] board, int startRow,
                                    int rowsToFill) {
        if (rowsToFill == 0) {
            return true;
        }
        
        for (int col = 0; col < board[startRow].length; col++) 
        {
            if (isSafe(board, startRow, col)) 
            {
                board[startRow][col] = 1;
                if (nQueenHelper(board, (startRow + 1) % board.length,
                                                rowsToFill - 1)) 
                {
                    return true;
                }
                board[startRow][col] = 0;
            }
        }
        
        return false;
    }
    
    private static boolean isSafe(int[][] board, int row, int col) {
        
        // checking for other queens on left of element.
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 1) {
                return false;
            }
        }
        
        // checking for other queens on right of element.
        for (int j = col + 1; j < board[row].length; j++) {
            if (board[row][j] == 1) {
                return false;
            }
        }
        
        // checking for other queens above element.
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        
        // checking for other queens below element.
        for (int i = row + 1; i < board.length; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        
        // checking for other queens in upper left diagonal.
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // checking for other queens in lower right diagonal.
        for (int i = row + 1, j = col + 1; i < board.length &&
                                        j < board[i].length; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // checking for other queens in upper right diagonal.
        for (int i = row - 1, j = col + 1; i >= 0 &&
                                        j < board[i].length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // checking for other queens in lower left diagonal.
        for (int i = row + 1, j = col - 1; i < board.length &&
                                        j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
}
