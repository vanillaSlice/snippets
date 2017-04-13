package interactive_coding_challenges.arrays_and_strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mike Lowe
 */
public class DifferentCharTests {

    @Test(expected = NullPointerException.class)
    public void test_findDiff_nulls1() {
        DifferentChar.findDiff(null, "test");
    }

    @Test(expected = NullPointerException.class)
    public void test_findDiff_nulls2() {
        DifferentChar.findDiff("test", null);
    }

    @Test
    public void test_findDiff() {
        assertEquals('e', DifferentChar.findDiff("abcd", "abcde"));
        assertEquals('e', DifferentChar.findDiff("abcde", "abcd"));
        assertEquals('a', DifferentChar.findDiff("abcde", "bcde"));
        assertEquals('a', DifferentChar.findDiff("bcde", "abcde"));
        assertEquals('c', DifferentChar.findDiff("abcdef", "abdef"));
        assertEquals('c', DifferentChar.findDiff("abdef", "abcdef"));
        assertEquals('e', DifferentChar.findDiff("aaabbcdd", "abdbacade"));
        assertEquals('e', DifferentChar.findDiff("abdbacade", "aaabbcdd"));
    }

}