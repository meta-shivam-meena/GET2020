package scf.session4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/*
 * JUnit test class for ArrOperation class
 * Author Shivam Kumar Meena
 * created on 17th January, 2020
 */
@RunWith(Enclosed.class)
public class ArrOperationTest {

    public static class NonParameterizedTestsForAllMethods {

        @Test(expected = AssertionError.class)
        public void testMaxMirror_WhenArrayLengthIsZero() {
            int[] emptyArray = new int[0];
            ArrOperation.maxMirror(emptyArray);
        }

        @Test(expected = AssertionError.class)
        public void testCountClumps_WhenArrayLengthIsZero() {
            int[] emptyArray = new int[0];
            ArrOperation.maxMirror(emptyArray);
        }

        @Test(expected = AssertionError.class)
        public void testFixXY_WhenArrayLengthIsZero() {
            int[] emptyArray = new int[0];
            // array length must be zero but other input conditions
            // must be valid for proper testing.
            int x = 0; // The actual value doesn't matter for this test case.
            int y = 1; // The actual value doesn't matter for this test case.
            ArrOperation.fixXY(emptyArray, x, y);
        }

        @Test(expected = AssertionError.class)
        public void testFixXY_WhenUnequalNumberOfXAndY() {
            // array must have unequal number of x and y but other input
            // conditions must be valid for proper testing.
            int[] arrayWithUnequlXAndY = { 0, 2, 0, 1 };
            int x = 0;
            int y = 1;
            ArrOperation.fixXY(arrayWithUnequlXAndY, x, y);
        }

        @Test(expected = AssertionError.class)
        public void testFixXY_WhenTwoAdjacentXArePresent() {
            // array must have adjacent x but other input conditions
            // must be valid for proper testing.
            int[] arrayWithAdjacentX = { 0, 0, 1, 1 };
            int x = 0;
            int y = 0;
            ArrOperation.fixXY(arrayWithAdjacentX, x, y);
        }

        @Test(expected = AssertionError.class)
        public void testFixXY_WhenXOccursAtLastIndex() {
            // array must have x at last index but other input conditions
            // must be valid for proper testing.
            int[] arrayWithXAtLastIndex = { 0, 1, 1, 0 };
            int x = 0;
            int y = 0;
            ArrOperation.fixXY(arrayWithXAtLastIndex, x, y);
        }

        @Test(expected = AssertionError.class)
        public void testFixXY_WhenXAndYAreEqual() {
            // array must have x and y with same value but other input
            // conditions must be valid for proper testing.
            int[] arrayWithEqualXAndY = { 0, 1, 0, 1 };
            int x = 0;
            int y = 0;
            ArrOperation.fixXY(arrayWithEqualXAndY, x, y);
        }

        @Test(expected = AssertionError.class)
        public void testSplitArray_WhenArrayLengthIsZero() {
            int[] emptyArray = new int[0];
            ArrOperation.splitArray(emptyArray);
        }
    }

    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForMaxMirror {

        private int[] numbers;
        private int expectedOutput;

        @Parameterized.Parameters
        public static Collection input() {
            return Arrays.asList(new Object[][]{
                    {new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3},
                    {new int[]{7, 1, 4, 9, 7, 4, 1}, 2},
                    {new int[]{1, 2, 1, 4}, 3},
                    {new int[]{1, 4, 5, 3, 5, 4, 1}, 7}
            });
        }

        public ParameterizedTestsForMaxMirror(int[] numbers,
                                        int expectedOutput) {
            this.numbers = numbers;
            this.expectedOutput = expectedOutput;
        }

        @Test
        public void testMaxMirror() {
            int actualOutput = ArrOperation.maxMirror(numbers);
            assertEquals(expectedOutput, actualOutput);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForCountClumps {
        private int[] numbers;
        private int expectedOutput;
        
        @Parameterized.Parameters
        public static Collection input() {
            return Arrays.asList(new Object[][]{
                    {new int[]{1, 2, 2, 3, 4, 4}, 2},
                    {new int[]{1, 1, 2, 1, 1}, 2},
                    {new int[]{1, 1, 1, 1, 1}, 1}
            });
        }
        
        public ParameterizedTestsForCountClumps(int[] numbers,
                                        int expectedOutput) {
            this.numbers = numbers;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testCountClumps() {
            int actualOutput = ArrOperation.countClumps(numbers);
            assertEquals(expectedOutput, actualOutput);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForFixXY {
        private int[] numbers;
        int x;
        int y;
        private int[] expectedOutput;
        
        @Parameterized.Parameters
        public static Collection input() {
            return Arrays.asList(new Object[][]{
                    {
                        new int[]{5, 4, 9, 4, 9, 5}, 4, 5,
                        new int[]{9, 4, 5, 4, 5, 9}
                    },
                    {
                        new int[]{1, 4, 1, 5}, 4, 5,
                        new int[]{1, 4, 5, 1}
                    },
                    {
                        new int[]{1, 4, 1, 5, 5, 4, 1}, 4, 5,
                        new int[]{1, 4, 5, 1, 1, 4, 5}
                    },
            });
        }
        
        public ParameterizedTestsForFixXY(int[] numbers,
                                        int x, int y,
                                        int[] expectedOutput) {
            this.numbers = numbers;
            this.x = x;
            this.y = y;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testFixXY() {
            int[] actualOutput = ArrOperation.fixXY(numbers, x, y);
            assertArrayEquals(expectedOutput, actualOutput);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForSplitArray {
        private int[] numbers;
        private int expectedOutput;
        
        @Parameterized.Parameters
        public static Collection input() {
            return Arrays.asList(new Object[][]{
                    {new int[]{1, 1, 1, 2, 1}, 3},
                    {new int[]{2, 1, 1, 2, 1}, -1},
                    {new int[]{10, 10}, 1}
            });
        }
        
        public ParameterizedTestsForSplitArray(int[] numbers,
                                        int expectedOutput) {
            this.numbers = numbers;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testCountClumps() {
            int actualOutput = ArrOperation.splitArray(numbers);
            assertEquals(expectedOutput, actualOutput);
        }
    }
}