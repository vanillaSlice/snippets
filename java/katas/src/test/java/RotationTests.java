import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Mike Lowe
 */
public class RotationTests {

    @Test
    public void test_isRotation_nullReturnsFalse() {
        assertFalse(Rotation.isRotation(null, "test"));
        assertFalse(Rotation.isRotation("test", null));
        assertFalse(Rotation.isRotation(null, null));
    }

    @Test
    public void test_isRotation_stringsDifferingInSizeReturnFalse() {
        assertFalse(Rotation.isRotation("", " "));
        assertFalse(Rotation.isRotation("ab", "ab "));
        assertFalse(Rotation.isRotation("abc", "cabd"));
    }

    @Test
    public void test_isRotation_false() {
        assertFalse(Rotation.isRotation("abc", "cba"));
        assertFalse(Rotation.isRotation("test", "etts"));
        assertFalse(Rotation.isRotation("123", "456"));
    }

    @Test
    public void test_isRotation_true() {
        assertTrue(Rotation.isRotation("", ""));
        assertTrue(Rotation.isRotation("abc", "abc"));
        assertTrue(Rotation.isRotation("test ", "st te"));
        assertTrue(Rotation.isRotation("foobarbaz", "barbazfoo"));
    }

}