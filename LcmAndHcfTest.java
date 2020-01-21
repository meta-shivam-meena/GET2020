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
public class LcmAndHcfTest {
    
    public static class NonParameterizedTests {
        private int x;
        private int y;
        
        @Test(expected = AssertionError.class)
        public void testLcm_WhenOneOfTheInputIsZero() {
            x = 0;
            y = 5;
            LcmAndHcf.lcm(x, y);
        }
        
        @Test(expected = AssertionError.class)
        public void testLcm_FirstInputIsNegative() {
            x = -2;
            y = 5;
            LcmAndHcf.lcm(x, y);
        }
        
        @Test(expected = AssertionError.class)
        public void testLcm_SecondInputIsNegative() {
            x = 2;
            y = -5;
            LcmAndHcf.lcm(x, y);
        }
        
        @Test(expected = AssertionError.class)
        public void testLcm_WhenBothInputsAreNegative() {
            x = -6;
            y = -9;
            LcmAndHcf.lcm(x, y);
        }
        
        @Test(expected = AssertionError.class)
        public void testHcf_WhenOneOfTheInputIsZero() {
            x = 0;
            y = 5;
            LcmAndHcf.hcf(x, y);
        }
        
        @Test(expected = AssertionError.class)
        public void testHcf_WhenFirstInputIsNegative() {
            x = -2;
            y = 5;
            LcmAndHcf.hcf(x, y);
        }
        
        @Test(expected = AssertionError.class)
        public void testHcf_WhenSecondInputIsNegative() {
            x = 2;
            y = -5;
            LcmAndHcf.hcf(x, y);
        }
        
        @Test(expected = AssertionError.class)
        public void testHcf_WhenBothInputsAreNegative() {
            x = -5;
            y = -7;
            LcmAndHcf.hcf(x, y);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForLcm {
        private int x;
        private int y;
        private int expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                                            {1, 2, 2},
                                            {2, 5, 10},
                                            {16, 12, 48}
            });
        }
        
        public ParameterizedTestsForLcm(int x, int y, int expectedOutput) {
            this.x = x;
            this.y = y;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testLcm() {
            int actualOutput = LcmAndHcf.lcm(x, y);
            assertEquals(expectedOutput, actualOutput);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForHcf {
        private int x;
        private int y;
        private int expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                                            {1, 2, 1},
                                            {20, 50, 10},
                                            {16, 12, 4}
            });
        }
        
        public ParameterizedTestsForHcf(int x, int y, int expectedOutput) {
            this.x = x;
            this.y = y;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testHcf() {
            int actualOutput = LcmAndHcf.hcf(x, y);
            assertEquals(expectedOutput, actualOutput);
        }
    }
}
