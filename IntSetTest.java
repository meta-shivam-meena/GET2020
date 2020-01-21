package scf.session6;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Enclosed.class)
public class IntSetTest {

    public static class NonParameterizedTestsForAllMethods {
        
        @Test(expected = AssertionError.class)
        public void testIntSet_WhenInputContainsIntegerGreaterThan1000() {
            int[] nums = new int[]{1, 2, 1001};
            new IntSet(nums);
        }
        
        @Test(expected = AssertionError.class)
        public void testIntSet_WhenInputContainsNegativeInteger() {
            int[] nums = new int[]{1, 2, -5};
            new IntSet(nums);
        }
        
        @Test
        public void testGetComplement() {
            int[] oddIntegersFrom1To1000 = new int[500];
            int[] evenIntegersFrom1To1000 = new int[500];
            IntSet oddSet;
            IntSet evenSet;
            IntSet actualOutput;
            
            for (int i = 0; i < 500; i++) {
                oddIntegersFrom1To1000[i] = (i * 2) + 1;
            }
            
            for (int i = 0; i < 500; i++) {
                evenIntegersFrom1To1000[i] = (i * 2) + 2;
            }
            
            oddSet = new IntSet(oddIntegersFrom1To1000);
            evenSet = new IntSet(evenIntegersFrom1To1000);
            actualOutput = oddSet.getComplement();
            assert(evenSet.isSubSet(actualOutput));
            assert(actualOutput.isSubSet(evenSet));
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForIsMember {
        IntSet intSet;
        int key;
        boolean expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                    {new IntSet(new int[]{1, 3, 2}), 1, true},
                    {new IntSet(new int[]{1, 15}), 10, false},
                    {new IntSet(new int[]{11, 14, 1000}), 1000, true}
            });
        }
        
        public ParameterizedTestsForIsMember(IntSet intSet, int key,
                                        boolean expectedOutput) {
            this.intSet = intSet;
            this.key = key;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testIsMember() {
            boolean actualOutput = intSet.isMember(key);
            assertEquals(expectedOutput, actualOutput);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForSize {
        IntSet intSet;
        int expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                    {new IntSet(new int[]{1, 3, 2}), 3},
                    {new IntSet(new int[]{1, 2, 2, 15}), 3},
                    {new IntSet(new int[]{1, 1, 1}), 1}
            });
        }
        
        public ParameterizedTestsForSize(IntSet intSet, int expectedOutput) {
            this.intSet = intSet;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testSize() {
            int actualOutput = intSet.size();
            assertEquals(expectedOutput, actualOutput);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForIsSubSet {
        IntSet intSet;
        IntSet subSet;
        boolean expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                    {new IntSet(new int[]{1, 2, 2, 3}), new IntSet(new int[]{1, 1}), true},
                    {new IntSet(new int[]{1, 3, 5, 7, 9}), new IntSet(new int[]{1, 2, 3}), false}
            });
        }
        
        public ParameterizedTestsForIsSubSet(IntSet intSet, IntSet subSet,
                                        boolean expectedOutput) {
            this.intSet = intSet;
            this.subSet = subSet;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testIsSubSet() {
            boolean actualOutput = intSet.isSubSet(subSet);
            assertEquals(expectedOutput, actualOutput);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForCheckingSizeOfOutputOfGetComplement {
        IntSet intSet;
        int sizeOfExpectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                    {new IntSet(new int[]{1, 2, 3}), 997},
                    {new IntSet(new int[]{}), 1000}
            });
        }
        
        public ParameterizedTestsForCheckingSizeOfOutputOfGetComplement(
                                        IntSet intSet, int sizeOfExpectedOutput) {
            this.intSet = intSet;
            this.sizeOfExpectedOutput = sizeOfExpectedOutput;
        }
        
        @Test
        public void testSizeOfOutputOfGetComplement() {
            IntSet actualOutput = intSet.getComplement();
            assertEquals(sizeOfExpectedOutput, actualOutput.size());
        }
    }
    
    @RunWith(Parameterized.class)
    public static class ParameterizedTestsForUnion {
        IntSet emptySet = new IntSet(new int[0]);
        IntSet set1;
        IntSet set2;
        IntSet expectedOutput;
        
        @Parameterized.Parameters
        public static Collection<Object[]> input() {
            return Arrays.asList(new Object[][]{
                                            {
                    new IntSet(new int[]{1, 2, 3}),
                    new IntSet(new int[]{4, 5, 6}),
                    new IntSet(new int[]{1, 2, 3, 4, 5, 6})
                                            }
            });
        }
        
        public ParameterizedTestsForUnion(IntSet set1, IntSet set2,
                                        IntSet expectedOutput) {
            this.set1 = set1;
            this.set2 = set2;
            this.expectedOutput = expectedOutput;
        }
        
        @Test
        public void testUnion() {
            IntSet actualOutput = emptySet.union(set1, set2);
            assert(expectedOutput.isSubSet(actualOutput));
            assert(actualOutput.isSubSet(expectedOutput));
        }
    }
}
