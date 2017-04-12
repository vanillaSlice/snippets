import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mike Lowe
 */
public class CompressStringTests {

    @Test
    public void test_compress_nullReturnsNull() {
        assertNull(CompressString.compress(null));
    }

    @Test
    public void test_compress_emptyReturnsEmpty() {
        assertEquals("", CompressString.compress(""));
    }

    @Test
    public void test_compress_redundantCompression() {
        assertEquals("a", CompressString.compress("a"));
        assertEquals("aa", CompressString.compress("aa"));
        assertEquals("ab", CompressString.compress("ab"));
        assertEquals("aab", CompressString.compress("aab"));
        assertEquals("abc", CompressString.compress("abc"));
        assertEquals("aabbc", CompressString.compress("aabbc"));
        assertEquals("aabbcc", CompressString.compress("aabbcc"));
    }

    @Test
    public void test_compress() {
        assertEquals("a3bc2d4e", CompressString.compress("aaabccdddde"));
        assertEquals("ba3c2d4", CompressString.compress("baaaccdddd"));
        assertEquals("a3ba2c2d4", CompressString.compress("aaabaaccdddd"));
    }

}