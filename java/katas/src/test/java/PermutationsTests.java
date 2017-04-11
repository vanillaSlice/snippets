import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Mike Lowe
 */
public class PermutationsTests {

    @Test
    public void test_isPermutation_nullReturnsFalse() {
        assertFalse(Permutations.isPermutation(null, "test"));
        assertFalse(Permutations.isPermutation("test", null));
        assertFalse(Permutations.isPermutation(null, null));
    }

    @Test
    public void test_isPermutation_emptyStringReturnsFalse() {
        assertFalse(Permutations.isPermutation("", "test"));
        assertFalse(Permutations.isPermutation("test", ""));
        assertFalse(Permutations.isPermutation("", ""));
    }

    @Test
    public void test_isPermutation_caseSensitive() {
        assertFalse(Permutations.isPermutation("a", "A"));
        assertFalse(Permutations.isPermutation("abc", "ABC"));
        assertFalse(Permutations.isPermutation("a B", "a b"));
    }

    @Test
    public void test_isPermutation() {
        assertTrue(Permutations.isPermutation("test", "test"));
        assertTrue(Permutations.isPermutation("test", "stet"));
        assertTrue(Permutations.isPermutation("abc", "cba"));
        assertTrue(Permutations.isPermutation("1 2 3", "  123"));
    }

    @Test
    public void test_isPermutation_false() {
        assertFalse(Permutations.isPermutation("test", "test "));
        assertFalse(Permutations.isPermutation("abc", "abbc"));
        assertFalse(Permutations.isPermutation("44", "444"));
    }

}