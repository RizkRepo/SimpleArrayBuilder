import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumbersTest {

    private Numbers numbers;
    /**
     * The Numbers class provides an array-based storage for floating-point values.
     * The addValue method adds a new float value to this storage after doubling it,
     * if there is space available in the array.
     */
    public void setUp(){
        numbers = new Numbers();
    }

    @Test
    public void testAddValueSuccess() {
        // Test adding a value successfully
        Numbers numbers = new Numbers(3);
        numbers.addValue(2.5f);

        // Assert that the value is added correctly (doubled: 2.5 * 2 = 5.0)
        assertEquals("Values:\n5.00\n", numbers.toString());
    }

    @Test
    public void testAddValueArrayFull() {
        // Test adding a value when the array is full
        Numbers numbers = new Numbers(2);
        numbers.addValue(2.0f);
        numbers.addValue(3.0f);

        // Try to add a value when the array is full
        numbers.addValue(4.0f);

        // Assert that only 2 values are stored, and no deviations occurred
        assertEquals("Values:\n4.00\n6.00\n", numbers.toString());
    }

    @Test
    public void testAddValueHandlesMultipleInputs() {
        // Test adding multiple values while respecting array capacity
        Numbers numbers = new Numbers(4);
        numbers.addValue(1.0f);
        numbers.addValue(2.0f);
        numbers.addValue(3.0f);
        numbers.addValue(4.0f);

        // Assert that all values are doubled and added correctly
        assertEquals("Values:\n2.00\n4.00\n6.00\n8.00\n", numbers.toString());
    }

    @Test
    public void testAddValueHandlesZero() {
        // Test adding zero
        Numbers numbers = new Numbers(1);
        numbers.addValue(0.0f);

        // Assert the value is added correctly
        assertEquals("Values:\n0.00\n", numbers.toString());
    }

    @Test
    public void testAddValueHandlesNegativeNumber() {
        // Test adding a negative number
        Numbers numbers = new Numbers(1);
        numbers.addValue(-3.0f);

        // Assert the value is added correctly (doubled: -3.0 * 2 = -6.0)
        assertEquals("Values:\n-6.00\n", numbers.toString());
    }

    @Test
    public void testCalcAverageWithValues() {
        // Test calculating the average when values are present
        Numbers numbers = new Numbers(4);
        numbers.addValue(1.0f);
        numbers.addValue(2.0f);
        numbers.addValue(3.0f);
        numbers.addValue(4.0f);

        // Assert the average is calculated correctly
        assertEquals(5.0f, numbers.calcAverage(), 0.001f);
    }

    @Test
    public void testCalcAverageWithNoValues() {
        // Test calculating the average when no values are present
        Numbers numbers = new Numbers(4);

        // Assert the average is 0 when there are no values
        assertEquals(0.0f, numbers.calcAverage(), 0.001f);
    }

    @Test
    public void testFindMaxMinWithValues() {
        // Test finding max, min, and modulo when values are present
        Numbers numbers = new Numbers(5);
        numbers.addValue(3.0f);
        numbers.addValue(6.0f);
        numbers.addValue(2.0f);

        // Assert the correct max, min, and modulo
        float[] result = numbers.findMaxMin();
        assertEquals(12.0f, result[0], 0.001f); // max: 6.0 * 2
        assertEquals(4.0f, result[1], 0.001f);  // min: 2.0 * 2
        assertEquals(0.0f, result[2], 0.001f);  // modulo: 12.0 % 4.0
    }

    @Test
    public void testFindMaxMinWithNoValues() {
        // Test finding max, min, and modulo with no values
        Numbers numbers = new Numbers(5);

        // Assert the correct max, min, and modulo
        float[] result = numbers.findMaxMin();
        assertEquals(0.0f, result[0], 0.001f); // max should be 0
        assertEquals(0.0f, result[1], 0.001f); // min should be 0
        assertEquals(-1.0f, result[2], 0.001f); // modulo should be -1
    }

    @Test
    public void testGetFactorialMaxTypical() {
        // Test factorial calculation for typical input values
        Numbers numbers = new Numbers(3);
        numbers.addValue(3.0f); // Doubled to 6
        numbers.addValue(2.0f); // Doubled to 4
        assertEquals(720, numbers.getFactorialMax()); // 6! = 720
    }

    @Test
    public void testGetFactorialMaxNoValues() {
        // Test factorial calculation when no values are added
        Numbers numbers = new Numbers(2);
        assertEquals(0, numbers.getFactorialMax()); // No values, result should be 0
    }

    @Test
    public void testGetFactorialMaxWithBoundary() {
        // Test factorial calculation with boundary values
        Numbers numbers = new Numbers(1);
        numbers.addValue(1.0f); // Doubled to 2
        assertEquals(2, numbers.getFactorialMax()); // 2! = 2
    }
}