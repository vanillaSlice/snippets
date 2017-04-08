import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mike Lowe
 */
public class AnagramsTests {

    @Test
    public void test_canGetAnagrams() {
        Anagrams.get("");
    }

    @Test
    public void test_get_nullReturnsEmptySet() {
        assertTrue(Anagrams.get(null).isEmpty());
    }

    @Test
    public void test_get_emptyStringReturnsSetWithSingleValue() {
        assertions(Anagrams.get(""), 1, "");
    }

    private void assertions(Set<String> anagrams, int expectedSize, String... expectedAnagrams) {
        assertEquals(expectedSize, anagrams.size());
        for (String expectedAnagram : expectedAnagrams) {
            assertTrue(anagrams.contains(expectedAnagram));
        }
    }

    @Test
    public void test_get_singleCharStringReturnsSetWithSingleValue() {
        assertions(Anagrams.get("a"), 1, "a");
        assertions(Anagrams.get("Z"), 1, "Z");
        assertions(Anagrams.get("\n"), 1, "\n");
    }

    @Test
    public void test_get_twoCharStringReturnsSetWithTwoValues() {
        assertions(Anagrams.get("ab"), 2, "ab", "ba");
        assertions(Anagrams.get("CD"), 2, "CD", "DC");
        assertions(Anagrams.get("z\n"), 2, "z\n", "\nz");
    }

    @Test
    public void test_get_threeCharStringReturnsSetWithSixValues() {
        assertions(Anagrams.get("abc"), 6, "abc", "acb", "bac", "bca", "cab", "cba");
        assertions(Anagrams.get("DEF"), 6, "DEF", "DFE", "EDF", "EFD", "FDE", "FED");
        assertions(Anagrams.get("y\nz"), 6, "y\nz", "yz\n", "\nyz", "\nzy", "z\ny", "zy\n");
    }

    @Test
    public void test_get_withDuplicateChars() {
        assertions(Anagrams.get("AA"), 1, "AA");
        assertions(Anagrams.get("bbc"), 3, "bbc", "bcb", "cbb");
    }

}