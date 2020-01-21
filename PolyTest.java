package scf.session6;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Enclosed.class)
public class PolyTest {
    
    /*
    public static class NonParameterizedTestsForAllMethods {
        
    }*/

    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForEvaluate {
        double maxDifferenceForTwoDoublesToBeEqual = 0.000001;
        Poly poly;
        float x;
        double expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                                            {
                                                new Poly(new int[][]{
                                                                                {2, 2}, {3, 0}
                                                }),
                                                1,
                                                5
                                            },
                                            {
                                                new Poly(new int[][]{
                                                                                {2, 2}, {3, 2}
                                                }),
                                                2,
                                                160
                                            },
                                            {
                                                new Poly(new int[][]{
                                                                                {3, 0}, {5, 1}, {1, 3}
                                                }),
                                                5.5f,
                                                196.875
                                            },
                                            {
                                                new Poly(new int[][]{
                                                                                {0, 1}, {2, 2}
                                                }),
                                                3,
                                                18
                                            }
            });
        }
        
        public ParameterizedTestsForEvaluate(Poly poly, float x,
                                        double expectedOutput) {
            this.poly = poly;
            this.x = x;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testEvaluate() {
            double actualOutput = poly.evaluate(x);
            double difference = actualOutput - expectedOutput;
            boolean isDifferenceSmallEnough = Math.abs(difference)
                                            <= maxDifferenceForTwoDoublesToBeEqual;
            assert(isDifferenceSmallEnough);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForDegree {
        Poly poly;
        int expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                                            {
                                                new Poly(new int[][]{
                                                                                {1, 2}, {2, 2}
                                                }),
                                                2
                                            },
                                            {
                                                new Poly(new int[][]{
                                                                                
                                                }),
                                                0
                                            },
                                            {
                                                new Poly(new int[][]{
                                                                                {1, 3}, {2, 5}
                                                }),
                                                5
                                            }
            });
        }
        
        public ParameterizedTestsForDegree(Poly poly, int expectedOutput) {
            this.poly = poly;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testDegree() {
            int actualOutput = poly.degree();
            assertEquals(expectedOutput, actualOutput);
        }
    }
    
    /*
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForAddPoly {
        Poly poly1;
        Poly poly2;
        Poly expectedPoly;
        int[] inputForEvaluateMethod;
        int[] expectedOutputForEvaluateMethod;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                                            {
                                                new Poly(new int[][]{
                                                                                {1, 3}, {2, 2}
                                                }),
                                                new Poly(new int[][]{
                                                                                {2, 3}, {1, 1}
                                                }),
                                                new Poly(new int[][]{
                                                                                {3, 3}, {1, 1}, {2, 2}
                                                })
                                            },
                                            {
                                                new Poly(new int[][]{
                                                                                {3, 0}, {1, 1}
                                                }),
                                                new Poly(new int[][]{
                                                                                {8, 3}, {2, 2}
                                                }),
                                                new Poly(new int[][]{
                                                                                {3, 0}, {1, 1}, {8, 3}, {2, 2}
                                                })
                                            }
            });
        }
        
        public ParameterizedTestsForAddPoly(Poly poly1, Poly poly2,
                                        Poly expectedPoly) {
            this.poly1 = poly1;
            this.poly2 = poly2;
            this.expectedPoly = expectedPoly;
        }
        
        @Test
        public void testAddPoly() {
            
        }
    }*/
}