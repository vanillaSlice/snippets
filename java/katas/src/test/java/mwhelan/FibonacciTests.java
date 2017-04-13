package mwhelan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mike Lowe
 */
public class FibonacciTests {

    @Test
    public void test_calculate_0Returns0() {
        assertEquals(0, Fibonacci.calculate(0));
    }

    @Test
    public void test_calculate_1Returns1() {
        assertEquals(1, Fibonacci.calculate(1));
    }

    @Test
    public void test_calculate_2Returns1() {
        assertEquals(1, Fibonacci.calculate(2));
    }

    @Test
    public void test_calculate_3Returns2() {
        assertEquals(2, Fibonacci.calculate(3));
    }

    @Test
    public void test_calculate_4Returns3() {
        assertEquals(3, Fibonacci.calculate(4));
    }

    @Test
    public void test_calculate_5Returns5() {
        assertEquals(5, Fibonacci.calculate(5));
    }

    @Test
    public void test_calculate_6Returns8() {
        assertEquals(8, Fibonacci.calculate(6));
    }

    @Test
    public void test_calculate_7Returns13() {
        assertEquals(13, Fibonacci.calculate(7));
    }

    @Test
    public void test_calculate_8Returns21() {
        assertEquals(21, Fibonacci.calculate(8));
    }

    @Test
    public void test_calculate_9Returns34() {
        assertEquals(34, Fibonacci.calculate(9));
    }

    @Test
    public void test_calculate_30Returns832040() {
        assertEquals(832040, Fibonacci.calculate(30));
    }

}