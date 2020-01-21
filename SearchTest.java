package scf.session5;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


/*
 * JUnit test class for Search class
 * Author Shivam Kumar Meena
 * created on 20th January, 2020
 */
@RunWith(Enclosed.class)
public class SearchTest {
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForLinearSearch {
        private int[] numbers;
        private int key;
        private int expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                                            {new int[]{1, 5, 0, 3}, 1, 0},
                                            {new int[]{1, 5, 0, 3}, 5, 1},
                                            {new int[]{1, 5, 0, 3}, 0, 2},
                                            {new int[]{1, 5, 0, 3}, 3, 3},
                                            {new int[]{1, 5, 0, 3}, 2, -1},
            });
        }
        
        public ParameterizedTestsForLinearSearch(int[] numbers,
                                        int key, int expectedOutput) {
            this.numbers = numbers;
            this.key = key;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testLinearSearch() {
            int actualOutput = Search.linearSearch(numbers, key);
            assertEquals(expectedOutput, actualOutput);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForBinarySearch {
        private int[] numbers;
        private int key;
        private int expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object [][]{
                                            {new int[]{5, 6, 9, 11}, 9, 2},
                                            {new int[]{0, 1, 2, 3, 4}, 2, 2},
                                            {new int[]{0, 1, 2, 3, 4}, 4, 4},
                                            {new int[]{0, 2, 2, 3, 4}, 5, -1}
            });
        }
        
        public ParameterizedTestsForBinarySearch(int[] numbers,
                                        int key, int expectedOutput) {
            this.numbers = numbers;
            this.key = key;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testBinarySearch() {
            int actualOutput = Search.binarySearch(numbers, key);
            assertEquals(expectedOutput, actualOutput);
        }
    }
}
