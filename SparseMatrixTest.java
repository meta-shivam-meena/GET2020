package scf.session7;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Enclosed.class)
public class SparseMatrixTest {
    
    public static class NonParameterizedTestsForAllMethods {
        
        @Test(expected = AssertionError.class)
        public void testAddSparseMatrixWhenInputIsInvalid() {
            SparseMatrix sparseMatrix1 = new SparseMatrix(new int[][] {
                                            {1, 1}
            });
            SparseMatrix sparseMatrix2 = new SparseMatrix(new int[][] {
                                            {1, 1, 1}
            });
            sparseMatrix1.addSparseMatrix(sparseMatrix1, sparseMatrix2);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForGetTranspose {
        SparseMatrix sparseMatrix;
        SparseMatrix expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][] {
                    {
                        new SparseMatrix(new int[][] {
                                {1, 0, 0, 0},
                                {0, 2, 0, 1},
                                {0, 0, 0, 0},
                                {3, 0, 0, 0},
                                {5, 0, 0, 0}
                        }),
                        new SparseMatrix(new int[][] {
                                {1, 0, 0, 3, 5},
                                {0, 2, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 1, 0, 0, 0}
                        })
                    },
                    {
                        new SparseMatrix(new int[][] {
                                {1, 0, 2, 3},
                                {0, 0, 1, 2},
                                {0, 0, 0, 0},
                                {4, 1, 2, 0}
                        }),
                        new SparseMatrix(new int[][] {
                                {1, 0, 0, 4},
                                {0, 0, 0, 1},
                                {2, 1, 0, 2},
                                {3, 2, 0, 0}
                        })
                    }
            });
        }
        
        public ParameterizedTestsForGetTranspose(SparseMatrix sparseMatrix,
                                        SparseMatrix expectedOutput) {
            this.sparseMatrix = sparseMatrix;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testGetTranspose() {
            SparseMatrix actualOutput = sparseMatrix.getTranspose();
            boolean areEqual = expectedOutput.equals(actualOutput);
            assertTrue(areEqual);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForIsSymmetric {
        SparseMatrix sparseMatrix;
        boolean expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][] {
                           {
                               new SparseMatrix(new int[][] {
                                       {1, 0, 0},
                                       {0, 1, 1},
                                       {0, 0, 1}
                               }),
                               true
                           },
                           {
                               new SparseMatrix(new int[][] {
                                       {1, 1, 0, 0},
                                       {0, 0, 0, 0}
                               }),
                               false
                           },
                           {
                               new SparseMatrix(new int[][] {
                                       {0, 0, 1},
                                       {0, 1, 0},
                                       {1, 0, 0}
                               }),
                               true
                           }
            });
        }
        
        public ParameterizedTestsForIsSymmetric(SparseMatrix sparseMatrix,
                                        boolean expectedOutput) {
            this.sparseMatrix = sparseMatrix;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testIsSymmetric() {
            boolean actualOutput = sparseMatrix.isSymmetric();
            assertEquals(expectedOutput, actualOutput);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForAddSparseMatrix {
        SparseMatrix sparseMatrix1;
        SparseMatrix sparseMatrix2;
        SparseMatrix expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][] {
                    {
                        new SparseMatrix(new int[][] {
                                {1, 0, 0, 0},
                                {0, 0, 0, 0},
                                {1, 0, 1, 0}
                        }),
                        new SparseMatrix(new int[][] {
                                {2, 0, 1, 0},
                                {0, 0, 5, 0},
                                {0, 0, 1, 0}
                        }),
                        new SparseMatrix(new int[][] {
                                {3, 0, 1, 0},
                                {0, 0, 5, 0},
                                {1, 0, 2, 0}
                        })
                    },
                    {
                        new SparseMatrix(new int[][] {
                                {1, 1, 1, 1},
                                {0, 0, 0, 0}
                        }),
                        new SparseMatrix(new int[][] {
                                {1, 2, 3, 4},
                                {1, 1, 1, 1}
                        }) ,
                        new SparseMatrix(new int[][] {
                                {2, 3, 4, 5},
                                {1, 1, 1, 1}
                        })
                    }
            });
        }
        
        public ParameterizedTestsForAddSparseMatrix(SparseMatrix sparseMatrix1,
                                        SparseMatrix sparseMatrix2,
                                        SparseMatrix expectedOutput) {
            this.sparseMatrix1 = sparseMatrix1;
            this.sparseMatrix2 = sparseMatrix2;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testAddSparseMatrix() {
            SparseMatrix actualOutput =
                    sparseMatrix1.addSparseMatrix(sparseMatrix1, sparseMatrix2);
            boolean areEqual = expectedOutput.equals(actualOutput);
            assertTrue(areEqual);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForMultiplySparseMatrix {
        SparseMatrix sparseMatrix1;
        SparseMatrix sparseMatrix2;
        SparseMatrix expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][] {
                                            
            });
        }
        
        public ParameterizedTestsForMultiplySparseMatrix(
                                        SparseMatrix sparseMatrix1,
                                        SparseMatrix sparseMatrix2,
                                        SparseMatrix expectedOutput) {
            this.sparseMatrix1 = sparseMatrix1;
            this.sparseMatrix2 = sparseMatrix2;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testMultiplySparseMatrix() {
            SparseMatrix actualOutput =
                    sparseMatrix1.multiplySparseMatrix(sparseMatrix1,
                                                    sparseMatrix2);
            boolean areEqual = expectedOutput.equals(actualOutput);
            assertTrue(areEqual);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForEquals {
        SparseMatrix sparseMatrix1;
        SparseMatrix sparseMatrix2;
        boolean expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][] {
                    /*{
                        new SparseMatrix(new int[][] {
                                {1, 0, 0},
                                {0, 0, 0}
                        }),
                        new SparseMatrix(new int[][] {
                                {1, 0, 0},
                                {0, 0, 0}
                        }),
                        true
                    },*/
                    {
                        new SparseMatrix(new int[][] {
                                {1, 0},
                                {0, 1}
                        }),
                        new SparseMatrix(new int[][] {
                                {0, 0},
                                {0, 1}
                        }),
                        false
                    }
            });
        }
        
        public ParameterizedTestsForEquals(SparseMatrix sparseMatrix1,
                                        SparseMatrix sparseMatrix2,
                                        boolean expectedOutput) {
            this.sparseMatrix1 = sparseMatrix1;
            this.sparseMatrix2 = sparseMatrix2;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testEquals() {
            boolean actualOutput = sparseMatrix1.equals(sparseMatrix2);
            assertEquals(expectedOutput, actualOutput);
        }
    }
}
