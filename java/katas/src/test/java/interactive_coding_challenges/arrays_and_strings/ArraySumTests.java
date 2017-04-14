package interactive_coding_challenges.arrays_and_strings;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Mike Lowe
 */
public class ArraySumTests {

    @Test(expected = NullPointerException.class)
    public void test_twoSum_null() {
        ArraySum.twoSum(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_twoSum_invalidArraySizeZero() {
        ArraySum.twoSum(new int[0], 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_twoSum_invalidArraySizeOne() {
        ArraySum.twoSum(new int[]{1}, 0);
    }

    @Test
    public void test_twoSum() {
        assertArrayEquals(new int[]{2, 4}, ArraySum.twoSum(new int[]{1, 3, 2, -7, 5}, 7));
    }

}