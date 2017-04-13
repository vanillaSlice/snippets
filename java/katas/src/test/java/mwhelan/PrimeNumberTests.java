package mwhelan;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Mike Lowe
 */
public class PrimeNumberTests {

    private static final Set<Integer> PRIME_NUMBERS = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23,
            29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));

    @Test
    public void test_isPrime_negativeReturnsFalse() {
        assertFalse(PrimeNumber.isPrime(-3));
        assertFalse(PrimeNumber.isPrime(-2));
        assertFalse(PrimeNumber.isPrime(-1));
    }

    @Test
    public void test_isPrime_upTo100() {
        for (int i = 0; i <= 100; i++) {
            boolean expected = PRIME_NUMBERS.contains(i);
            boolean result = PrimeNumber.isPrime(i);
            assertEquals(expected, result);
        }
    }

}