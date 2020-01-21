package scf.session5;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/*
 * JUnit test class for NQueensProblem class
 * Author Shivam Kumar Meena
 * created on 20th January, 2020
 */
@RunWith(Enclosed.class)
public class NQueensProblemTest {

    public static class NonParameterizedTests {
        private int[][] board;
        private int startRow;
        private int dimensionOfBoard;
        
        @Test(expected = AssertionError.class)
        public void testNQueen_WhenDimensionIsNegative() {
            dimensionOfBoard = -2;
            startRow = 0;
            board = new int[][]{
                                            {0, 0},
                                            {0, 0}
            };
            NQueensProblem.nQueen(board, startRow, dimensionOfBoard);
        }
        
        @Test(expected = AssertionError.class)
        public void testNQueen_WhenBoardSizeDoesntMatchDimensionOfBoard() {
            board = new int[][]{
                                            {0, 0, 0},
                                            {0, 0, 0},
                                            {0, 0, 0}
            };
            startRow = 0;
            dimensionOfBoard = 2;
            NQueensProblem.nQueen(board, startRow, dimensionOfBoard);
        }
        
        @Test(expected = AssertionError.class)
        public void testNQueen_WhenSomeElementsOfBoardAreNonZero() {
            board = new int[][]{
                                            {0, 1},
                                            {0, 0}
            };
            startRow = 0;
            dimensionOfBoard = 2;
            NQueensProblem.nQueen(board, startRow, dimensionOfBoard);
        }
        
        @Test(expected = AssertionError.class)
        public void testNQueen_WhenStartRowIsInvalid() {
            board = new int[][]{
                                            {0, 0, 0},
                                            {0, 0, 0},
                                            {0, 0, 0}
            };
            startRow = 3;
            dimensionOfBoard = 1;
            NQueensProblem.nQueen(board, startRow, dimensionOfBoard);
        }
        
        @Test(expected = AssertionError.class)
        public void testNQueen_WhenBoardHasInvalidStructure() {
            board = new int[][]{
                                            {0, 0},
                                            {0, 0, 0}
            };
            startRow = 0;
            dimensionOfBoard = 2;
            NQueensProblem.nQueen(board, startRow, dimensionOfBoard);
        }
    }

    @RunWith(Parameterized.class)
    public static class ParameterizedTests {
        
        private int[][] board;
        private int startRow;
        private int dimensionOfBoard;
        private boolean expectedOutput;
        private int[][] expectedBoard;

        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                    {
                        new int[][] {
                            {0}
                        },
                        0,
                        1,
                        true,
                        new int[][] {
                            {1}
                        }
                    },
                    {
                        new int[][] {
                            {0, 0},
                            {0, 0}
                        },
                        1,
                        2,
                        false,
                        new int[][] {
                            {0, 0},
                            {0, 0}
                        }
                    },
                    {
                        new int[][] {
                            {0, 0, 0},
                            {0, 0, 0},
                            {0, 0, 0}
                        },
                        0,
                        3,
                        false,
                        new int[][] {
                            {0, 0, 0},
                            {0, 0, 0},
                            {0, 0, 0}
                        }
                    },
                    {
                        new int[][] {
                            {0, 0, 0, 0},
                            {0, 0, 0, 0},
                            {0, 0, 0, 0},
                            {0, 0, 0, 0}
                        },
                        0,
                        4,
                        true,
                        new int[][] {
                            {0, 1, 0, 0},
                            {0, 0, 0, 1},
                            {1, 0, 0, 0},
                            {0, 0, 1, 0}
                        }
                    },
                    {
                        new int[][] {
                            {0, 0, 0, 0},
                            {0, 0, 0, 0},
                            {0, 0, 0, 0},
                            {0, 0, 0, 0}                            
                        },
                        1,
                        4,
                        true,
                        new int[][] {
                            {0, 0, 1, 0},
                            {1, 0, 0, 0},
                            {0, 0, 0, 1},
                            {0, 1, 0, 0}
                        }
                    },
                    {
                        new int[][] {
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                        },
                        0,
                        8,
                        true,
                        new int[][] {
                            {1, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 1},
                            {0, 0, 0, 0, 0, 1, 0, 0},
                            {0, 0, 1, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 1, 0},
                            {0, 1, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0},
                        }
                    }
            });
        }

        public ParameterizedTests(int[][] board, int startRow,
                int dimensionOfBoard, boolean expectedOutput,
                int[][] expectedBoard) {
            this.board = board;
            this.startRow = startRow;
            this.dimensionOfBoard = dimensionOfBoard;
            this.expectedOutput = expectedOutput;
            this.expectedBoard = expectedBoard;
        }
        
        @Test
        public void testNQueen() {
            boolean actualOutput = NQueensProblem.nQueen(board,
                                            startRow, dimensionOfBoard);
            assertEquals(expectedOutput, actualOutput);
            for (int i = 0; i < board.length; i++) {
                assertArrayEquals(expectedBoard[i], board[i]);
            }
        }
    }
}