package interactive_coding_challenges.arrays_and_strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Mike Lowe
 */
public class ReverseStringTests {

    @Test
    public void test_reverse_nullReturnsNull() {
        assertNull(ReverseString.reverse(null));
    }

    @Test
    public void test_reverse_emptyReturnsEmpty() {
        assertEquals("", ReverseString.reverse(""));
    }

    @Test
    public void test_reverse_singleCharReturnsSingleChar() {
        assertEquals("a", ReverseString.reverse("a"));
        assertEquals("b", ReverseString.reverse("b"));
        assertEquals("4", ReverseString.reverse("4"));
    }

    @Test
    public void test_reverse() {
        assertEquals("ba", ReverseString.reverse("ab"));
        assertEquals("123456789", ReverseString.reverse("987654321"));
        assertEquals("racecar", ReverseString.reverse("racecar"));
    }

}