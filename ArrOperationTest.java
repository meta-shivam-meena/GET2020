package scf.session4;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ArrOperationTest {

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
    
    public ArrOperationTest(int[] numbers, int expectedOutput) {
        this.numbers = numbers;
        this.expectedOutput = expectedOutput;
    }
    
    //TestFixXY_whenLengthIsZero_ThrowsException()
    @Test(expected = AssertionError.class)
    public void testMaxMirror_whenArrayLength() {
        int[] emptyArray = new int[0];
        int actualOutput = ArrOperation.maxMirror(emptyArray);
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    public void testMaxMirror() {
        int actualOutput = ArrOperation.maxMirror(numbers);
        assertEquals(expectedOutput, actualOutput);
    }
}
