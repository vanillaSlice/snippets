package mwhelan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mike Lowe
 */
public class FizzBuzzWhizzTests {

    private FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();

    @Test
    public void test_evaluate_1Returns1() {
        assertEquals("1", fizzBuzzWhizz.evaluate(1));
    }

    @Test
    public void test_evaluate_2ReturnsWhizz() {
        assertEquals("Whizz", fizzBuzzWhizz.evaluate(2));
    }

    @Test
    public void test_evaluate_3ReturnsFizzWhizz() {
        assertEquals("FizzWhizz", fizzBuzzWhizz.evaluate(3));
    }

    @Test
    public void test_evaluate_4Returns4() {
        assertEquals("4", fizzBuzzWhizz.evaluate(4));
    }

    @Test
    public void test_evaluate_5ReturnsBuzzWhizz() {
        assertEquals("BuzzWhizz", fizzBuzzWhizz.evaluate(5));
    }

    @Test
    public void test_evaluate_6ReturnsFizz() {
        assertEquals("Fizz", fizzBuzzWhizz.evaluate(6));
    }

    @Test
    public void test_evaluate_7ReturnsWhizz() {
        assertEquals("Whizz", fizzBuzzWhizz.evaluate(7));
    }

    @Test
    public void test_evaluate_8Returns8() {
        assertEquals("8", fizzBuzzWhizz.evaluate(8));
    }

    @Test
    public void test_evaluate_9ReturnsFizz() {
        assertEquals("Fizz", fizzBuzzWhizz.evaluate(9));
    }

    @Test
    public void test_evaluate_10ReturnsBuzz() {
        assertEquals("Buzz", fizzBuzzWhizz.evaluate(10));
    }

    @Test
    public void test_evaluate_11ReturnsWhizz() {
        assertEquals("Whizz", fizzBuzzWhizz.evaluate(11));
    }

    @Test
    public void test_evaluate_15ReturnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzzWhizz.evaluate(15));
    }

    @Test
    public void test_evaluate_20ReturnsBuzz() {
        assertEquals("Buzz", fizzBuzzWhizz.evaluate(20));
    }

    @Test
    public void test_evaluate_30ReturnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzzWhizz.evaluate(30));
    }

}