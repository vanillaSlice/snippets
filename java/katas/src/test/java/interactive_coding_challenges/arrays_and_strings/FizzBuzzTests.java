package interactive_coding_challenges.arrays_and_strings;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Mike Lowe
 */
public class FizzBuzzTests {

    @Test(expected = IllegalArgumentException.class)
    public void test_fizzBuzz_lessThan1() {
        FizzBuzz.fizzBuzz(0);
    }

    @Test
    public void test_fizzBuzz() {
        String[] expected = {"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14",
                "FizzBuzz"};
        assertArrayEquals(expected, FizzBuzz.fizzBuzz(15));
    }

}