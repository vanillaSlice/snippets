import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mike Lowe
 */
public class UniqueCharsTests {

    @Test
    public void test_hasUniqueChars_null() {
        assertFalse(UniqueChars.hasUniqueChars(null));
    }

    @Test
    public void test_hasUniqueChars_empty() {
        assertTrue(UniqueChars.hasUniqueChars(""));
    }

    @Test
    public void test_hasUniqueChars_true() {
        assertTrue(UniqueChars.hasUniqueChars("a"));
        assertTrue(UniqueChars.hasUniqueChars("ab"));
        assertTrue(UniqueChars.hasUniqueChars("abc"));
        assertTrue(UniqueChars.hasUniqueChars("abcdefABCDEF12345'\n \\"));
    }

    @Test
    public void test_hasUniqueChars_false() {
        assertFalse(UniqueChars.hasUniqueChars("  "));
        assertFalse(UniqueChars.hasUniqueChars("aa"));
        assertFalse(UniqueChars.hasUniqueChars("aBB"));
        assertFalse(UniqueChars.hasUniqueChars("abcdefabcdef"));
    }

}