package mwhelan;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * @author Mike Lowe
 */
public class StringCalculatorTests {

    @Test
    public void test_add_emptyReturns0() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void test_add_1NumberReturnsSameValue() {
        assertEquals(1, StringCalculator.add("1"));
        assertEquals(32, StringCalculator.add("32"));
        assertEquals(256, StringCalculator.add("256"));
        assertEquals(986, StringCalculator.add("986"));
    }

    @Test
    public void test_add_2NumbersReturnsSumWithCommaDelimiter() {
        assertEquals(2, StringCalculator.add("1,1"));
        assertEquals(34, StringCalculator.add("32,2"));
    }

    @Test
    public void test_add_2NumbersReturnsSumWithNewLineDelimiter() {
        assertEquals(2, StringCalculator.add("1\n1"));
        assertEquals(34, StringCalculator.add("32\n2"));
    }

    @Test
    public void test_add_2NumbersReturnsSumWithCustomDelimiter() {
        assertEquals(2, StringCalculator.add("//;\n1;1"));
        assertEquals(34, StringCalculator.add("//;\n32;2"));
    }

    @Test
    public void test_add_unknownAmountOfNumbersWithCommaDelimiter() {
        assertEquals(7, StringCalculator.add("3,2,2"));
        assertEquals(12, StringCalculator.add("0,0,1,11"));
        assertEquals(50, StringCalculator.add("10,10,10,10,10"));
    }

    @Test
    public void test_add_unknownAmountOfNumbersWithNewLineDelimiter() {
        assertEquals(7, StringCalculator.add("3\n2\n2"));
        assertEquals(12, StringCalculator.add("0\n0\n1\n11"));
        assertEquals(50, StringCalculator.add("10\n10\n10\n10\n10"));
    }

    @Test
    public void test_add_unknownAmountOfNumbersWithCustomDelimiter() {
        assertEquals(7, StringCalculator.add("//;\n3;2;2"));
        assertEquals(12, StringCalculator.add("//;\n0;0;1;11"));
        assertEquals(50, StringCalculator.add("//;\n10;10;10;10;10"));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_add_negativesThrowException() {
        expectedException.expect(IllegalArgumentException.class);
        StringCalculator.add("-1");
        expectedException.expectMessage(String.format("negatives not allowed: [%d];", -1));
        StringCalculator.add("-15,-30");
        expectedException.expectMessage(String.format("negatives not allowed: [%d, %d];", -15, -30));
        StringCalculator.add("-20,10,80,-19,-25");
        expectedException.expectMessage(String.format("negatives not allowed: [%d, %d, %d];", -20, -19, -25));
    }

    @Test
    public void test_add_ignoreNumbersGreaterThan1000() {
        assertEquals(2, StringCalculator.add("2,1001"));
        assertEquals(1000, StringCalculator.add("1002,1000"));
        assertEquals(999, StringCalculator.add("998,1,1001"));
    }

}