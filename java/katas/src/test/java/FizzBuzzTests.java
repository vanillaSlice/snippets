import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mike Lowe
 */
public class FizzBuzzTests {

    private FizzBuzz fizzBuzz;

    @Before
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void test_evaluate_1Returns1() {
        assertEquals("1", fizzBuzz.evaluate(1));
    }

    @Test
    public void test_evaluate_2Returns2() {
        assertEquals("2", fizzBuzz.evaluate(2));
    }

    @Test
    public void test_evaluate_3ReturnsFizz() {
        assertEquals("Fizz", fizzBuzz.evaluate(3));
    }

    @Test
    public void test_evaluate_5ReturnsBuzz() {
        assertEquals("Buzz", fizzBuzz.evaluate(5));
    }

    @Test
    public void test_evaluate_6ReturnsFizz() {
        assertEquals("Fizz", fizzBuzz.evaluate(6));
    }

    @Test
    public void test_evaluate_10ReturnsBuzz() {
        assertEquals("Buzz", fizzBuzz.evaluate(10));
    }

    @Test
    public void test_evaluate_15ReturnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(15));
    }

    @Test
    public void test_evaluate_30ReturnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(30));
    }

}