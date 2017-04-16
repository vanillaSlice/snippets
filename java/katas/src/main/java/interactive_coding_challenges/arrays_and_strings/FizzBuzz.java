package interactive_coding_challenges.arrays_and_strings;

/**
 * PROBLEM:
 * Implement Fizz Buzz.
 *
 * @author Mike Lowe
 */
public class FizzBuzz {

    // don't want instances
    private FizzBuzz() {
    }

    public static String[] fizzBuzz(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("num cannot be less than 1 but was " + num);
        }
        String[] output = new String[15];
        for (int i = 1; i <= num; i++) {
            output[i - 1] = getOutputString(i);
        }
        return output;
    }

    private static String getOutputString(int num) {
        boolean isDivisibleBy3 = num % 3 == 0;
        boolean isDivisibleBy5 = num % 5 == 0;
        if (isDivisibleBy3 && isDivisibleBy5) {
            return "FizzBuzz";
        } else if (isDivisibleBy3) {
            return "Fizz";
        } else if (isDivisibleBy5) {
            return "Buzz";
        } else {
            return Integer.toString(num);
        }
    }

}