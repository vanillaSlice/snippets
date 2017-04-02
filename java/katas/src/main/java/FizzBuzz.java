/**
 * PROBLEM
 * Given a number i return:
 * - "Fizz" if i is divisible by 3
 * - "Buzz" if i is divisible by 5
 * - "FizzBuzz" if i is divisible by 3 and 5
 * - i as a string if i does not meet any of these conditions
 *
 * @author Mike Lowe
 */
public class FizzBuzz {

    public String evaluate(int i) {
        boolean isDivisibleBy3 = isDivisibleBy3(i);
        boolean isDivisibleBy5 = isDivisibleBy5(i);
        if (isDivisibleBy3 && isDivisibleBy5) {
            return "FizzBuzz";
        } else if (isDivisibleBy3) {
            return "Fizz";
        } else if (isDivisibleBy5) {
            return "Buzz";
        }
        return Integer.toString(i);
    }

    private boolean isDivisibleBy3(int i) {
        return i % 3 == 0;
    }

    private boolean isDivisibleBy5(int i) {
        return i % 5 == 0;
    }

}